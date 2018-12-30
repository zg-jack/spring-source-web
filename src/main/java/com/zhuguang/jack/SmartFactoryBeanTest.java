package com.zhuguang.jack;

import org.springframework.beans.factory.SmartFactoryBean;

public class SmartFactoryBeanTest implements SmartFactoryBean {
    @Override
    public boolean isPrototype() {
        return false;
    }

    @Override
    public boolean isEagerInit() {
        System.out.println("================>>SmartFactoryBeanTest");
        return true;
    }

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
