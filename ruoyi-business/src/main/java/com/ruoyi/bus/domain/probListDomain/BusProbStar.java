package com.ruoyi.bus.domain.probListDomain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 星级对象 bus_prob_star
 * 
 * @author LiuYuzhou
 * @date 2023-02-23
 */
public class BusProbStar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 星级id */
    private int probStarId;

    /** 对应故障id */
    @Excel(name = "对应故障id")
    private int probListId;

    /** 星级 */
    @Excel(name = "星级")
    private int probStar;

    /** 依据 */
    @Excel(name = "星级依据")
    private String probStarBasis;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "星级时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date probStarTime;

    public int getProbStarId() {
        return probStarId;
    }

    public void setProbStarId(int probStarId) {
        this.probStarId = probStarId;
    }

    public int getProbListId() {
        return probListId;
    }

    public void setProbListId(int probListId) {
        this.probListId = probListId;
    }

    public int getProbStar() {
        return probStar;
    }

    public void setProbStar(int probStar) {
        this.probStar = probStar;
    }

    public String getProbStarBasis() {
        return probStarBasis;
    }

    public void setProbStarBasis(String probStarBasis) {
        this.probStarBasis = probStarBasis;
    }

    public Date getProbStarTime() {
        return probStarTime;
    }

    public void setProbStarTime(Date probStarTime) {
        this.probStarTime = probStarTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("probStarId", getProbStarId())
            .append("probListId", getProbListId())
            .append("probStar", getProbStar())
            .append("probStarBasis", getProbStarBasis())
            .append("probStarTime", getProbStarTime())
            .toString();
    }
}
