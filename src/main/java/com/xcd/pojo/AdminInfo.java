package com.xcd.pojo;

import com.baomidou.mybatisplus.annotation.TableId;

public class AdminInfo {
    @TableId
    private Integer operatorId;

    private String operatorName;

    private String operatorPass;

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "operatorId=" + operatorId +
                ", operatorName='" + operatorName + '\'' +
                ", operatorPass='" + operatorPass + '\'' +
                '}';
    }

    public String getOperatorPass() {
        return operatorPass;
    }

    public void setOperatorPass(String operatorPass) {
        this.operatorPass = operatorPass == null ? null : operatorPass.trim();
    }


}