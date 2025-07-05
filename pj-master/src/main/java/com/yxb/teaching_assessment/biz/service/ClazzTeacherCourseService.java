package com.yxb.teaching_assessment.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxb.teaching_assessment.biz.entity.TeacherClazzCourse;
import com.yxb.teaching_assessment.biz.mapper.TeacherClazzCourseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClazzTeacherCourseService {
    @Autowired
    TeacherClazzCourseMapper teacherClazzCourseMapper;
    public List<TeacherClazzCourse> findAll() {
        return  teacherClazzCourseMapper.selectList(null);
    }

    public List<Map> list() {
        return  teacherClazzCourseMapper.list();
    }

    public int delete(String tccid) {
       return   teacherClazzCourseMapper.delete1(tccid);

    }

    public int add(TeacherClazzCourse clazzCourse) {
       return  teacherClazzCourseMapper.insert(clazzCourse);

    }

    public int  updata(TeacherClazzCourse teacherClazzCourse) {
        QueryWrapper<TeacherClazzCourse> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("tccid",teacherClazzCourse.getTccid());
        return teacherClazzCourseMapper.update(teacherClazzCourse,queryWrapper);
    }


    public List<Map> listPage(int page, int limit) {
        page=(page-1)*limit;
       return teacherClazzCourseMapper.listPage(page,limit);
    }

    public int addLine(Integer teacherid, Integer clazzid, Integer courseid) {
        return  teacherClazzCourseMapper.addLine(teacherid,clazzid,courseid);
    }
}
