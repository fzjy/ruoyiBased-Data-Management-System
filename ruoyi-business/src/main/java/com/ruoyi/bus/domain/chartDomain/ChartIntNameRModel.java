package com.ruoyi.bus.domain.chartDomain;

public class ChartIntNameRModel {

    private int aliasName;

    private long value;

    public int getAliasName() {
        return aliasName;
    }

    public void setAliasName(int aliasName) {
        this.aliasName = aliasName;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ChartIntNameRModel{" +
                "aliasName=" + aliasName +
                ", value=" + value +
                '}';
    }
}
