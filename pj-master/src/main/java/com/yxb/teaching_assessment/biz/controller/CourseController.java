package com.yxb.teaching_assessment.biz.controller;

import com.yxb.teaching_assessment.biz.entity.Course;
import com.yxb.teaching_assessment.biz.service.CourseService;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;
import com.yxb.teaching_assessment.biz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "课程信息")
@RequestMapping("/course")
public class CourseController extends AbstractBaseCtrl {
    @Autowired
    CourseService courseService;

    @GetMapping("/findAll")
    @ApiOperation(value = "课程列表")
    public ResultVO findAll(){
        return  success(courseService.findAll());
    }

    @PostMapping
    @ApiOperation(value="删除课程")
    public  ResultVO delete(@RequestParam("courseid") String courseid){
        if(courseid==null){
            return error("获取课程失败");
        }else {
            int  ret= courseService.delete(courseid);
            if(ret==1){
                return success("删除成功");
            }else {
                return error("删除失败");
            }
        }

    }

    @PostMapping("/update")
    @ApiOperation(value = "更新课程")
    public  ResultVO update(@RequestBody Course course){
        if(course.getCourseid()==null){
           return error("获取课程失败");
        }else {
            int ret = courseService.update(course);
            if(ret==1){
                return success("更新成功");
            }else {
                return error("更新失败");
            }
        }
    }
    @PostMapping("/save")
    @ApiOperation(value = "增加课程")
    public ResultVO save(@RequestBody Course course){
        int ret = courseService.save(course);
        if(ret==1){
            return success("添加成功");
        }else {
            return error("添加失败");
        }
    }
    @GetMapping("/findAllPage")
    @ApiOperation(value = "分页课程列表")
    public ResultVO findAllPage(@RequestParam("page") int page,@RequestParam("limit") int limit){
        System.out.println(page);
        List<Course> list = courseService.findAllPage(page,limit);
        int count =courseService.findAll().size();
        return  success(count,list);
    }

}
