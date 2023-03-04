package com.ruoyi.bus.domain.probListDomain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class BusProbProcess {

    private int probProcessId;

    private int probListId;

    private String probListNum;

    private String probListName;

    private String probListDescrip;

    private int probCurrentProcess;

    private int probProcessNum;

    private String probProcessChanger;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date probProcessCompleteTime;

    private BusProbReason busProbReason;

    private List<BusProbTempSolution> busProbTempSolutionList;

    private List<BusProbFinalSolution> busProbFinalSolutionList;

    public int getProbProcessId() {
        return probProcessId;
    }

    public void setProbProcessId(int probProcessId) {
        this.probProcessId = probProcessId;
    }

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

    public int getProbCurrentProcess() {
        return probCurrentProcess;
    }

    public void setProbCurrentProcess(int probCurrentProcess) {
        this.probCurrentProcess = probCurrentProcess;
    }

    public int getProbProcessNum() {
        return probProcessNum;
    }

    public void setProbProcessNum(int probProcessNum) {
        this.probProcessNum = probProcessNum;
    }

    public String getProbProcessChanger() {
        return probProcessChanger;
    }

    public void setProbProcessChanger(String probProcessChanger) {
        this.probProcessChanger = probProcessChanger;
    }

    public Date getProbProcessCompleteTime() {
        return probProcessCompleteTime;
    }

    public void setProbProcessCompleteTime(Date probProcessCompleteTime) {
        this.probProcessCompleteTime = probProcessCompleteTime;
    }

    public BusProbReason getBusProbReason() {
        return busProbReason;
    }

    public void setBusProbReason(BusProbReason busProbReason) {
        this.busProbReason = busProbReason;
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
}
