package com.ruoyi.bus.service.impl;

import java.util.List;

import com.ruoyi.bus.domain.probListDomain.*;
import com.ruoyi.bus.mapper.BusProbSubListMapper;
import com.ruoyi.common.utils.user.CurrentUser;
import com.ruoyi.framework.shiro.session.OnlineSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.bus.mapper.BusProbListMapper;
import com.ruoyi.bus.service.IBusProbListService;
import com.ruoyi.common.core.text.Convert;

import static com.ruoyi.bus.parameter.CommonParameter.processUpdateNumMap;

/**
 * 故障清单Service业务层处理
 * 
 * @author LiuYuzhou
 * @date 2023-02-23
 */
@Service
public class BusProbListServiceImpl implements IBusProbListService
{
    @Autowired
    private BusProbListMapper busProbListMapper;

    @Autowired
    private BusProbSubListMapper busProbSubListMapper;

    /**
     * 查询故障清单
     * 
     * @param probListId 故障清单主键
     * @return 故障清单
     */
    @Override
    public BusProbList selectBusProbListByProbListId(int probListId)
    {
        return busProbListMapper.selectBusProbListByProbListId(probListId);
    }

    @Override
    public BusProbList selectBusProbListWithAllStarByProbListId(int proListId) {
        return busProbListMapper.selectBusProbListWithAllStarByProbListId(proListId);
    }

    /**
     * 查询故障清单列表
     * 
     * @param busProbList 故障清单
     * @return 故障清单
     */
    @Override
    public List<BusProbList> selectBusProbListList(BusProbList busProbList)
    {
        return busProbListMapper.selectBusProbListList(busProbList);
    }

    /**
     * 询故障清单列表以及其子类中的内容
     *
     * @param busProbList
     * @return
     */
    @Override
    public List<BusProbList> selectBusProbListWithSubList(BusProbList busProbList) {
        return busProbListMapper.selectBusProbListWithSubList(busProbList);
    }

    /**
     * 查询历次流程及更改内容
     *
     * @param probListId
     * @return
     */
    @Override
    public List<BusProbProcess> selectAllProcessDetailByProbListId(int probListId) {
        return busProbSubListMapper.selectAllProcessAndChangesByProbListId(probListId);
    }

    /**
     * 新增故障清单,只增加主表和星表
     * 
     * @param busProbList 故障清单
     * @return 结果
     */
    @Transactional
    @Override
    public int insertBusProbList(BusProbList busProbList)
    {
        int rows = busProbListMapper.insertBusProbList(busProbList);
        insertBusProbStar(busProbList);
        return rows;
    }

    /**
     * 修改故障清单和新增星级表
     * 在controller中如果星级和原来一致则设置StarList为null，不一致非null，
     * 这里如果星级非null，则插入星级表，如果null，则不管
     * 
     * @param busProbList 故障清单
     * @return 结果
     */
    @Transactional
    @Override
    public int updateBusProbList(BusProbList busProbList)
    {
        if(busProbList.getBusProbStarList()!=null){
            insertBusProbStar(busProbList);
        }
        return busProbListMapper.updateBusProbList(busProbList);
    }

    /**
     * 修改故障清单副表
     * 如果需要新增流程表（新内容或者前一次通过流程后再次升版），则流程表新增，三表新增，插入对应的流程表序号；
     * 如果不需要新增流程表（前次未通过流程后再次修改），则流程表不动，三表原基础上修改
     *
     * @param busProbProcess 故障清单,内含流程id，如果为空表示需要新增流程
     * @param changerName 当前用户名
     * @return 结果
     */
    @Transactional
    @Override
    public int updateBusProbSubList(BusProbProcess busProbProcess,String changerName)
    {
        int probProcessId = busProbProcess.getProbProcessId();
        if(probProcessId == 0){
            //新建流程类并增加到流程表中，同时自动返回主键到类里面
            busProbProcess.setProbCurrentProcess(1);
            busProbProcess.setProbProcessChanger(changerName);
            busProbProcess.setProbProcessNum(processUpdateNumMap.get(busProbProcess.getProbListId()));
            busProbSubListMapper.insertBusProbProcess(busProbProcess);
            //获取自动返回的新增主键
            int newProbProcessId = busProbProcess.getProbProcessId();
            insertBusProbTempSolution(busProbProcess,newProbProcessId);
            insertBusProbFinalSolution(busProbProcess,newProbProcessId);
            insertBusProbReason(busProbProcess,newProbProcessId);
            return 1;
        }else{
            //删除再插入相对于直接修改有一个好处，就是当原来没有时不用判断是否是新增或还是更新
            busProbSubListMapper.deleteBusProbTempSolutionByProbProcessId(probProcessId);
            insertBusProbTempSolution(busProbProcess,probProcessId);
            busProbSubListMapper.deleteBusProbFinalSolutionByProbProcessId(probProcessId);
            insertBusProbFinalSolution(busProbProcess,probProcessId);
            busProbSubListMapper.deleteBusProbReasonByProbProcessId(probProcessId);
            insertBusProbReason(busProbProcess,probProcessId);
            return 1;
        }
    }

