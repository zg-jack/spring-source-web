package com.zhuguang.jack.tag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

public class Test {
    
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext(
                "mytest.xml");
        System.out.println(app);

        Jedis client1 = (Jedis)app.getBean("redis");
        System.out.println(client1);
        
        System.out.println(client1.set("keyname1", "valuejack1"));
    }
}
