package com.ruoyi.bus.mapper;

import com.ruoyi.bus.domain.probListDomain.*;

import java.util.List;

/**
 * 副表相关接口
 *
 */
public interface BusProbSubListMapper {

    //新增
    /**
     * 批量新增星级
     *
     * @param busProbStarList 星级列表
     * @return 结果
     */
    public int batchBusProbStar(List<BusProbStar> busProbStarList);

    /**
     * 批量新增临时措施
     *
     * @param busProbTempSolutionList 临时措施列表
     * @return 结果
     */
    public int batchBusProbTempSolution(List<BusProbTempSolution> busProbTempSolutionList);

    /**
     * 批量新增最终措施
     *
     * @param busProbFinalSolutionList 最终措施列表
     * @return 结果
     */
    public int batchBusProbFinalSolution(List<BusProbFinalSolution> busProbFinalSolutionList);

    /**
     * 新增故障原因
     *
     * @param busProbReason
     * @return
     */
    public int insertBusProbReason(BusProbReason busProbReason);

    /**
     * 新增新的流程
     *
     * @param busProbProcess
     * @return
     */
    public int insertBusProbProcess(BusProbProcess busProbProcess);

    /**
     * 根据故障主键id查询所有流程及相应的措施和原因
     *
     * @param probListId
     * @return
     */
    public List<BusProbProcess> selectAllProcessAndChangesByProbListId(int probListId);

    /**
     * 根据故障主键id查询相应的流程id
     *
     * @param probListIds
     * @return
     */
    public Integer[] selectProbProcessIdsByProbListIds(String[] probListIds);

    /**
     * 通过流程主键删除最终措施信息
     *
     * @param probProcessId 流程主键
     * @return 结果
     */
    public int deleteBusProbFinalSolutionByProbProcessId(int probProcessId);

    /**
     * 通过流程主键删除临时措施信息
     *
     * @param probProcessId 流程主键
     * @return
     */
    public int deleteBusProbTempSolutionByProbProcessId(int probProcessId);

    /**
     * 通过流程主键删除故障原因信息
     *
     * @param probProcessId 流程主键
     * @return
     */
    public int deleteBusProbReasonByProbProcessId(int probProcessId);


    /**
     * 通过流程主键和判断当前用户名是否一致删除流程
     *
     * @param probProcessId 流程主键
     * @param loginName 当前用户名
     * @return
     */
    public int deleteBusProbProcessByProbProcessId(int probProcessId,String loginName);

    /**
     * 批量删除星级
     *
     * @param probListIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBusProbStarByProbListIds(String[] probListIds);

    /**
     * 批量删除临时措施
     *
     * @param probProcessIds 需要删除的流程主键集合
     * @return 结果
     */
    public int deleteBusProbTempSolutionByProbProcessIds(Integer[] probProcessIds);

    /**
     * 批量删除最终措施
     *
     * @param probProcessIds 需要删除的流程主键集合
     * @return 结果
     */
    public int deleteBusProbFinalSolutionByProbProcessIds(Integer[] probProcessIds);

    /**
     * 批量删除理由
     *
     * @param probProcessIds 需要删除的流程主键集合
     * @return
     */
    public int deleteBusProbReasonByProbProcessIds(Integer[] probProcessIds);

    /**
     *批量删除流程
     *
     * @param probProcessIds 需要删除的流程主键集合
     * @return
     */
    public int deleteBusProbProcessByProbProcessIds(Integer[] probProcessIds);
}
