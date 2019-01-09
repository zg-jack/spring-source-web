package com.zhuguang.jack.aop.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DosomethingIntercepter2 implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName() + "执行前...");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println(method.getName() + "执行后...");
        return object;
    }
}
