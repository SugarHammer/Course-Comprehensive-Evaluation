package com.yxb.teaching_assessment.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxb.teaching_assessment.biz.entity.ClazzCourse;
import com.yxb.teaching_assessment.biz.mapper.ClazzCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClazzCourseService {
    @Autowired
    ClazzCourseMapper clazzCourseMapper;
    public ClazzCourse findbyid(ClazzCourse clazzCourse){
        QueryWrapper<ClazzCourse> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("clazzid",clazzCourse.getClazzid());
        queryWrapper.eq("courseid",clazzCourse.getCourseid());
        return  clazzCourseMapper.selectOne(queryWrapper);
    }
}
