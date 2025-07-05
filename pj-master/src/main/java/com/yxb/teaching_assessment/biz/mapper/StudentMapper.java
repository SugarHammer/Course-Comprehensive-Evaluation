package com.yxb.teaching_assessment.biz.mapper;

import com.yxb.teaching_assessment.biz.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
public interface StudentMapper extends BaseMapper<Student> {
     @Select("SELECT student.studentid,clazz.clazzid,clazz.classname,student.studentname,student.studentno,student.is_delete from student,clazz  where clazz.clazzid=student.clazzid LIMIT #{page},#{limit}")
     List<Map> listPage(@Param("page") int page, @Param("limit") int limit);
     @Select("SELECT student.studentid,clazz.clazzid,clazz.classname,student.studentname,student.studentno,student.is_delete from student,clazz  where clazz.clazzid=student.clazzid  and student.studentname LIKE  '%#{studentname}%' \n")
     List<Map> ListLike(@Param("studentname") String studentname);
}
