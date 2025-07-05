package com.yxb.teaching_assessment.biz.mapper;

import com.yxb.teaching_assessment.biz.entity.TeacherClazzCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * InnoDB free: 31744 kB Mapper 接口
 * </p>
 *
 * 
 * @since 2025-07-12
 */
public interface TeacherClazzCourseMapper extends BaseMapper<TeacherClazzCourse> {
   @Select("SELECT  distinct teacher_clazz_course.tccid,\n" +
           "teacher_clazz_course.teacherid,\n" +
           "teacher.teachername, \n" +
           "course.courseid,course.coursename,clazz.clazzid,clazz.classname \n" +
           "FROM clazz,clazz_course,teacher,teacher_clazz_course,course \n" +
           "where teacher_clazz_course.teacherid=teacher.teacherid \n" +
           "and teacher_clazz_course.ccid=course.courseid \n" +
           "and\n" +
           "clazz.clazzid in\n" +
           "(SELECT distinct clazz_course.clazzid \n" +
           "from clazz_course,teacher_clazz_course \n" +
           "where clazz_course.ccid=teacher_clazz_course.ccid)")
    List<Map> list();

     @Delete("DELETE from teacher_clazz_course where teacher_clazz_course.tccid=#{tccid}")
     int delete1(@Param("tccid") String tccid);

    @Select("select * from teacher_clazz_course,teacher,clazz,course where teacher_clazz_course.teacherid=teacher.teacherid\n" +
            "and course.courseid=teacher_clazz_course.courseid and clazz.clazzid in\n" +
            "(select student.clazzid  from student  where  student.studentid =\n" +
            "(select `user`.studentid FROM  user where`user`.userid=#{userid}))")
    List<Map> findall(@Param("userid")int userid);



 @Select("SELECT  distinct teacher_clazz_course.tccid,\n" +
         "teacher_clazz_course.teacherid,\n" +
         "teacher.teachername, \n" +
         "course.courseid,course.coursename,clazz.clazzid,clazz.classname \n" +
         "FROM clazz,clazz_course,teacher,teacher_clazz_course,course \n" +
         "where teacher_clazz_course.teacherid=teacher.teacherid \n" +
         "and teacher_clazz_course.ccid=course.courseid \n" +
         "and\n" +
         "clazz.clazzid in\n" +
         "(SELECT distinct clazz_course.clazzid \n" +
         "from clazz_course,teacher_clazz_course \n" +
         "where clazz_course.ccid=teacher_clazz_course.ccid) limit #{page},#{limit}")
      List<Map> listPage(@Param("page")int page,@Param("limit")int limit);

    @Select("select * from teacher_clazz_course,teacher,clazz,course where teacher_clazz_course.teacherid=teacher.teacherid\n" +
            "and course.courseid=teacher_clazz_course.courseid and clazz.clazzid in\n" +
            "(select student.clazzid  from student  where  student.studentid =\n" +
            "(select `user`.studentid FROM  user where`user`.userid=#{userid})) limit #{page},#{limit}")
    List<Map> findallPage(@Param("userid")int userid,@Param("page")int page,@Param("limit") int limit);

    @Insert("INSERT \n" +
            "teacher_clazz_course(teacher_clazz_course.teacherid,teacher_clazz_course.clazzid,teacher_clazz_course.courseid) \n" +
            "VALUES(#{teacherid},#{clazzid},#{courseid})")
    int addLine(@Param("teacherid") Integer teacherid, @Param("clazzid") Integer clazzid, @Param("courseid") Integer courseid);
}
