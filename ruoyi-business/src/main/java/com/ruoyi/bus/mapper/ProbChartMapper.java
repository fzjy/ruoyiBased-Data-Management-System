package com.ruoyi.bus.mapper;

import com.ruoyi.bus.domain.utilDomain.SysDictKVModel;
import com.ruoyi.bus.domain.chartDomain.ChartRModel;

import java.util.List;

public interface ProbChartMapper {

    /**
     * 获取月份-预计完成折线表的数据
     *
     * @return
     */
    public List<ChartRModel> selectMonthlyShouldCompleteProb();

    /**
     * 获取月份-实际完成折线表的数据
     *
     * @return
     */
    public List<ChartRModel> selectMonthlyIsCompletedProb();

    /**
     * 实际获取部门-未完成数量饼图
     *
     * @return
     */
    public List<ChartRModel> selectDeptProb();

    /**
     * 实际获取亮灯情况-故障数量饼图
     *
     * @return
     */
    public List<ChartRModel> selectLightProb();


    /**
     * 获取字典数据表中label-value键值对
     *
     * @return
     */
    public List<SysDictKVModel> selectSysDictKV(String dictType);
}
