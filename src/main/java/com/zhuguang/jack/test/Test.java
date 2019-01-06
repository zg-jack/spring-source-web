package com.zhuguang.jack.test;

import com.zhuguang.jack.testbean.ListInjectTest;
import com.zhuguang.jack.testbean.Son;
import com.zhuguang.jack.typeConverter.TypeClass;
import com.zhuguang.jack.typeConverter.TypeConverterTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config" +
                "/spring/applicationContext-core.xml");
//        context.setAllowBeanDefinitionOverriding(true);
//        context.setAllowCircularReferences(true);
//        context.refresh();
        Son son = (Son)context.getBean("son");
        System.out.println(son.getUsername()+":" + son.getAge());

        ListInjectTest injectTest = (ListInjectTest)context.getBean("injectTest");
        TypeClass typeClass = (TypeClass)context.getBean("typeClass");
        System.out.println(typeClass.getDate());
        System.out.println(typeClass.getConsultRecord().getName());

        List<String> list = injectTest.getList();
        if(list != null) {
            for (String o : list) {
                System.out.println("list : " + o);
            }
        }
        
        Map<String,String> map = injectTest.getMap();
        if(map != null) {
            System.out.println("======");
            for(Map.Entry<String,String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
//        prototypeTest(context);
//        prototypecircularreference(context);
        requestScope(context);
    }

    public static void prototypeTest(final ApplicationContext context) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(context.getBean("prototypeTestA"));
                }
            }).start();
        }
    }

    public static void prototypecircularreference(ApplicationContext context) {
        context.getBean("prototypeTestA");
        context.getBean("prototypeTestB");
    }

    public static void requestScope(ApplicationContext context) {
        Object scopeTest = context.getBean("scopeTest");
        System.out.println(scopeTest);
    }
}
