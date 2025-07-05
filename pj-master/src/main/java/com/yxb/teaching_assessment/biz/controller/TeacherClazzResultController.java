package com.yxb.teaching_assessment.biz.controller;

import com.yxb.teaching_assessment.biz.entity.TeacherClazzCourseIndex;
import com.yxb.teaching_assessment.biz.service.TeacherClazzCourseIndexService;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;
import com.yxb.teaching_assessment.biz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "评教结果保存")
@RequestMapping("/result")
public class TeacherClazzResultController extends AbstractBaseCtrl {
    @Autowired
    TeacherClazzCourseIndexService teacherClazzCourseIndexService;
    @PostMapping("/save")
    @ApiOperation(value = "评价结果保存")
    public ResultVO resultSave(@RequestBody TeacherClazzCourseIndex teacherClazzCourseIndex){
       int ret =teacherClazzCourseIndexService.resultSave(teacherClazzCourseIndex);
        System.out.println(teacherClazzCourseIndex.getTeacherid());
       if(ret==1){
           return success("评教成功");
       }else{
           return  error("评教失败");
       }
    }
}
