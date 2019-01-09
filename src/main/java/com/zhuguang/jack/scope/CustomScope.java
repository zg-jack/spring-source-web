package com.zhuguang.jack.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class CustomScope implements Scope  {

    private ThreadLocal local = new ThreadLocal();

    /*
    * 这个方法就是自己管理bean
    * */
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        System.out.println("=============CustomScope========");
        if(local.get() != null) {
            return local.get();
        } else {
            //这个方法就是掉createbean方法获得一个实例
            Object object = objectFactory.getObject();
            local.set(object);
            return object;
        }
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
