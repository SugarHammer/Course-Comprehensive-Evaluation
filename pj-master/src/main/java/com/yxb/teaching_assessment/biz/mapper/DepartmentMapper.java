package com.yxb.teaching_assessment.biz.mapper;

import com.yxb.teaching_assessment.biz.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * 
 * @since 2025-07-12
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    @Select("select * from department LIMIT #{page},#{limit}")
    List<Department> listPage(@Param("page") int page,@Param("limit") int limit);
}
