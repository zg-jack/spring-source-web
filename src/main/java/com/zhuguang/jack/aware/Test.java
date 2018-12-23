package com.zhuguang.jack.aware;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext
                ("classpath*:config/spring/applicationContext-core.xml");
        TargetClass bean = (TargetClass) ctx.getBean("targetClass");
//        TargetClass tc = new TargetClass();
        bean.doSomething();
    }
}
