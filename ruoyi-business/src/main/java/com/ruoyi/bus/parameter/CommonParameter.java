package com.ruoyi.bus.parameter;

import com.ruoyi.bus.domain.chartDomain.ChartRModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommonParameter {

    /**
     *部门字典，key：部门对应的值 ；value：部门名称
     *
     */
    public static Map deptMap = new ConcurrentHashMap();

    /**
     *亮灯字典 key：对应的值 ；value：灯名称
     *
     */
    public static Map lightMap = new ConcurrentHashMap();

    /**
     *月份-预计/实际完成折线表的数据map
     *
     */
    public static Map<String, List> monthlyIsShouldCompleteVolumnMap = new ConcurrentHashMap<>();

    /**
     *部门-未完成数量饼图数据
     *
     */
    public static List<ChartRModel> deptUncompleteProbPie = new ArrayList<>();

    /**
     *亮灯情况-故障数量饼图数据
     *
     */
    public static List<ChartRModel> lightProbNumPie = new ArrayList<>();

    /**
     * 表示 故障id——下一次更新的序号 ，对于流程完成则更新次数变动+1
     *
     */
    public static final Map<Integer,Integer> processUpdateNumMap = new ConcurrentHashMap<>();
}
