package com.zhuguang.jack.test;

import com.zhuguang.jack.annotation.MyAnnotationInstance;
import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.dao.CommonMapper;
import com.zhuguang.jack.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:config/spring/applicationContext-core.xml")
public class MyTest {

    @Autowired
    @Qualifier("myServiceImpl")
    MyService myService;

    @Autowired
    @Qualifier("annotationServiceImpl")
    MyService myService1;

    @Test
    public void test1() {
        System.out.println("车菜鸟裹裹");
    }

    @Test
    public void aop() {
        myService.doSomething("Jack");
    }

    @Test
    public void aop1() {
        myService1.doSomething("Jack");
    }

    @Test
    public void aopThrowtest() {
        myService.throwTest("Jack");
    }

    @Autowired
    CommonMapper commonMapper;

    @Autowired
    MyAnnotationInstance myAnnotationInstance;

    @Test
    public void test2() {
        System.out.println(commonMapper.queryContent(new HashMap()));
    }

    @Test
    public void test3() {
        ConsultConfigArea area = new ConsultConfigArea();
        area.setAreaCode("HB");
        area.setAreaName("HB");
        area.setState("1");
        myService1.saveArea(area);
    }

    @Test
    public void test4() {
        try {
            myService.saveTest("Jack22");
        } finally {
            myService.queryAllTest();
        }
    }

    @Test
    public void test5() {
        myService.queryAllTest();
    }

    @Test
    public void test6() {
        System.out.println("==========test6===========" + myAnnotationInstance.getName());
    }
}
