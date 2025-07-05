package com.yxb.teaching_assessment.biz.vo;

import lombok.Data;

import java.util.List;

/**
 */
@Data
public class LoginSuccessVO {

    private String userId;


    private String userPhone;


    private List<String> roles;


    private String userMobile;
}
