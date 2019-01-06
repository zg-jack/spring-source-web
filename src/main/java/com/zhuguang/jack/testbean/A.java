package com.zhuguang.jack.testbean;

import org.springframework.beans.factory.InitializingBean;

public class A implements InitializingBean {
    B b;

    public String username;

    public B getB() {
        return this.b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("======afterPropertiesSet");
    }

    public void initMethod() {
        System.out.println("======initMethod");
    }

//    public A(B b) {
//        this.b = b;
//    }
}
