package com.yxb.teaching_assessment.biz.controller;

import com.yxb.teaching_assessment.biz.entity.Clazz;
import com.yxb.teaching_assessment.biz.entity.Department;
import com.yxb.teaching_assessment.biz.entity.DepartmentClass;
import com.yxb.teaching_assessment.biz.service.ClazzService;
import com.yxb.teaching_assessment.biz.service.DepartmentService;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;
import com.yxb.teaching_assessment.biz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "班级相关")
@RequestMapping("/clazz")
public class ClazzController extends AbstractBaseCtrl{
    @Autowired
    ClazzService clazzService;

    @Autowired
    DepartmentService departmentService;
    @GetMapping("/findAll")
    @ApiOperation(value ="课程列表")
    public ResultVO findAll(){
     return  success(clazzService.findAll());
    }

    /**
     *   根据id删除课程
     * @param clazzid
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value ="删除班级" )
    public  ResultVO delete (@RequestParam("clazzid") String clazzid){
        if(clazzid==null){
          return error("获取班级失败");
        }else {
           int ret= clazzService.delete(clazzid);
           if(ret==1){
              return success("删除标记添加成功");
           }else {
               return  error("删除失败");
           }

        }

    }
    @PostMapping("update")
    @ApiOperation(value = "更新班级")
    public ResultVO update(@RequestBody Clazz clazz){

        if(clazz.getClazzid()==null){
            return  error("获取课程失败");
        }else {
            int ret=clazzService.update(clazz);
            if(ret==1){
              return   success("更新成功");
            }else {
               return error("更新失败");
            }
        }

    }




    @PostMapping("/save")
    @ApiOperation(value = "增加班级")
    public ResultVO save(@RequestBody Clazz clazz){
       int ret= clazzService.save(clazz);
       if(ret==1){
         return   success("增加成功");
       }else {
           return error("增加失败");
       }

    }
    @GetMapping("/updateDepart")
    @ApiOperation(value = "更新部门")
    public  ResultVO updateClass(@RequestParam("clazzid") String clazzid){
        DepartmentClass departmentClass=new DepartmentClass();
        departmentClass.setClazzes(clazzService.findByid(clazzid));
        departmentClass.setDepartments(departmentService.departmentList());
        return  success(departmentClass);
    }


    @GetMapping("/clazzfindAll")
    @ApiOperation(value = "分页查询课程")
    public  ResultVO clazzfindAll(@RequestParam("page") int page,@RequestParam("limit") int limit){
          List<Clazz> clazzes= clazzService.clazzfindAll(page,limit);
          int count =clazzService.findAll().size();
        return  success(count,clazzes);
    }
}
