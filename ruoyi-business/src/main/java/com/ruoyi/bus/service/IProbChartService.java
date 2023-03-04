package com.ruoyi.bus.service;

import com.ruoyi.bus.domain.chartDomain.ChartRModel;

import java.util.List;

public interface IProbChartService {

    /**
     * 查询每月应完成故障数量
     *
     * @return
     */
    public List<ChartRModel> selectMonthlyShouldCompleteProb();

    /**
     * 查询每月实际完成故障数量
     *
     * @return
     */
    public List<ChartRModel> selectMonthlyIsCompletedProb();

    /**
     * 查询每个部门未完成故障数量
     *
     * @return
     */
    public List<ChartRModel> selectDeptProb();

    /**
     * 查询不同亮灯状况的故障数量
     *
     * @return
     */
    public List<ChartRModel> selectLightProb();

    /**
     * 根据数据库更新字典
     *
     */
    public void updateMap(String dictType);

}
