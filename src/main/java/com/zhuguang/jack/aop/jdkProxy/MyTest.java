package com.zhuguang.jack.aop.jdkProxy;

import java.lang.reflect.Proxy;

public class MyTest {
    public static void main(String[] args) {
        People proxyObject = (People)Proxy.newProxyInstance(MyTest.class.getClassLoader(), new Class<?>[]{People.class},
                new Advice(new Jack()));

        proxyObject.eat("chi");
    }
}
