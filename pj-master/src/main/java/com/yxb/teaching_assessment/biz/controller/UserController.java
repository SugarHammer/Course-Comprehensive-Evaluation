package com.yxb.teaching_assessment.biz.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yxb.teaching_assessment.biz.entity.Student;
import com.yxb.teaching_assessment.biz.entity.Teacher;
import com.yxb.teaching_assessment.biz.entity.User;
import com.yxb.teaching_assessment.biz.service.StudentService;
import com.yxb.teaching_assessment.biz.service.TeacherService;
import com.yxb.teaching_assessment.biz.service.UserService;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;
import com.yxb.teaching_assessment.biz.vo.ResultVO;
import com.yxb.teaching_assessment.common.token.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Api(tags = "用户模块接口")
@RequestMapping("/user")
public class UserController extends AbstractBaseCtrl {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;

    /**
     * 登录接口
     * @param user
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "用户登录")
    public JSONObject login(@RequestBody User user, HttpServletRequest request) {
        JSONObject ret=new JSONObject();
        User userForBase=userService.findUserByUsername(user);
        if(userForBase==null){
            ret.put("result","0");
            ret.put("message","用户名错误");
            ret.put("data","error");

            return ret;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                ret.put("result","0");
                ret.put("message","密码错误");
                ret.put("data","error");
                return ret;
            }else {
                String token = tokenService.getToken(userForBase);

                ret.put("token",token);
                ret.put("message","登录成功");
                ret.put("user",userForBase);
                request.getSession().setAttribute("token",token);
             request.getSession().setAttribute("user",userForBase);
            System.out.println( "dsfdksfhds"+ request.getSession().getAttribute("token"));
                return ret;
            }
        }
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户激活（注册）")
    public ResultVO register(@RequestParam("username")String username){
        Student student = studentService.findByStudentNo(username);
        if (student!=null){
            User user = new User();
            user.setUsername(username);
            user.setPassword("123456");
            user.setStudentid(student.getStudentid());
            int ret = userService.insertUser(user);
            if (ret==1){
                return success("学生注册成功");
            }else {
                return success("学生注册失败");
            }
        }else {
            Teacher teacher = teacherService.findByTeacherno(username);
            if (teacher!=null){
                User user = new User();
                user.setUsername(username);
                user.setPassword("123456");
                user.setTeacherid(teacher.getTeacherid());
                int ret = userService.insertUser(user);
                if (ret==1){
                    return success("教师注册成功");
                }else {
                    return success("教师注册失败");
                }
            }else {
                return success("该账号不存在");
            }
        }
    }

    @GetMapping("/index")
    @ApiOperation(value = "用户首页")
    public ResultVO index(@RequestParam("id")String id){
        User user = userService.findUserById(id);
        if (user.getTeacherid()!=null){
            Teacher teacher = teacherService.selectByTeacherid(user.getTeacherid());
            return success(teacher);
        }
        if (user.getStudentid()!=null){
            Student student = studentService.findById(String.valueOf(user.getStudentid()));
            return success(student);
        }else {
            return success("管理员");
        }
    }

    @GetMapping("/findAllUser")
    @ApiOperation(value = "用户列表")
    public ResultVO findAllUser(@RequestParam("page") int page,@RequestParam("limit") int limit){
       List<User> userList=userService.findAllUser(page,limit);
        int count=  userList.size();
        return  success(count,userList);
    }
    @PostMapping("/insert")
    @ApiOperation(value = "增加")
    public ResultVO insertUser(@RequestBody User user) {
          User user1=   userService.findUserByUsername(user);
          if(user1!=null){
              return success("账号已经存在咯");
          } else if (user.getStudentid() != null) {
            int ret = userService.addStudentUser(user);
            if (ret ==1) {
                return success("插入成功");
            } else {
                return success("插入失败");
            }
        } else if (user.getTeacherid() != null) {
            int ret1 = userService.addTeacherUser(user);
            if (ret1== 1) {
                return success("插入成功");
            } else {
                return success("插入失败");
            }
        } else {
            int ret2 = userService.addUser(user);

            if (ret2 == 1) {
                return success("插入成功");
            } else {
                return success("插入失败");
            }
        }


    }
    @GetMapping("/findByOne")
    @ApiOperation(value = "根据id查询用户")
    public ResultVO findByOne(@RequestParam("userid") String usrid){
        User user= userService.findUserById(usrid);
        return  success(user);
    }
   @GetMapping("/updata")
   @ApiOperation(value = "修改密码")
    public ResultVO updata(@RequestParam("userid") String userid,@RequestParam("oldPassword")String oldPassword,@RequestParam("newPassword") String newPassword){
      User user=userService.findUserById(userid);
      if(user.getPassword().equals(oldPassword)){
         int ret=  userService.updata(userid,newPassword);
         if(ret==1){
             return success("更新成功");
         }else {
             return error("更新失败");
         }
      }else {
          return  error("旧密码不正确");
      }

   }
    @GetMapping("/out")
    @ApiOperation(value = "退出")
   public ResultVO out(HttpServletRequest request){
    HttpSession session=request.getSession();
    session.invalidate();
    System.out.println("清空了Swssion");
    return success("成功");
   }

}
