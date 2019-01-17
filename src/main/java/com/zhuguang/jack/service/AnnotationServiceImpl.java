package com.zhuguang.jack.service;

import com.zhuguang.jack.annotation.TargetMethod;
import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.bean.ConsultContent;
import com.zhuguang.jack.dao.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("annotationServiceImpl")
public class AnnotationServiceImpl implements MyService {

    @Autowired
    CommonMapper commonMapper;

    @TargetMethod(name = "Jack")
    @Override
    public String doSomething(String param) {
        System.out.println("==========AnnotationServiceImpl.doSomething");
        return "==========AnnotationServiceImpl.doSomething";
    }

    @Override
    public String throwTest(String param) {
        return null;
    }

    @Override
    public List<ConsultContent> queryContent(Map param) {
        return commonMapper.queryContent(param);
    }


    @Override
    public int saveArea(ConsultConfigArea area) {
        int count = commonMapper.saveArea(area);

        if(false)throw new RuntimeException("异常");
        return count;
    }
}
