package com.yxb.teaching_assessment.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yxb.teaching_assessment.biz.entity.Student;
import com.yxb.teaching_assessment.biz.entity.Teacher;
import com.yxb.teaching_assessment.biz.mapper.TeacherMapper;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    public Teacher findByTeacherno(String username) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacherno",username);
        return teacherMapper.selectOne(queryWrapper);
    }


    public List<Teacher> findAll(){
        return teacherMapper.selectList(null);
    }

    public int saveTeacher(Teacher teacher){
        return teacherMapper.insert(teacher);
    }

    public int updateTeacher(Teacher teacher){
        QueryWrapper<Teacher> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("teacherid",teacher.getTeacherid());
        return  teacherMapper.update(teacher,queryWrapper);
    }

    public Teacher findById(String teacherid ){
        QueryWrapper<Teacher> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("teacherid",teacherid);
        return  teacherMapper.selectOne(queryWrapper);
    }

    public List<Teacher> findByName(String teachername){
        QueryWrapper<Teacher> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("teachername",teachername);
        return  teacherMapper.selectList(queryWrapper);

    }

    public  int deleteId(String teacherid){
        Teacher teacher=new Teacher();
        teacher.setTeacherid(Integer.valueOf(teacherid));
        teacher.setIsDelete(1);
        QueryWrapper<Teacher>  queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("teacherid",teacherid);
        return teacherMapper.update(teacher,queryWrapper);
    }

    public Teacher selectByTeacherid(Integer teacherid) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacherid",teacherid);
        return teacherMapper.selectOne(queryWrapper);
    }

    public IPage<Teacher> pageFind(Page<Teacher> page) {
        return  teacherMapper.selectPage(page,null);
    }

    public List<Teacher> finPage(int page, int limit) {
          page=(page-1)*limit;
          limit=limit;
        return    teacherMapper.findPage(page,limit);
    }
}
