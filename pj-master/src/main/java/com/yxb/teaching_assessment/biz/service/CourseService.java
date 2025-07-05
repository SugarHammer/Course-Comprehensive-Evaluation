package com.yxb.teaching_assessment.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxb.teaching_assessment.biz.entity.Clazz;
import com.yxb.teaching_assessment.biz.entity.Course;
import com.yxb.teaching_assessment.biz.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;

    public List<Course> findAll(){
        return  courseMapper.selectList(null);
    }

    public int delete(String courseid) {
        Course course=new Course();
        course.setCourseid(Integer.valueOf(courseid));
        QueryWrapper<Course> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("courseid",course.getCourseid());
        return  courseMapper.update(course,queryWrapper);
    }

    public int update(Course course) {
        QueryWrapper<Course> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("courseid",course.getCourseid());
        return  courseMapper.update(course,queryWrapper);

    }

    public int save(Course course) {
       return courseMapper.insert(course);
    }

    public List<Course> findAllPage(int page, int limit) {
         page =(page-1)*limit;
        return  courseMapper.findAllPage(page,limit);
    }
}
