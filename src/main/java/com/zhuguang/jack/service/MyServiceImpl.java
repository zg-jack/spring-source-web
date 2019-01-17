package com.zhuguang.jack.service;

import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.bean.ConsultContent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("myServiceImpl")
public class MyServiceImpl implements MyService {

    public String doSomething(String param) {
        System.out.println("===================targetClass doSomething=================");
        return "===================targetClass doSomething=================";
    }

    @Override
    public String throwTest(String param) {
        throw new RuntimeException("异常=================");
    }

    @Override
    public List<ConsultContent> queryContent(Map param) {
        return null;
    }

    @Override
    public int saveArea(ConsultConfigArea area) {
        return 0;
    }
}
