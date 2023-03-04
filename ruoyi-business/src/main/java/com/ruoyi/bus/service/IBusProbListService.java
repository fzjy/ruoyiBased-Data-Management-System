package com.ruoyi.bus.service;

import java.util.List;
import com.ruoyi.bus.domain.probListDomain.BusProbList;
import com.ruoyi.bus.domain.probListDomain.BusProbProcess;

/**
 * 故障清单Service接口
 * 
 * @author LiuYuzhou
 * @date 2023-02-23
 */
public interface IBusProbListService {
    /**
     * 查询故障清单
     *
     * @param probListId 故障清单主键
     * @return 故障清单
     */
    public BusProbList selectBusProbListByProbListId(int probListId);

    /**
     * 根据主键查询故障清单以及所有的星级信息（用在详细中）
     *
     * @param proListId
     * @return
     */
    public BusProbList selectBusProbListWithAllStarByProbListId(int proListId);

    /**
     * 查询故障清单列表
     *
     * @param busProbList 故障清单
     * @return 故障清单集合
     */
    public List<BusProbList> selectBusProbListList(BusProbList busProbList);

    /**
     * 查询故障清单列表以及其子类中的内容
     *
     * @param busProbList
     * @return
     */
    public List<BusProbList> selectBusProbListWithSubList(BusProbList busProbList);

    /**
     * 查询历次流程及更改内容
     *
     * @param probListId
     * @return
     */
    public List<BusProbProcess> selectAllProcessDetailByProbListId(int probListId);

    /**
     * 新增故障清单，只增加主表和星表
     *
     * @param busProbList 故障清单
     * @return 结果
     */
    public int insertBusProbList(BusProbList busProbList);

    /**
     * 修改故障清单主表和星级
     *
     * @param busProbList 故障清单
     * @return 结果
     */
    public int updateBusProbList(BusProbList busProbList);

    /**
     * 修改故障清单副表
     *
     * @param busProbProcess
     * @param changerName
     * @return
     */
    public int updateBusProbSubList(BusProbProcess busProbProcess, String changerName);

    /**
     * 批量删除故障清单
     *
     * @param probListIds 需要删除的故障清单主键集合
     * @return 结果
     */
    public int deleteBusProbListByProbListIds(String probListIds);

    /**
     * 根据流程主键删除流程及相应更改内容
     *
     * @param busProcessId
     * @param loginName 当前用户
     * @return
     */
    public int deleteBusProbProcessByBusProcessId(int busProcessId,String loginName);

}