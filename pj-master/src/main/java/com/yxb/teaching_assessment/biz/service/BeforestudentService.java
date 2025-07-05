package com.yxb.teaching_assessment.biz.service;

import com.yxb.teaching_assessment.biz.mapper.TeacherClazzCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BeforestudentService {
    @Autowired
    TeacherClazzCourseMapper teacherClazzCourseMapper;
    public  List<Map> findAll(String userid){
        return   teacherClazzCourseMapper.findall(Integer.valueOf(userid));
    }


    public List<Map> findallPage(String userid,int page, int limit) {
        page=(page-1)*limit;
       return teacherClazzCourseMapper.findallPage(Integer.valueOf(userid),page,limit);
    }
}
