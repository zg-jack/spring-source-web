package com.zhuguang.jack.aop.cglib;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class CglibCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if ("doSomething0".equalsIgnoreCase(method.getName())) {
            return 3;
        } else if ("doSomething1".equalsIgnoreCase(method.getName())) {
            return 1;
        } else if ("doSomething2".equalsIgnoreCase(method.getName())) {
            return 2;
        } else if ("xx".equalsIgnoreCase(method.getName())){
            return 3;
        } else {
            return 4;
        }
    }
}
