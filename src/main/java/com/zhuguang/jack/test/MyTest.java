package com.zhuguang.jack.test;

import com.zhuguang.jack.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:config/spring/applicationContext-core.xml")
public class MyTest {

    @Autowired
    MyService myService;

    @Test
    public void test1() {
        System.out.println("车菜鸟裹裹");
    }

    @Test
    public void aop() {
        myService.doSomething("Jack");
    }

    @Test
    public void aopThrowtest() {
        myService.throwTest("Jack");
    }

}
