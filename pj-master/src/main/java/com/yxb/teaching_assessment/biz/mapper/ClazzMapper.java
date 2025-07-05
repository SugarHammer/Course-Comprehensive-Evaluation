package com.yxb.teaching_assessment.biz.mapper;

import com.yxb.teaching_assessment.biz.entity.Clazz;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * InnoDB free: 31744 kB Mapper 接口
 * </p>
 *
 * 
 * @since 2025-07-12
 */
public interface ClazzMapper extends BaseMapper<Clazz> {
    @Select("select * from clazz limit #{page},#{limit}")
    List<Clazz> clazzfindAll(@Param("page") int page, @Param("limit") int limit);
}
