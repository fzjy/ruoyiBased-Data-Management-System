package com.ruoyi.bus.domain.probListDomain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 最终措施对象 bus_prob_final_solution
 * 
 * @author LiuYuzhou
 * @date 2023-02-23
 */
public class BusProbFinalSolution extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 最终解决措施id */
    private int probFinalSolutionId;

    /** 对应流程id */
    private int probProcessId;

    /** 内容 */
    @Excel(name = "最终解决措施内容")
    private String probFinalSolution;

    /** MI编号 */
    @Excel(name = "最终解决措施MI编号")
    private String probMi;

    /** 状态 */
    @Excel(name = "最终解决措施状态")
    private String probFinalStatus;

    public int getProbFinalSolutionId() {
        return probFinalSolutionId;
    }

    public void setProbFinalSolutionId(int probFinalSolutionId) {
        this.probFinalSolutionId = probFinalSolutionId;
    }

    public int getProbProcessId() {
        return probProcessId;
    }

    public void setProbProcessId(int probProcessId) {
        this.probProcessId = probProcessId;
    }

    public void setProbFinalSolution(String probFinalSolution)
    {
        this.probFinalSolution = probFinalSolution;
    }

    public String getProbFinalSolution() 
    {
        return probFinalSolution;
    }
    public void setProbMi(String probMi) 
    {
        this.probMi = probMi;
    }

    public String getProbMi() 
    {
        return probMi;
    }
    public void setProbFinalStatus(String probFinalStatus) 
    {
        this.probFinalStatus = probFinalStatus;
    }

    public String getProbFinalStatus() 
    {
        return probFinalStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("probFinalSolutionId", getProbFinalSolutionId())
            .append("ProbProcessId", getProbProcessId())
            .append("probFinalSolution", getProbFinalSolution())
            .append("probMi", getProbMi())
            .append("probFinalStatus", getProbFinalStatus())
            .toString();
    }
}
