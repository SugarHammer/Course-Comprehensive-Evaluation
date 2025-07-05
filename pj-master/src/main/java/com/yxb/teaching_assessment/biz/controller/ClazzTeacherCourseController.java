package com.yxb.teaching_assessment.biz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yxb.teaching_assessment.biz.entity.*;
import com.yxb.teaching_assessment.biz.mapper.CourseMapper;
import com.yxb.teaching_assessment.biz.service.*;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;
import com.yxb.teaching_assessment.biz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "课程班级老师关联")
@RequestMapping("/courseTeacher")
public class ClazzTeacherCourseController extends AbstractBaseCtrl {
    @Autowired
    ClazzTeacherCourseService clazzTeacherCourseService;
   @Autowired
    TeacherService teacherService;
   @Autowired
    ClazzService clazzService;
   @Autowired
    CourseService courseService;
   @Autowired
    ClazzCourseService clazzCourseService;

    @GetMapping("findAll")
    @ApiOperation(value = "查询全部")
    public ResultVO findAll(){
     List<TeacherClazzCourse> list;
        list = clazzTeacherCourseService.findAll();
        return success(list);
    }
   @GetMapping("/list")
   @ApiOperation(value = "查询列表")
   public  ResultVO list(){
     List<Map> list= clazzTeacherCourseService.list();
        return success(list);
   }

  @GetMapping("/delete")
  @ApiOperation(value = "删除关系")
    public ResultVO delete(@RequestParam("tccid") String tccid){
         int ret=clazzTeacherCourseService.delete(tccid);
        if(ret==1){
           return  success("删除成功");
        }else {
            return error("删除失败");
        }
  }


    @PostMapping("/add")
    @ApiOperation(value = "添加关系")
    public ResultVO add(@RequestBody TeacherClazzCourse clazzCourse){
        int ret  =clazzTeacherCourseService.add(clazzCourse);
        if(ret==1){
            return  success("添加成功");
        }else{
            return error("添加失败");
        }

    }

    @GetMapping("/lists")
    @ApiOperation(value = "查询课程班级老师")
    public  ResultVO   lists(){
        Teacher_Clazz_Course teacher_clazz_course=new Teacher_Clazz_Course();
          List<Teacher> teacher=teacherService.findAll();
          List<Clazz> clazzes =clazzService.findAll();
          List<Course> courses=courseService.findAll();
          teacher_clazz_course.setTeachers(teacher);
          teacher_clazz_course.setClazzes(clazzes);
          teacher_clazz_course.setCourses(courses);
        return success(teacher_clazz_course);
    }

    @GetMapping("/save")
    @ApiOperation(value = "保存关系")
    public ResultVO save(@RequestParam("teacherid")String teacherid ,@RequestParam("clazzid")String clazzid,@RequestParam("courseid")String courseid ){
        System.out.println(teacherid+clazzid+courseid);
  /*       ClazzCourse clazzCourse=new ClazzCourse();
       clazzCourse.setClazzid(Integer.valueOf(clazzid));
       clazzCourse.setCourseid(Integer.valueOf(courseid));
       clazzCourse= clazzCourseService.findbyid(clazzCourse);
       int ccid=clazzCourse.getCcid();
       TeacherClazzCourse teacherClazzCourse=new TeacherClazzCourse();
       teacherClazzCourse.setCcid(ccid);*/

       int ret=  clazzTeacherCourseService.addLine(Integer.valueOf(teacherid),Integer.valueOf(clazzid),Integer.valueOf(courseid));
       if(ret==1){
           return success("添加成功");
       }else {
           return  error("添加失败");
       }


    }
    @GetMapping("/update")
    @ApiOperation(value = "修改关系")
    public  ResultVO update(@RequestParam("tccid")String tccid,@RequestParam(value = "teacherid",required = false)String teacherid,
    @RequestParam("courseid") String courseid,@RequestParam("clazzid") String clazzid
    ){          System.out.println(teacherid+clazzid+courseid);
        ClazzCourse clazzCourse=new ClazzCourse();
        clazzCourse.setClazzid(Integer.valueOf(clazzid));
        clazzCourse.setCourseid(Integer.valueOf(courseid));
        clazzCourse= clazzCourseService.findbyid(clazzCourse);
        int ccid=clazzCourse.getCcid();
        TeacherClazzCourse teacherClazzCourse=new TeacherClazzCourse();
        teacherClazzCourse.setTccid(Integer.valueOf(tccid));
        teacherClazzCourse.setTeacherid(Integer.valueOf(teacherid));
        teacherClazzCourse.setCcid(ccid);
       int ret=  clazzTeacherCourseService.updata(teacherClazzCourse);
      if(ret==1){
          return success("更新成功");

      }else {

          return error("跟新失败");

      }
    }


    @GetMapping("/listsPage")
    @ApiOperation(value = "分页查询课程班级老师")
       public  ResultVO listPage(@RequestParam("page") int page,@RequestParam("limit") int limit){
        List<Map>  list= clazzTeacherCourseService.listPage(page,limit);
         int count=clazzTeacherCourseService.list().size();
        return success(count,list);
    }
}
