package com.yxb.teaching_assessment.biz.controller;

import com.yxb.teaching_assessment.biz.entity.Clazz;
import com.yxb.teaching_assessment.biz.entity.Globls;
import com.yxb.teaching_assessment.biz.entity.Student;
import com.yxb.teaching_assessment.biz.entity.User;
import com.yxb.teaching_assessment.biz.service.BeforestudentService;
import com.yxb.teaching_assessment.biz.service.ClazzService;
import com.yxb.teaching_assessment.biz.service.StudentService;
import com.yxb.teaching_assessment.biz.service.UserService;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;
import com.yxb.teaching_assessment.biz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "前台学生功能")
@RequestMapping("/beforeStudent")
public class BeforestudentController extends AbstractBaseCtrl {
    @Autowired
    BeforestudentService beforestudentService;

    @GetMapping("/findAll")
    @ApiOperation(value = "查询")
    public ResultVO findAll(@RequestParam("userid")String userid, HttpServletRequest request){
      System.out.println(request.getSession().getAttribute("user"));
       return success(beforestudentService.findAll(userid));
    }

    @GetMapping("/findAllPage")
    @ApiOperation(value = "查询")
    public ResultVO findallPage(@RequestParam("userid")String userid, HttpServletRequest request, @RequestParam ("page") int page,@RequestParam ("limit")int limit){
        System.out.println(request.getSession().getAttribute("user"));
        int count= beforestudentService.findAll(userid).size();
         List<Map> list=beforestudentService.findallPage(userid,page,limit);
        return success(count,list);
    }

}
