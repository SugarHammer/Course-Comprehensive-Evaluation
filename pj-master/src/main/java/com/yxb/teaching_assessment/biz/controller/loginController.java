package com.yxb.teaching_assessment.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
    @RequestMapping("/login")
    public  String login(){
        return "Login";
    }
}
