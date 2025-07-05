package com.yxb.teaching_assessment.biz.mapper;

import com.yxb.teaching_assessment.biz.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * 
 * @since 2025-07-12
 */
public interface TeacherMapper extends BaseMapper<Teacher> {

     @Select("SELECT * from  teacher LIMIT #{page},#{limit} ")
    List<Teacher> findPage(@Param("page") int page,@Param("limit") int limit);
}
