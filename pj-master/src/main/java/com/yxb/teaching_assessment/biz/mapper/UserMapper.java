package com.yxb.teaching_assessment.biz.mapper;

import com.yxb.teaching_assessment.biz.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * 
 * @since 2025-07-12
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * from user where  `user`.teacherid  is not null or `user`.studentid  is not NULL LIMIT #{page},#{limit}")
    List<User> findAllUser(@Param("page") int page,@Param("limit") int limit);

    @Insert("insert into `user` (`user`.username,`user`.`password`,`user`.studentid) VALUES(#{username},#{password},#{studentid})")
    int addStudentUser(@Param("username") String username, @Param("password") String password,@Param("studentid") int studentid);

    @Insert("insert into `user` (`user`.username,`user`.`password`,`user`.teacherid) VALUES(#{username},#{password},#{teacherid})")
    int addTeacherUser(@Param("username") String username,@Param("password") String password, @Param("teacherid") int teacherid);
    @Insert("insert into `user` (`user`.username,`user`.`password`) VALUES(#{username},#{password})")
    int addUser(@Param("username") String username,@Param("password") String password);

    @Update("UPDATE `user`  set `user`.`password`=#{newPassword} where `user`.userid=#{userid}")
    int updata(@Param("userid") String userid,@Param("newPassword") String newPassword);
}
