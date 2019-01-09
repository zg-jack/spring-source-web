package com.zhuguang.jack.aop.jdkProxy;

public class Jack implements People {
    @Override
    public String eat(String param) {
        System.out.println("=========Jack老师喜欢吃东西=======");
        return "=========Jack老师喜欢吃东西=======";
    }
}
