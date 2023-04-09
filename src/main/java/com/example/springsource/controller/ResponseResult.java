/*
 *
 * Copyright (C) 1999-2014 IFLYTEK Inc.All Rights Reserved.
 *
 * FileName：icra.aiobs
 *
 * Description：
 *
 * History：
 * Version   Author      Date            Operation
 * 1.0	     admin    2018/7/1115:28	  Create
 */
package com.example.springsource.controller;

import java.io.Serializable;

public class ResponseResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean success;

    private String message;

    private Object value;

    private boolean flag = true;


    private int ret;

    public static ResponseResult newInstance() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        return responseResult;
    }

    public static ResponseResult successResult(String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setMessage(message);
        return responseResult;
    }

    public static ResponseResult successResult(Object value) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setValue(value);
        return responseResult;
    }

    public static ResponseResult successResult(String message, Object value) {
        ResponseResult responseResult = successResult(value);
        responseResult.setMessage(message);
        return responseResult;
    }

    public static ResponseResult failResult(String message) {
        return failResult(message, null);
    }

    public static ResponseResult failResult(String message, Object value) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(false);
        responseResult.setMessage(message);
        responseResult.setValue(value);
        return responseResult;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setResult(ResponseResult result,boolean success,String message){
        result.setSuccess(success);
        result.setMessage(message);
    }

}
