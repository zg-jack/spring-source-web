package com.zhuguang.jack.aop.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Advice implements InvocationHandler {

    People people;

    public Advice(People people) {
        this.people = people;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //前置增强
        before();

        //被代理方法
        Object value = method.invoke(people,args);

        //后置增强
        after();

        return value;
    }

    private void before() {
        System.out.println("===========jack吃饭之前需要洗手==========");
    }

    private void after() {
        System.out.println("===========jack吃完饭要洗碗=============");
    }
}
