package com.yxb.teaching_assessment.biz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxb.teaching_assessment.biz.entity.Clazz;
import com.yxb.teaching_assessment.biz.entity.Student;
import com.yxb.teaching_assessment.biz.entity.Student_Clazz;
import com.yxb.teaching_assessment.biz.mapper.StudentMapper;
import com.yxb.teaching_assessment.biz.service.ClazzService;
import com.yxb.teaching_assessment.biz.service.StudentService;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;
import com.yxb.teaching_assessment.biz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@Api(tags = "学生管理")
public class StudentContorller extends AbstractBaseCtrl {
     @Autowired
    StudentService studentService;

     @Autowired
    ClazzService clazzService;
    @GetMapping("/findAll")
    @ApiOperation(value = "学生列表")
   public ResultVO StudentFindAll(){
     return success(studentService.StudentFindAll());
  }
    @PostMapping("/save")
    @ApiOperation(value = "增加学生")
    public ResultVO StudentSave(@RequestBody Student student){
        int ret=  studentService.save(student);
        if(ret==1){
            return success("新增成功");
        }else {
            return error("新增失败");
        }
    }

    @PostMapping("/updata")
    @ApiOperation(value = "更改学生")
    public ResultVO StudentUpdate(@RequestBody Student student){
        if(student.getStudentid()==null){
            return error("修改失败");
        }else {
            int ret =studentService.update(student);
            if(ret==1){
                return  success("更新成功");
            }else {
                return  error("更新失败");
            }
        }
    }

    @GetMapping("/findbyid")
    @ApiOperation(value = "id查找学生")
    public ResultVO studentfindByid(@RequestParam("studentid") String studentid){
        if(studentid==null){
            return error("查找失败");
        }else {
             Student student1=studentService.findById(studentid);
             List list=new ArrayList();
             list.add(student1);

              int count=1;
            if(student1==null){
                return error("查找id不存在");
            }else {
              return  success(count,list);
            }
        }
    }

    /**
     * 根据学生姓名查找
     * @param studentname
     * @return
     */
    @GetMapping("/findLikeBy")
    @ApiOperation("根据姓名查询")
    public ResultVO findLikeBy(@RequestParam("studentname")  String studentname){
        if(studentname==null){
          studentname="";
        }
        List<Student> students=studentService.findLikeBy(studentname);
        int count=students.size();
        return  success(count,students);
    }

    /**
     * 根据id删除
     * @param studentno
     * @return
     */
     @GetMapping("/deleteid")
    @ApiOperation("根据id删除学生")
    public ResultVO deleteid(@RequestParam("studentid") String studentid){
       if(studentid==null){
           return error("删除失败");
       }else {
           int ret =studentService.deleteid(studentid);
           if(ret==1){
               return success("删除成功");
           }else {
               return  error("删除失败");
           }
       }
    }
    //分页查询
    @GetMapping("/list")
    @ApiOperation("分页查询学生")
    public ResultVO findList(@RequestParam("page") int page,int limit){
        return  success(studentService.StudentFindAll());
    }

    @GetMapping("/updateClass")
    @ApiOperation("用id去查学生")
    public ResultVO updataS(@RequestParam("studentid") String studentid){
        Student_Clazz student_clazz=new Student_Clazz();
         student_clazz.setStudents(studentService.findById1(studentid));
        student_clazz.setClazzes(clazzService.findAll());
        return success(student_clazz);
    }
  //使用limit分页
    @GetMapping("/findPage")
    @ApiOperation(value = "分页查询limit")
    public  ResultVO findPage(@RequestParam("page") int page,@RequestParam("limit") int limit){
        int count=  studentService.StudentFindAll().size();
        return success(count,studentService.listPage(page,limit)) ;

    }

   /* @GetMapping("/findPage1")
    @ApiOperation(value = "分页查询limit")
    public  ResultVO ListLike(@RequestParam("studentnaame") String studentname){
        int count=  studentService.ListLike(studentname).size();

        return success(count,  studentService.findLikeBy(studentname)) ;

    }*/
}
