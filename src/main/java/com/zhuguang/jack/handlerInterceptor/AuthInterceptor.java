package com.zhuguang.jack.handlerInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
* 登录权限校验
* */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("jack".equals(username) && "123".equals(password)) {
            System.out.println("================AuthInterceptor权限校验成功================");
            return true;
        }
        System.out.println("================AuthInterceptor权限校验失败================");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("================AuthInterceptor.postHandle================");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("================AuthInterceptor.afterCompletion================");
    }
}
