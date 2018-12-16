package com.zhuguang.jack.springconfig;

import com.zhuguang.jack.testbean.Man;
import com.zhuguang.jack.testbean.OriginClass;
import com.zhuguang.jack.testbean.ShowSixClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class LoadSpring {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:config/spring/applicationContext-core.xml");

        ShowSixClass ss = (ShowSixClass)classPathXmlApplicationContext.getBean("people");
        System.out.println(classPathXmlApplicationContext);

        OriginClass oc = (OriginClass)classPathXmlApplicationContext.getBean("originClass");
        oc.method();

        Man man = (Man)classPathXmlApplicationContext.getBean("man");
        man.showsix();
        System.in.read();
    }
}
