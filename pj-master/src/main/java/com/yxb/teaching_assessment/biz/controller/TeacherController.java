package com.yxb.teaching_assessment.biz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yxb.teaching_assessment.biz.entity.Teacher;
import com.yxb.teaching_assessment.biz.service.TeacherService;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;

import com.yxb.teaching_assessment.biz.vo.ResultVO;
import com.yxb.teaching_assessment.biz.vo.ResultVoPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@Api(tags = "教师管理")
@RequestMapping("/teacher")
public class TeacherController extends AbstractBaseCtrl {
   @Autowired
   TeacherService teacherService;
   @PostMapping("/findByNO")
   @ApiOperation(value = "NO查询")
   public ResultVO  findByTeacherno(String teacherno){
       if(teacherno==null){
         return error("查找失败");
       }else {
           Teacher teacher=teacherService.findByTeacherno(teacherno);
           if(teacher==null){
               return error("查找的NO不存在");
           }else {
               return success(teacher);
           }
       }
   }
   @GetMapping("/findAll")
    @ApiOperation("教师列表")
   public  ResultVO findAll(){
       List<Teacher> teachers=teacherService.findAll();
        int count =teacherService.findAll().size();
       return success(count,teachers);
   }
   @GetMapping("/pageFindAll")
   @ApiOperation("分页查询")
   public ResultVO pagefindall(int pageNo,int pageSize){
       Page<Teacher> page =new Page<>(pageNo,pageSize);
     IPage list =teacherService.pageFind(page);
       int count =teacherService.findAll().size();
       return  success(count,list) ;
   }

   @PostMapping("/save")
   @ApiOperation("新增教师")
   public  ResultVO save(@RequestBody Teacher teacher){
       int ret=teacherService.saveTeacher(teacher);
       if(ret==1){
           return success("新增成功");
       }else {
           return error("新增失败");
       }
   }

   @PostMapping("/update")
   @ApiOperation("信息修改")
    public  ResultVO update(@RequestBody Teacher teacher){
   if(teacher.getTeacherid()==null){
       return error("修改失败");
   }else {
       int ret=teacherService.updateTeacher(teacher);
       if(ret==1){
           return success("修改成功");
       }else {
           return error("修改失败");
       }
   }
   }
   @PostMapping("/findById")
   @ApiOperation(value = "Id查询教师")
    public  ResultVO findById(@RequestParam("teacherid") String  teacherid){
       if( teacherid==null){
           return error("查找失败");
       }else {
           Teacher teacher=teacherService.findById(teacherid);
           if(teacher==null){
               return error("查询用户不存在");
           }else {
               return success(teacher);
           }
       }
   }

   @PostMapping("/findByName")
    @ApiOperation(value = "名字查询")
    public ResultVO findByName(@RequestParam("teachername") String teachername){
       if(teachername==null){
           teachername="";
       }
       List<Teacher> teachers=teacherService.findByName(teachername);
       int count = teachers.size();
       return success(count,teachers);
   }

   @GetMapping("/delete")
    @ApiOperation(value = "删除教师信息")
    public ResultVO delete(@RequestParam("teacherid") String teacherid){
       if(teacherid==null){
           return error("删除失败");
       }else {
           int ret=teacherService.deleteId(teacherid);
           if(ret==1){
               return success("删除成功");
           }else {
               return  error("删除失败");
           }
       }
   }

    @GetMapping("/fff")
    @ApiOperation(value = "你猜")
    public ResultVoPage ac(){
       ResultVoPage  resultVoPage=new ResultVoPage();
      int count= teacherService.findAll().size();


       return  success1(count,teacherService.findAll());
    }


    @GetMapping("/pageFindtest")
    @ApiOperation("分页查询")
    public ResultVO pagefinda(@RequestParam("page") int page,@RequestParam("limit") int limit){
     /*   Page<Teacher> page1 =new Page<>(page,limit);
       IPage<Teacher> list =teacherService.pageFind(page1);*/
       List<Teacher> findPage=teacherService.finPage(page,limit);
        int count =teacherService.findAll().size();



        return  success(count,findPage) ;
    }

}
