package com.ruoyi.bus.service.impl;

import com.ruoyi.bus.domain.utilDomain.SysDictKVModel;
import com.ruoyi.bus.domain.chartDomain.ChartRModel;
import com.ruoyi.bus.mapper.ProbChartMapper;
import com.ruoyi.bus.service.IProbChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ruoyi.bus.parameter.CommonParameter.deptMap;
import static com.ruoyi.bus.parameter.CommonParameter.lightMap;

@Service
public class ProbChartServiceImpl implements IProbChartService {

    @Autowired
    ProbChartMapper probChartMapper;

    @Override
    public List<ChartRModel> selectMonthlyShouldCompleteProb() {
        return probChartMapper.selectMonthlyShouldCompleteProb();
    }

    @Override
    public List<ChartRModel> selectMonthlyIsCompletedProb() {
        return probChartMapper.selectMonthlyIsCompletedProb();
    }

    @Override
    public List<ChartRModel> selectDeptProb() {
        List<ChartRModel> deptProbs = probChartMapper.selectDeptProb();
        for(ChartRModel deptProb:deptProbs){
            deptProb.setName((String) deptMap.get(deptProb.getName()));
        }
        return deptProbs;
    }

    @Override
    public List<ChartRModel> selectLightProb() {
        List<ChartRModel> lightProbs = probChartMapper.selectLightProb();
        for(ChartRModel lightProb:lightProbs){
            lightProb.setName((String) lightMap.get(lightProb.getName()));
        }
        return lightProbs;
    }

    @Override
    public void updateMap(String dictType) {
        List<SysDictKVModel> deptKVs = probChartMapper.selectSysDictKV(dictType);
        if (dictType.equals("dept_id")){
            for(SysDictKVModel deptKV : deptKVs){
                deptMap.put(deptKV.getValue(),deptKV.getLabel());
            }
        }else if(dictType.equals("prob_list_status")){
            for(SysDictKVModel deptKV : deptKVs){
                lightMap.put(deptKV.getValue(),deptKV.getLabel());
            }
        }
    }




}
