package com.zhuguang.jack.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    public String doSomething(String param) {
        System.out.println("===================targetClass doSomething=================");
        return "===================targetClass doSomething=================";
    }

    @Override
    public String throwTest(String param) {
        throw new RuntimeException("异常=================");
    }
}
