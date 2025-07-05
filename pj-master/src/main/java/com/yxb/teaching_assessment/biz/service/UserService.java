package com.yxb.teaching_assessment.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxb.teaching_assessment.biz.entity.User;
import com.yxb.teaching_assessment.biz.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 根据用户id查找用户
     * @param userId
     * @return
     */
    public User findUserById(String userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userId);
        return userMapper.selectOne(queryWrapper);
    }

    /**
     * 根据用户名查找用户
     * @param user
     * @return
     */
    public User findUserByUsername(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        return userMapper.selectOne(queryWrapper);
    }

    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    public List<User> findAllUser(int page, int limit) {
        page=(page-1)*limit;
       List<User>  list=userMapper.findAllUser(page,limit);
       return  list;
    }

    public int addStudentUser(User user){
        String username=user.getUsername();
        String password=user.getPassword();
        int studentid=user.getStudentid();
       int ret= userMapper.addStudentUser(username,password,studentid);
       return ret;
    }

    public int addTeacherUser(User user){
        String username=user.getUsername();
        String password=user.getPassword();
        int teacherid=user.getTeacherid();
        int ret= userMapper.addTeacherUser(username,password,teacherid);
        return ret;
    }
    public int addUser(User user){
        String username=user.getUsername();
        String password=user.getPassword();

        int ret= userMapper.addUser(username,password);
        return ret;
    }

    public int updata(String userid, String newPassword) {
      return   userMapper.updata(userid,newPassword);
    }
}
