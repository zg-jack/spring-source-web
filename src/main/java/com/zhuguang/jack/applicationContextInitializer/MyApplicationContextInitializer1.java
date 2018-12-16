package com.zhuguang.jack.applicationContextInitializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.PriorityOrdered;

public class MyApplicationContextInitializer1 implements ApplicationContextInitializer,PriorityOrdered {
    //在spring容器初始化之前对spring的上下文做一些修改
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("===========MyApplicationContextInitializer");
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
