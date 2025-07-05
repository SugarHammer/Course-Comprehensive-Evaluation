package com.yxb.teaching_assessment.biz.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ResultVoPage<T> implements Serializable {
    protected Boolean status;

    protected  String code;

    protected String reason;
    protected  T count;

    protected T data;

    public ResultVoPage(Boolean status, String code, String reason, T count, T data) {
        this.status = status;
        this.code = code;
        this.reason = reason;
        this.count = count;
        this.data = data;
    }

    public ResultVoPage(Boolean status, String code, String reason, T count) {
        this.status = status;
        this.code = code;
        this.reason = reason;
        this.count = count;
    }

    public ResultVoPage(Boolean status, String code, String reason) {
        this.status = status;
        this.code = code;
        this.reason = reason;
    }

    public ResultVoPage(T data) {
        this();
        this.data = data;
    }

    public ResultVoPage(T count, T data) {
        this.count = count;
        this.data = data;
    }

    public ResultVoPage() {
        this.status = true;
        this.code="0";
        this.reason="成功";
    }
   public  ResultVoPage error(String msg){
        this.code="500";
        this.reason=msg;
        this.status=false;
        return  this;
   }
}
