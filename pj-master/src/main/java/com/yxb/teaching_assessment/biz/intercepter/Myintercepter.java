package com.yxb.teaching_assessment.biz.intercepter;

import com.auth0.jwt.JWT;
import com.yxb.teaching_assessment.common.token.TokenService;
import com.yxb.teaching_assessment.common.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*自定义拦截器*/

@Component
@Configuration
public class Myintercepter implements WebMvcConfigurer {

@Autowired
    TokenService tokenService;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      HandlerInterceptor inter=new HandlerInterceptor() {
          @Override
          public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*    Object user=request.getSession().getAttribute("token");
              String token=request.getHeader("token");
              System.out.println("MyInter"+token);

             if(token!=null&&token!=""){
                 System.out.println("执行了true");
                 return true;

             }else {
                 System.out.println("执行了false");
                 return true;
             }*/



          return true;


          }

          @Override
          public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

          }

          @Override
          public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

          }
      };
        String url="/user/login";

        registry.addInterceptor(inter).addPathPatterns("/**")
                .excludePathPatterns("/css/**","/js/**","/images/**")//排除样式、脚本、图片等资源文件
                .excludePathPatterns("/login.html")
                .excludePathPatterns(url)
                .excludePathPatterns("index.html")
                .excludePathPatterns("/teResult/teacherCheck")
                .excludePathPatterns("/teResult/teacherClazz")
                .excludePathPatterns("");//排除登录页面




    }
}
