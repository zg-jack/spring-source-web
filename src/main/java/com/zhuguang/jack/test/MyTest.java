package com.zhuguang.jack.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:config/spring/spring-dispatcher.xml")
public class MyTest {
    

    @Test
    public void test1() {
        System.out.println("车菜鸟裹裹");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext path = new ClassPathXmlApplicationContext("classpath*:config/spring/spring-dispatcher.xml");
        System.out.println(path);
    }
}
