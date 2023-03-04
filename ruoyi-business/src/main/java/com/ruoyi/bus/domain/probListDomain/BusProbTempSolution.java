package com.ruoyi.bus.domain.probListDomain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 临时措施对象 bus_prob_temp_solution
 * 
 * @author LiuYuzhou
 * @date 2023-02-23
 */
public class BusProbTempSolution extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 临时措施id */
    private int probTempSolutionId;

    /** 对应流程id */
    @Excel(name = "对应流程id")
    private int probProcessId;

    /** 临时措施内容 */
    @Excel(name = "临时措施内容")
    private String probTempSolution;

    /** 措施类别 */
    @Excel(name = "临时措施类别")
    private String probTempCat;

    /** 文件编号 */
    @Excel(name = "临时措施文件编号")
    private String probTempFileNum;

    /** 状态 */
    @Excel(name = "临时措施状态")
    private String probTempStatus;

    public int getProbTempSolutionId() {
        return probTempSolutionId;
    }

    public void setProbTempSolutionId(int probTempSolutionId) {
        this.probTempSolutionId = probTempSolutionId;
    }

    public int getProbProcessId() {
        return probProcessId;
    }

    public void setProbProcessId(int probProcessId) {
        this.probProcessId = probProcessId;
    }

    public void setProbTempSolution(String probTempSolution)
    {
        this.probTempSolution = probTempSolution;
    }

    public String getProbTempSolution() 
    {
        return probTempSolution;
    }
    public void setProbTempCat(String probTempCat) 
    {
        this.probTempCat = probTempCat;
    }

    public String getProbTempCat() 
    {
        return probTempCat;
    }
    public void setProbTempFileNum(String probTempFileNum) 
    {
        this.probTempFileNum = probTempFileNum;
    }

    public String getProbTempFileNum() 
    {
        return probTempFileNum;
    }
    public void setProbTempStatus(String probTempStatus) 
    {
        this.probTempStatus = probTempStatus;
    }

    public String getProbTempStatus() 
    {
        return probTempStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("probTempSolutionId", getProbTempSolutionId())
            .append("ProbProcessId", getProbProcessId())
            .append("probTempSolution", getProbTempSolution())
            .append("probTempCat", getProbTempCat())
            .append("probTempFileNum", getProbTempFileNum())
            .append("probTempStatus", getProbTempStatus())
            .toString();
    }
}
