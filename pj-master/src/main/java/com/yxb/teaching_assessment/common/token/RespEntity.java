package com.yxb.teaching_assessment.common.token;

public class RespEntity {
    private int code;
    private String message;
    private Object data;

    public RespEntity(RespCode respCode) {
        this.code = respCode.getCode();
        this.message = respCode.getMessage();
    }

    public RespEntity(RespCode respCode, Object data) {
        this(respCode);
        this.data = data;
    }

}
