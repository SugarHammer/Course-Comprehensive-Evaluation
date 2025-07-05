package com.yxb.teaching_assessment.common.token;

public enum RespCode {

    SUCCESS(20000, "请求成功"),
    WARN(-1, "网络异常，请稍后重试");

    private int code;
    private String message;

    RespCode(int code, String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
