package com.zhuguang.jack.applicationContextInitializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.PriorityOrdered;

public class MyApplicationContextInitializer implements ApplicationContextInitializer,PriorityOrdered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("===========MyApplicationContextInitializer");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
