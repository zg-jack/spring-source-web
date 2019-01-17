package com.zhuguang.jack.aop.cglib;

public class Test {
    public static void main(String[] args) {
        UserService userService = (UserService)CglibBeanFactory.getInstance();
        System.out.println(userService.myMethod("Jack"));
    }
}