    /**
     * 批量删除故障清单
     * 
     * @param probListIds 需要删除的故障清单主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBusProbListByProbListIds(String probListIds)
    {
        Integer[] probProcessIds = busProbSubListMapper.selectProbProcessIdsByProbListIds(Convert.toStrArray(probListIds));
        busProbSubListMapper.deleteBusProbStarByProbListIds(Convert.toStrArray(probListIds));
        busProbSubListMapper.deleteBusProbTempSolutionByProbProcessIds(probProcessIds);
        busProbSubListMapper.deleteBusProbFinalSolutionByProbProcessIds(probProcessIds);
        busProbSubListMapper.deleteBusProbReasonByProbProcessIds(probProcessIds);
        busProbSubListMapper.deleteBusProbProcessByProbProcessIds(probProcessIds);
        return busProbListMapper.deleteBusProbListByProbListIds(Convert.toStrArray(probListIds));
    }

    /**
     * 据流程主键删除流程及相应更改内容
     * 只有用户与流程更改用户一致，且 状态不是已发布 才可以删除
     *
     * @param busProcessId
     * @return
     */
    @Override
    public int deleteBusProbProcessByBusProcessId(int busProcessId,String loginName) {
        int deleteNum = busProbSubListMapper.deleteBusProbProcessByProbProcessId(busProcessId,loginName);
        if (deleteNum != 0){
            busProbSubListMapper.deleteBusProbReasonByProbProcessId(busProcessId);
            busProbSubListMapper.deleteBusProbTempSolutionByProbProcessId(busProcessId);
            busProbSubListMapper.deleteBusProbFinalSolutionByProbProcessId(busProcessId);
        }
        return deleteNum;
    }


    //新增
    /**
     * 新增星级信息
     *
     * @param busProbList 故障清单对象
     */
    private void insertBusProbStar(BusProbList busProbList)
    {
        List<BusProbStar> busProbStarList = busProbList.getBusProbStarList();
        int probListId = busProbList.getProbListId();
        if (StringUtils.isNotNull(busProbStarList))
        {
            List<BusProbStar> list = new ArrayList<BusProbStar>();
            for (BusProbStar busProbStar : busProbStarList)
            {
                busProbStar.setProbListId(probListId);
                list.add(busProbStar);
            }
            if (list.size() > 0)
            {
                busProbSubListMapper.batchBusProbStar(list);
            }
        }
    }

    /**
     * 新增临时措施信息
     *
     * @param busProbProcess 流程对象
     * @param probProcessId 流程主键id
     */
    private void insertBusProbTempSolution(BusProbProcess busProbProcess,int probProcessId)
    {
        List<BusProbTempSolution> busProbTempSolutionList = busProbProcess.getBusProbTempSolutionList();
        if (StringUtils.isNotNull(busProbTempSolutionList))
        {
            List<BusProbTempSolution> list = new ArrayList<BusProbTempSolution>();
            for (BusProbTempSolution busProbTempSolution : busProbTempSolutionList)
            {
                busProbTempSolution.setProbProcessId(probProcessId);
                list.add(busProbTempSolution);
            }
            if (list.size() > 0)
            {
                busProbSubListMapper.batchBusProbTempSolution(list);
            }
        }
    }

    /**
     * 新增最终措施信息
     * 
     * @param busProbProcess 流程对象
     * @param probProcessId 流程主键id
     */
    private void insertBusProbFinalSolution(BusProbProcess busProbProcess,int probProcessId)
    {
        List<BusProbFinalSolution> busProbFinalSolutionList = busProbProcess.getBusProbFinalSolutionList();
        if (StringUtils.isNotNull(busProbFinalSolutionList))
        {
            List<BusProbFinalSolution> list = new ArrayList<BusProbFinalSolution>();
            for (BusProbFinalSolution busProbFinalSolution : busProbFinalSolutionList)
            {
                busProbFinalSolution.setProbProcessId(probProcessId);
                list.add(busProbFinalSolution);
            }
            if (list.size() > 0)
            {
                busProbSubListMapper.batchBusProbFinalSolution(list);
            }
        }
    }

    /**
     * 新增故障原因信息
     *
     * @param busProbProcess 流程对象
     * @param probProcessId
     */
    private void insertBusProbReason(BusProbProcess busProbProcess,int probProcessId){
        BusProbReason busProbReason = busProbProcess.getBusProbReason();
        if (StringUtils.isNotNull(busProbReason)){
            busProbReason.setProbProcessId(probProcessId);
        }
        busProbSubListMapper.insertBusProbReason(busProbReason);
    }

}
