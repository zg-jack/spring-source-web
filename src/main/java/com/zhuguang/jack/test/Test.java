package com.zhuguang.jack.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config" +
                "/spring/applicationContext-core.xml");
        context.setAllowBeanDefinitionOverriding(true);
        context.setAllowCircularReferences(true);
        context.refresh();
    }
}
