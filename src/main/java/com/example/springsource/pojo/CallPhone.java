package com.example.springsource.pojo;

import java.io.Serializable;

public class CallPhone implements Serializable {
    String callPhone;
    String originalPhone;
    Integer id;
    String operateTime;

    public CallPhone(){

    }

    public CallPhone(String callPhone) {
        this.callPhone = callPhone;
        this.originalPhone = callPhone;
    }

    public String getCallPhone() {
        return callPhone;
    }

    public void setCallPhone(String callPhone) {
        this.callPhone = callPhone;
    }

    public String getOriginalPhone() {
        return originalPhone;
    }

    public void setOriginalPhone(String originalPhone) {
        this.originalPhone = originalPhone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public String toString() {
        return "CallPhone{" +
                "callPhone='" + callPhone + '\'' +
                ", originalPhone='" + originalPhone + '\'' +
                ", id=" + id +
                ", operateTime='" + operateTime + '\'' +
                '}';
    }
}
