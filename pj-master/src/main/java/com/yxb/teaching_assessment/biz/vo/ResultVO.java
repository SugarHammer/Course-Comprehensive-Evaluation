package com.yxb.teaching_assessment.biz.vo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@Data
public class ResultVO<T> implements Serializable {

    protected Boolean status;

    protected  String code;

    protected String reason;
    protected  T count;
    protected T data;

    public ResultVO(boolean status, String code, String reason, T data) {
        this.status = status;
        this.code = code;
        this.reason = reason;
        this.data = data;
    }

    public ResultVO(Boolean status, String code, String reason, T count, T data) {
        this.status = status;
        this.code = code;
        this.reason = reason;
        this.count = count;
        this.data = data;
    }

    public ResultVO(boolean status, String code, String reason) {
        this.status = status;
        this.code = code;
        this.reason = reason;
    }

    public ResultVO() {
        this.status = true;
        this.code = "0";
        this.reason = "成功";
    }

    public ResultVO(T count, T data) {
        this();
        this.count = count;
      /*  this.code="0";*/
     /*   this.status=true;*/
        this.data = data;

    }

    public ResultVO(T data) {
        this();
        this.data = data;
    }

    public void failed(){

    }

    public ResultVO authFailed(){
        this.code = "5003";
        this.status = false;
        this.reason = "认证失败";
        return this;
    }
    public ResultVO authError(){
        this.code = "403";
        this.status = false;
        this.reason = "权限不足";
        return this;
    }
    public ResultVO error(String msg){
        this.code = "500";
        this.status = false;
        this.reason = msg;
        return this;
    }
}
