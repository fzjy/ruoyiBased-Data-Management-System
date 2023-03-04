package com.ruoyi.bus.domain.probListDomain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 故障清单对象 bus_prob_list
 * 
 * @author LiuYuzhou
 * @date 2023-02-23
 */
public class BusProbList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 故障id */
    private int probListId;

    /** 故障编号 */
    @Excel(name = "故障编号")
    private String probListNum;

    /** 故障名称 */
    @Excel(name = "故障名称")
    private String probListName;

    /** 信息描述 */
    @Excel(name = "信息描述")
    private String probListDescrip;

    /** 信息来源 */
    @Excel(name = "信息来源")
    private int probListSource;

    /** 提出时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提出时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date probListStartTime;

    /** 预计完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date probListEndTime;

    /** ATA */
    @Excel(name = "ATA")
    private int probListAta;

    /** 责任部门 */
    @Excel(name = "责任部门")
    private int deptId;

    /** 实际完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date probListActualEndTime;

    /** 专业负责人 */
    @Excel(name = "专业负责人")
    private String probListHead;

    /** 部门负责人 */
    @Excel(name = "部门负责人")
    private String probListOurHead;

    /** 红黄灯状态 */
    @Excel(name = "红黄灯状态")
    private int probListStatus;

    /** 影响评估 */
    @Excel(name = "影响评估")
    private String probListEvaluation;

    /** 星级 */
    @Excel(name = "星级")
    private int probStar;

    /** 是否完成 */
    @Excel(name="是否完成")
    private int probIscompleted;

    /** 是否优化 */
    @Excel(name = "是否优化")
    private int probIsoptimize;

    /** 不优化问题原因 */
    @Excel(name = "不优化问题原因")
    private String probListClas;

    /** 标签 */
    @Excel(name = "标签")
    private String probListTag;

    /** 备注 */
    @Excel(name = "备注")
    private String probListTips;

    /** 故障原因信息 */
    private BusProbReason busProbReason;

    /** 星级信息 */
    private List<BusProbStar> busProbStarList;

    /** 临时措施信息 */
    private List<BusProbTempSolution> busProbTempSolutionList;

    /** 最终措施信息 */
    private List<BusProbFinalSolution> busProbFinalSolutionList;

    public int getProbListId() {
        return probListId;
    }

    public void setProbListId(int probListId) {
        this.probListId = probListId;
    }

    public String getProbListNum() {
        return probListNum;
    }

    public void setProbListNum(String probListNum) {
        this.probListNum = probListNum;
    }

    public String getProbListName() {
        return probListName;
    }

    public void setProbListName(String probListName) {
        this.probListName = probListName;
    }

    public String getProbListDescrip() {
        return probListDescrip;
    }

    public void setProbListDescrip(String probListDescrip) {
        this.probListDescrip = probListDescrip;
    }

    public int getProbListSource() {
        return probListSource;
    }

    public void setProbListSource(int probListSource) {
        this.probListSource = probListSource;
    }

    public Date getProbListStartTime() {
        return probListStartTime;
    }

    public void setProbListStartTime(Date probListStartTime) {
        this.probListStartTime = probListStartTime;
    }

    public Date getProbListEndTime() {
        return probListEndTime;
    }

    public void setProbListEndTime(Date probListEndTime) {
        this.probListEndTime = probListEndTime;
    }

    public int getProbListAta() {
        return probListAta;
    }

    public void setProbListAta(int probListAta) {
        this.probListAta = probListAta;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public Date getProbListActualEndTime() {
        return probListActualEndTime;
    }

    public void setProbListActualEndTime(Date probListActualEndTime) {
        this.probListActualEndTime = probListActualEndTime;
    }

    public String getProbListHead() {
        return probListHead;
    }

    public void setProbListHead(String probListHead) {
        this.probListHead = probListHead;
    }

    public String getProbListOurHead() {
        return probListOurHead;
    }

    public void setProbListOurHead(String probListOurHead) {
        this.probListOurHead = probListOurHead;
    }

    public int getProbListStatus() {
        return probListStatus;
    }

    public void setProbListStatus(int probListStatus) {
        this.probListStatus = probListStatus;
    }

    public String getProbListEvaluation() {
        return probListEvaluation;
    }

    public void setProbListEvaluation(String probListEvaluation) {
        this.probListEvaluation = probListEvaluation;
    }

    public int getProbStar() {
        return probStar;
    }

    public void setProbStar(int probStar) {
        this.probStar = probStar;
    }

    public int getProbIscompleted() {
        return probIscompleted;
    }

    public void setProbIscompleted(int probIscompleted) {
        this.probIscompleted = probIscompleted;
    }

    public int getProbIsoptimize() {
        return probIsoptimize;
    }

    public void setProbIsoptimize(int probIsoptimize) {
        this.probIsoptimize = probIsoptimize;
    }

    public String getProbListClas() {
        return probListClas;
    }

    public void setProbListClas(String probListClas) {
        this.probListClas = probListClas;
    }

    public String getProbListTag() {
        return probListTag;
    }

    public void setProbListTag(String probListTag) {
        this.probListTag = probListTag;
    }

    public String getProbListTips() {
        return probListTips;
    }

    public void setProbListTips(String probListTips) {
        this.probListTips = probListTips;
    }

    public BusProbReason getBusProbReason() {
        return busProbReason;
    }

    public void setBusProbReason(BusProbReason busProbReason) {
        this.busProbReason = busProbReason;
    }

    public List<BusProbStar> getBusProbStarList() {
        return busProbStarList;
    }

    public void setBusProbStarList(List<BusProbStar> busProbStarList) {
        this.busProbStarList = busProbStarList;
    }

    public List<BusProbTempSolution> getBusProbTempSolutionList() {
        return busProbTempSolutionList;
    }

    public void setBusProbTempSolutionList(List<BusProbTempSolution> busProbTempSolutionList) {
        this.busProbTempSolutionList = busProbTempSolutionList;
    }

    public List<BusProbFinalSolution> getBusProbFinalSolutionList() {
        return busProbFinalSolutionList;
    }

    public void setBusProbFinalSolutionList(List<BusProbFinalSolution> busProbFinalSolutionList) {
        this.busProbFinalSolutionList = busProbFinalSolutionList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("probListId", getProbListId())
            .append("probListNum", getProbListNum())
            .append("probListName", getProbListName())
            .append("getProbIscompleted",getProbIscompleted())
            .append("probListDescrip", getProbListDescrip())
            .append("probListSource", getProbListSource())
            .append("probListStartTime", getProbListStartTime())
            .append("probListEndTime", getProbListEndTime())
            .append("probListAta", getProbListAta())
            .append("deptId", getDeptId())
            .append("probListActualEndTime", getProbListActualEndTime())
            .append("probListHead", getProbListHead())
            .append("probListOurHead", getProbListOurHead())
            .append("probListStatus", getProbListStatus())
            .append("probListEvaluation", getProbListEvaluation())
            .append("probStar", getProbStar())
            .append("probIsoptimize",getProbIsoptimize())
            .append("probListClas", getProbListClas())
            .append("probListTag", getProbListTag())
            .append("probListTips", getProbListTips())
            .append("busProbReason",getBusProbReason())
            .append("busProbStarList", getBusProbStarList())
            .append("busProbTempSolutionList",getBusProbTempSolutionList())
            .append("busProbFinalSolutionList", getBusProbFinalSolutionList())
            .toString();
    }
}
