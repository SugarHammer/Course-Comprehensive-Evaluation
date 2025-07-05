package com.yxb.teaching_assessment.biz.controller;

import com.yxb.teaching_assessment.biz.entity.Department;
import com.yxb.teaching_assessment.biz.service.DepartmentService;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;
import com.yxb.teaching_assessment.biz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "学院管理模块接口")
@RequestMapping("/department")
public class DepartmentController extends AbstractBaseCtrl {

  @Autowired
    DepartmentService departmentService;

  @GetMapping("/list")
  @ApiOperation(value = "部门列表")
    public ResultVO departmentList(){

      List<Department> departments=departmentService.departmentList();
      return  success(departments);
  }


  @PostMapping("/save")
  @ApiOperation(value = "增加部门")
    public  ResultVO departMentSave(@RequestBody Department department){
       int ret=departmentService.saveDepartment(department);
      if(ret==1){
          return success("部门增加成功");
      }else {
          return success("部门增加失败");
      }
  }
 @PostMapping("/update")
 @ApiOperation(value = "更新部门")
 public ResultVO departMeantUpdate(@RequestBody Department department){
      if(department.getDepartmentid()==null){
         return error("修改失败");
      }else {
          int ret =departmentService.update(department);
          if(ret==1){
              return  success("修改成功");
          }else {
              return  error("修改失败");
          }
      }
 }

 @PostMapping("/findOne")
 @ApiOperation("部门查找")
    public  ResultVO departById(@RequestParam("departmentid") String departmentid){
      if(departmentid==null){
          return error("查找失败");
      }else {
          Department department=departmentService.findByid(departmentid);
          if (department==null){
              return error("查找id不存在");
          }else {
            return  success(department);
          }
      }
 }
 @PostMapping("/findLisk")
 @ApiOperation("根据名称查找部门")
    public  ResultVO findLikeBy(@RequestParam("departmentname") String departmentname){
      if(departmentname==null){
          departmentname="";
      }
      List<Department> departments=departmentService.findLikeBy(departmentname);
      return success(departments);
 }
 @GetMapping("/delete")
 @ApiOperation(value = "删除部门")
    public  ResultVO deleteDepartment(@RequestParam("departmentid") String departmentid){
      if(departmentid==null){
          return  error("获取部门失败");
      }else {
          int ret=departmentService.deleteid(departmentid);
          if(ret==1){
              return  success("删除成功");
          }else {
              return success("删除部门失败");
          }
      }
 }

    @GetMapping("/listPage")
    @ApiOperation(value = "部门列表分页")
    public ResultVO departmentList(@RequestParam("page") int page,@RequestParam("limit") int limit){

        List<Department> departments=departmentService.listPage(page,limit);
        int count = departmentService.departmentList().size();
        return  success(count,departments);
    }



}
