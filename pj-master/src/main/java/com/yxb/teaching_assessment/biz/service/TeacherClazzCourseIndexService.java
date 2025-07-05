package com.yxb.teaching_assessment.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxb.teaching_assessment.biz.entity.TeacherClazzCourseIndex;
import com.yxb.teaching_assessment.biz.mapper.TeacherClazzCourseIndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherClazzCourseIndexService {
    @Autowired
    TeacherClazzCourseIndexMapper teacherClazzCourseIndexMapper;
    public int resultSave(TeacherClazzCourseIndex teacherClazzCourseIndex) {
          int  tccid= teacherClazzCourseIndex.getTccid();
         int userid= teacherClazzCourseIndex.getUserid();
        int  score= teacherClazzCourseIndex.getScore();
        int teacherid=teacherClazzCourseIndex.getTeacherid();

       return    teacherClazzCourseIndexMapper.saveResult(tccid,userid,score,teacherid);

    }

    public int findTccid(String tccid,String userid) {
        QueryWrapper<TeacherClazzCourseIndex> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("tccid",tccid);
        queryWrapper.eq("userid",userid);
       TeacherClazzCourseIndex teacherClazzCourseIndex= teacherClazzCourseIndexMapper.selectOne(queryWrapper);
       if(teacherClazzCourseIndex!=null){
           return 1;
       }else {
           return  0;
       }
    }

    public List<Map> myTeach(String userid){
        int userid1=Integer.valueOf(userid);
        List<Map> list=teacherClazzCourseIndexMapper.myTacher(userid1);
        return list;
    }

    /**
     * 老师查询
     * @param teacherid
     * @return
     */
  public  List<Map> teacherCheck(int teacherid){
        return  teacherClazzCourseIndexMapper.teacherCheck(teacherid);
  }

    public List<Map> teacherClazz(int teacherid,int page,int limit) {
      page=(page-1)*limit;
      return  teacherClazzCourseIndexMapper.teacherClazz(teacherid,page,limit);
    }

    public List<Map> teache(int page, int limit) {
      page=(page-1)*limit;
      return  teacherClazzCourseIndexMapper.teache(page,limit);
    }

    public int del(Integer tcciid) {
      return teacherClazzCourseIndexMapper.del(tcciid);
    }

    public int updateResult(Integer tcciid, Integer score) {
      return   teacherClazzCourseIndexMapper.updateResult(tcciid,score);
    }
}
