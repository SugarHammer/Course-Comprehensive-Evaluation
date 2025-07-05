package com.yxb.teaching_assessment.biz.mapper;

import com.yxb.teaching_assessment.biz.entity.Index;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * 
 * @since 2025-07-12
 */
public interface IndexMapper extends BaseMapper<Index> {
   @Select("select * from `index`")
    List<Index> findAll();

    @Update("UPDATE `index` set `delflg`= 0 where `indexid`=#{indexid}")
    int delete(@Param("indexid") String indexid);

    @Insert(" INSERT into `index` ( `indexname`,`option1`,`option2`,`option3`,`option4`,`score1`,`score2`,`score3`,`score4`,`delflg`)VALUES(#{indexname},#{option1},#{option2},#{option3},#{option4},#{score1},#{score2},#{score3},#{score4},#{delflg} )")
    int  insertMy(@Param("indexname") String indexname,@Param("option1") String option1,@Param("option2") String option2,
                  @Param("option3")String option3, @Param("option4")String option4, @Param("score1")Integer score1,@Param("score2") Integer score2,
                  @Param("score3")Integer score3, @Param("score4")Integer score4,@Param("delflg") Boolean delflg);

    @Update("UPDATE `index` set `indexname`=#{indexname},`option1`=#{option1},`option2`=#{option2},`option3`=#{option2},`option4`=#{option4},`score1`=#{score1},`score2`=#{score2},`score3`=#{score3},`score4`=#{score4},`delflg`=#{delflg} where `indexid`=#{indexid}")
    int updateMy(@Param("indexname") String indexname,@Param("option1") String option1,@Param("option2") String option2,
                 @Param("option3")String option3, @Param("option4")String option4, @Param("score1")Integer score1,@Param("score2") Integer score2,
                 @Param("score3")Integer score3, @Param("score4")Integer score4,@Param("delflg") Boolean delflg,
                 @Param("indexid") Integer indexid);

     @Select("select *  from `index` LIMIT #{page},#{limit}")
    List<Index> findAllPage(@Param("page") int page, @Param("limit") int limit);

}
