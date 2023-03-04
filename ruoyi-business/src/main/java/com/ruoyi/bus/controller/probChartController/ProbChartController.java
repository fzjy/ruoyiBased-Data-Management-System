package com.ruoyi.bus.controller.probChartController;

import com.ruoyi.bus.domain.chartDomain.ChartRModel;
import com.ruoyi.bus.service.IProbChartService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.ruoyi.bus.parameter.CommonParameter.*;

/**
 * 图表Controller
 *
 * @author LiuYuzhou
 * @date 2023-02-26
 */
@Controller
@RequestMapping("/ruoyi-business/chart")
public class ProbChartController {

    private String prefix = "ruoyi-business/chart";

    @Autowired
    private IProbChartService iProbChartService;

    /**
     * 跳转到图标页
     *
     * @return
     */
    //@RequiresPermissions("bus:chart:view")
    @RequestMapping()
    public String MonthlyIsShouldCompleteVolumnChart(){
        return prefix + "/showChart";
    }

    /**
     * 返回月份-预计/实际完成折线表的数据。
     *
     * @return
     */
    @RequestMapping("/monthlyVolumnChart")
    @ResponseBody
    public Map<String,List> getMonthlyIsShouldCompleteVolumnChart(){
        if(monthlyIsShouldCompleteVolumnMap==null || monthlyIsShouldCompleteVolumnMap.isEmpty()){
            getMonthlyIsShouldCompleteVolumnData();
        }
        return monthlyIsShouldCompleteVolumnMap;
    }

    @RequestMapping("/deptPieChart")
    @ResponseBody
    public List<ChartRModel> getDeptUncompletePieChart(){
        if(deptUncompleteProbPie == null || deptUncompleteProbPie.isEmpty()){
            getDeptUncompletePieData();
        }
        return deptUncompleteProbPie;
    }

    @RequestMapping("/lightPieChart")
    @ResponseBody
    public List<ChartRModel> getLightProbNumPieChart(){
        if(lightProbNumPie == null || lightProbNumPie.isEmpty()){
            getLightProbNumPieData();
        }
        return lightProbNumPie;
    }


    /**
     * 实际获取月份-预计/实际完成折线表的数据，具体数据放在静态变量中，定时任务每月更新。
     *
     */
    private void getMonthlyIsShouldCompleteVolumnData(){

        List<ChartRModel> monthlyShouldCompleteProbs = iProbChartService.selectMonthlyShouldCompleteProb();
        List<ChartRModel> monthlyIsCompletedProbs = iProbChartService.selectMonthlyIsCompletedProb();
        if (monthlyIsShouldCompleteVolumnMap == null){
            monthlyIsShouldCompleteVolumnMap = new ConcurrentHashMap<>();
        }

        List<String> monthList = new ArrayList<>();
        List<Long> shouldCompleteProbNum = new ArrayList<>();
        List<Long> isCompletedProbNum = new ArrayList<>();

        int iS = 0;
        int iI = 0;
        while(iS < monthlyShouldCompleteProbs.size() && iI < monthlyIsCompletedProbs.size()){
            if (monthlyShouldCompleteProbs.get(iS).getName().compareTo(monthlyIsCompletedProbs.get(iI).getName())==-1 ){
                monthList.add(monthlyShouldCompleteProbs.get(iS).getName());
                shouldCompleteProbNum.add(monthlyShouldCompleteProbs.get(iS).getValue());
                isCompletedProbNum.add((long) 0);
                iS += 1;
            }else if (monthlyShouldCompleteProbs.get(iS).getName().compareTo(monthlyIsCompletedProbs.get(iI).getName()) ==1 ){
                monthList.add(monthlyIsCompletedProbs.get(iI).getName());
                isCompletedProbNum.add(monthlyIsCompletedProbs.get(iI).getValue());
                shouldCompleteProbNum.add((long)0);
                iI += 1;
            }else{
                monthList.add(monthlyIsCompletedProbs.get(iI).getName());
                shouldCompleteProbNum.add(monthlyShouldCompleteProbs.get(iS).getValue());
                isCompletedProbNum.add(monthlyIsCompletedProbs.get(iI).getValue());
                iS += 1;
                iI += 1;
            }
        }
        while(iS < monthlyShouldCompleteProbs.size()){
            monthList.add(monthlyShouldCompleteProbs.get(iS).getName());
            shouldCompleteProbNum.add(monthlyShouldCompleteProbs.get(iS).getValue());
            isCompletedProbNum.add((long) 0);
            iS += 1;
        }
        while (iI < monthlyIsCompletedProbs.size()){
            monthList.add(monthlyIsCompletedProbs.get(iI).getName());
            isCompletedProbNum.add(monthlyIsCompletedProbs.get(iI).getValue());
            shouldCompleteProbNum.add((long)0);
            iI += 1;
        }

        monthlyIsShouldCompleteVolumnMap.put("monthList",monthList);
        monthlyIsShouldCompleteVolumnMap.put("shouldCompleteProbNum",shouldCompleteProbNum);
        monthlyIsShouldCompleteVolumnMap.put("isCompletedProbNum",isCompletedProbNum);

    }

    /**
     * 实际获取部门-未完成数量饼图,定时任务
     *
     */
    private void getDeptUncompletePieData(){

        iProbChartService.updateMap("dept_id");
        deptUncompleteProbPie = iProbChartService.selectDeptProb();
    }

    /**
     * 实际获取亮灯情况-故障数量饼图，定时任务
     *
     */
    private void getLightProbNumPieData(){

        iProbChartService.updateMap("prob_list_status");
        lightProbNumPie = iProbChartService.selectLightProb();
    }
}
