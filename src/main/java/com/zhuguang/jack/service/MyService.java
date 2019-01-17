package com.zhuguang.jack.service;

import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.bean.ConsultContent;

import java.util.List;
import java.util.Map;

public interface MyService {
    public String doSomething(String param);

    public String throwTest(String param);

    List<ConsultContent> queryContent(Map param);

    public int saveArea(ConsultConfigArea area);
}
