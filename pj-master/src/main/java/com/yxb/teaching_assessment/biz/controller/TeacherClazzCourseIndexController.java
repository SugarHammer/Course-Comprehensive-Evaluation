package com.yxb.teaching_assessment.biz.controller;

import com.yxb.teaching_assessment.biz.service.TeacherClazzCourseIndexService;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;
import com.yxb.teaching_assessment.biz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "结果")
@RequestMapping("/teResult")
public class TeacherClazzCourseIndexController extends AbstractBaseCtrl {
    @Autowired
    TeacherClazzCourseIndexService teacherClazzCourseIndexService;

    @GetMapping("findTccid")
    @ApiOperation(value = "查询结果")
    public ResultVO findTccid(@RequestParam("tccid" )String tccid,@RequestParam("userid")String userid){
       int ret= teacherClazzCourseIndexService.findTccid(tccid,userid);
        if(ret==1){
         return    success("你已经评过此老师了");
        }else {
            return error("没有评过");
        }
    }

    @GetMapping("/mytache")
    @ApiOperation(value = "我的评教")
    public ResultVO findMyTache (@RequestParam("userid") String userid){
        List<Map> list= teacherClazzCourseIndexService.myTeach(userid);
        int count=list.size();
        return success(count,list);
    }

    @GetMapping("/teacherCheck")
    @ApiOperation(value = "教师查看分数")
    public ResultVO teacheFind(@RequestParam("teacherid") String teacherid){
        int count=teacherClazzCourseIndexService.teacherCheck(Integer.valueOf(teacherid)).size();
        return  success(count,teacherClazzCourseIndexService.teacherCheck(Integer.valueOf(teacherid)));
    }

     @GetMapping("/teacherClazz")
    @ApiOperation(value = "查看班级")
    public ResultVO teacherClazz(@RequestParam("teacherid") String teacherid,@RequestParam("page") int page,@RequestParam("limit") int limit){
        List<Map> list= teacherClazzCourseIndexService.teacherClazz(Integer.valueOf(teacherid),page,limit);
         int count=  list.size();
         return success(count,list);
     }

     @GetMapping("/teache")
    @ApiOperation(value = "评教")
    public  ResultVO teache(@RequestParam("page") int page,@RequestParam("limit") int limit){
        List<Map> list=teacherClazzCourseIndexService.teache(page,limit);
        int count =list.size();
        return  success(count,list);
     }
  @GetMapping("/teacheDel")
    @ApiOperation(value = "删除评级内容")
    public  ResultVO del(@RequestParam("tcciid") String tcciid){
        int ret =teacherClazzCourseIndexService.del(Integer.valueOf(tcciid));
        if(ret==1){
          return success("删除成功");
        }else {
           return error("删除失败");
        }
  }
    @GetMapping("/teacheUpdate")
    @ApiOperation(value = "跟新评级内容")
    public  ResultVO update(@RequestParam("tcciid") String tcciid,@RequestParam("score") String score){
        int ret =teacherClazzCourseIndexService.updateResult(Integer.valueOf(tcciid),Integer.valueOf(score));
        if(ret==1){
            return success("更新成功");
        }else {
            return error("更新失败");
        }
    }
}
