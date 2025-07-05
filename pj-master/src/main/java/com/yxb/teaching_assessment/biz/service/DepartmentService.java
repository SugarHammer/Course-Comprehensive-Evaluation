package com.yxb.teaching_assessment.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxb.teaching_assessment.biz.entity.Department;
import com.yxb.teaching_assessment.biz.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 部门列表
     * @return
     */
    public List<Department> departmentList(){

        return departmentMapper.selectList(null);
    }

    /**
     * 增加部门
     * @return
     */
    public  int saveDepartment(Department department){
        return departmentMapper.insert(department);
    }

    /**
     *   更新
     * @param department
     * @return
     */
    public int update(Department department){
        QueryWrapper<Department> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("departmentid",department.getDepartmentid());
        return  departmentMapper.update(department,queryWrapper);
    }

    /**
     * 部门根据id查找
     * @param departmentid
     * @return
     */
     public   Department  findByid(String departmentid){
        QueryWrapper<Department> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("departmentid",departmentid);
        return departmentMapper.selectOne(queryWrapper);
     }

    /**
     *  根据部门名称查询
     * @param departmentname
     * @return
     */
   public  List<Department> findLikeBy(String departmentname){
         QueryWrapper<Department> queryWrapper =new QueryWrapper<>();
         queryWrapper.eq("departmentname",departmentname);
         return  departmentMapper.selectList(queryWrapper);

   }

    /**
     * 根据id删除
     * @param departmentid
     * @return
     */
   public  int deleteid(String departmentid){
       Department department=new Department();
       department.setDepartmentid(Integer.valueOf(departmentid));
       department.setIsDelete(1);
       QueryWrapper<Department> queryWrapper =new QueryWrapper<>();

      queryWrapper.eq("departmentid",department.getDepartmentid());
       return  departmentMapper.update(department,queryWrapper);

   }

    public List<Department> listPage(int page, int limit) {
       page=(page-1)*limit;
         return  departmentMapper.listPage(page,limit);
    }
}
