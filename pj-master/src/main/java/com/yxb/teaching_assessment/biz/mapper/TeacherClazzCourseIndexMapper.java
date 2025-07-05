package com.yxb.teaching_assessment.biz.mapper;

import com.yxb.teaching_assessment.biz.entity.TeacherClazzCourseIndex;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * 
 * @since 2025-07-12
 */
public interface TeacherClazzCourseIndexMapper extends BaseMapper<TeacherClazzCourseIndex> {

     @Select("select * from teacher_clazz_course,course,clazz \n" +
             "WHERE teacher_clazz_course.teacherid=#{teacherid}\n" +
             "and course.courseid=teacher_clazz_course.courseid\n" +
             "and clazz.clazzid=teacher_clazz_course.clazzid LIMIT #{page},#{limit}")
    List<Map> teacherClazz(@Param("teacherid") int teacherid,@Param("page")int page,@Param("limit")int limit);

    @Insert("insert teacher_clazz_course_index (tccid,score,userid,teacherid) VALUES(#{tccid},#{score},#{userid},#{teacherid})")
    int saveResult(@Param("tccid") int tccid, @Param("userid") int userid, @Param("score") int score, @Param("teacherid") int teacherid);

    @Select("select  * from  teacher_clazz_course_index,teacher_clazz_course,teacher,course where  teacher_clazz_course_index.tccid=teacher_clazz_course.tccid and teacher.teacherid=teacher_clazz_course_index.teacherid and course.courseid=teacher_clazz_course.courseid and teacher_clazz_course_index.userid =#{userid}")
    List<Map> myTacher(@Param("userid") int userid);

    @Select("select avg(teacher_clazz_course_index.score) as sc,COUNT(teacher_clazz_course_index.teacherid) as cou,teacher.teachername,course.coursename,clazz.classname\n" +
            "from teacher_clazz_course_index,teacher_clazz_course ,clazz,course,teacher where\n" +
            " teacher_clazz_course.tccid=teacher_clazz_course_index.tccid\n" +
            " and clazz.clazzid=teacher_clazz_course.clazzid \n" +
            "and course.courseid= teacher_clazz_course.courseid\n" +
            " and teacher.teacherid=teacher_clazz_course_index.teacherid\n" +
            " and teacher_clazz_course_index.teacherid=#{teacherid}\n" +
            "GROUP BY teacher_clazz_course.clazzid \n")
    List<Map> teacherCheck(@Param("teacherid") int teacherid);

    @Select("select  * from teacher_clazz_course_index  \n" +
            "JOIN `user` on `user`.userid=teacher_clazz_course_index.userid \n" +
            "join student on student.studentid=`user`.studentid \n" +
            "join teacher_clazz_course on teacher_clazz_course_index.tccid =teacher_clazz_course.tccid\n" +
            "join course on teacher_clazz_course.courseid=course.courseid\n" +
            "join teacher on teacher_clazz_course_index.teacherid=teacher.teacherid limit #{page},#{limit}")
    List<Map> teache(@Param("page") int page,@Param("limit") int limit);

    @Delete("delete FROM teacher_clazz_course_index where teacher_clazz_course_index.tcciid=#{tcciid}")
    int del(@Param("tcciid") Integer tcciid);

    @Update("UPDATE teacher_clazz_course_index set teacher_clazz_course_index.score=#{score} where teacher_clazz_course_index.tcciid=#{tcciid}")
    int updateResult(@Param("tcciid") Integer tcciid,@Param("score") Integer score);
}
