package com.zhuguang.jack.annotation;

@MyService
public class MyAnnotationInstance {
    public String name = "jack";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
