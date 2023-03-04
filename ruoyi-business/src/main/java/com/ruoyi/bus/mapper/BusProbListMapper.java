package com.ruoyi.bus.mapper;

import java.util.List;
import com.ruoyi.bus.domain.probListDomain.BusProbList;

/**
 * 主表相关故障清单Mapper接口
 * 
 * @author LiuYuzhou
 * @date 2023-02-23
 */
public interface BusProbListMapper 
{
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
     * 新增故障清单
     * 
     * @param busProbList 故障清单
     * @return 结果
     */
    public int insertBusProbList(BusProbList busProbList);

    /**
     * 修改故障清单
     * 
     * @param busProbList 故障清单
     * @return 结果
     */
    public int updateBusProbList(BusProbList busProbList);

    /**
     * 删除故障清单
     * 
     * @param probListId 故障清单主键
     * @return 结果
     */
    public int deleteBusProbListByProbListId(int probListId);

    /**
     * 批量删除故障清单
     * 
     * @param probListIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBusProbListByProbListIds(String[] probListIds);

    //新增

}
