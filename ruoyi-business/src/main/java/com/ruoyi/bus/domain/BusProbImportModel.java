package com.ruoyi.bus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

public class BusProbImportModel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 故障id */
    private Long probListId;

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
    private Long probListSource;

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
    private Long probListAta;

    /** 责任部门 */
    @Excel(name = "责任部门")
    private Long deptId;

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

    /** 故障原因 */
    @Excel(name = "故障原因")
    private String probListReason;

    /** 红黄灯状态 */
    @Excel(name = "红黄灯状态")
    private Long probListStatus;

    /** 影响评估 */
    @Excel(name = "影响评估")
    private String probListEvaluation;

    /** 星级 */
    @Excel(name = "星级")
    private Long probStar;

    /** 是否完成 */
    @Excel(name="是否完成")
    private Long probIscompleted;

    /** 是否优化 */
    @Excel(name = "是否优化")
    private Long probIsoptimize;

    /** 不优化问题原因 */
    @Excel(name = "不优化问题原因")
    private String probListClas;

    /** 标签 */
    @Excel(name = "标签")
    private String probListTag;

    /** 备注 */
    @Excel(name = "备注")
    private String probListTips;

    /** 依据 */
    @Excel(name = "星级依据")
    private String probStarBasis;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "星级时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date probStarTime;

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

    /** 内容 */
    @Excel(name = "最终解决措施内容")
    private String probFinalSolution;

    /** MI编号 */
    @Excel(name = "最终解决措施MI编号")
    private String probMi;

    /** 状态 */
    @Excel(name = "最终解决措施状态")
    private String probFinalStatus;

    public BusProbImportModel() {
        setProbIscompleted((long)0);
    }

    public Long getProbListId() {
        return probListId;
    }

    public void setProbListId(Long probListId) {
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

    public Long getProbListSource() {
        return probListSource;
    }

    public void setProbListSource(Long probListSource) {
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

    public Long getProbListAta() {
        return probListAta;
    }

    public void setProbListAta(Long probListAta) {
        this.probListAta = probListAta;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
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

    public String getProbListReason() {
        return probListReason;
    }

    public void setProbListReason(String probListReason) {
        this.probListReason = probListReason;
    }

    public Long getProbListStatus() {
        return probListStatus;
    }

    public void setProbListStatus(Long probListStatus) {
        this.probListStatus = probListStatus;
    }

    public String getProbListEvaluation() {
        return probListEvaluation;
    }

    public void setProbListEvaluation(String probListEvaluation) {
        this.probListEvaluation = probListEvaluation;
    }

    public Long getProbStar() {
        return probStar;
    }

    public void setProbStar(Long probStar) {
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

    public String getProbTempSolution() {
        return probTempSolution;
    }

    public void setProbTempSolution(String probTempSolution) {
        this.probTempSolution = probTempSolution;
    }

    public String getProbTempCat() {
        return probTempCat;
    }

    public void setProbTempCat(String probTempCat) {
        this.probTempCat = probTempCat;
    }

    public String getProbTempFileNum() {
        return probTempFileNum;
    }

    public void setProbTempFileNum(String probTempFileNum) {
        this.probTempFileNum = probTempFileNum;
    }

    public String getProbTempStatus() {
        return probTempStatus;
    }

    public void setProbTempStatus(String probTempStatus) {
        this.probTempStatus = probTempStatus;
    }

    public String getProbFinalSolution() {
        return probFinalSolution;
    }

    public void setProbFinalSolution(String probFinalSolution) {
        this.probFinalSolution = probFinalSolution;
    }

    public String getProbMi() {
        return probMi;
    }

    public void setProbMi(String probMi) {
        this.probMi = probMi;
    }

    public String getProbFinalStatus() {
        return probFinalStatus;
    }

    public void setProbFinalStatus(String probFinalStatus) {
        this.probFinalStatus = probFinalStatus;
    }

    public Long getProbIscompleted() {
        return probIscompleted;
    }

    public void setProbIscompleted(Long probIscompleted) {
        this.probIscompleted = probIscompleted;
    }

    public Long getProbIsoptimize() {
        return probIsoptimize;
    }

    public void setProbIsoptimize(Long probIsoptimize) {
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
}
