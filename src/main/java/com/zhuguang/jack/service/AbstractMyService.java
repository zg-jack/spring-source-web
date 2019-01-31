package com.zhuguang.jack.service;

import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.bean.ConsultContent;
import com.zhuguang.jack.bean.User;

import java.util.List;
import java.util.Map;

public abstract class AbstractMyService implements MyService  {
    @Override
    public String doSomething(String param) {
        return null;
    }

    @Override
    public String throwTest(String param) {
        return null;
    }

    @Override
    public List<ConsultContent> queryContent(Map param) {
        return null;
    }

    @Override
    public int saveArea(ConsultConfigArea area) {
        return 0;
    }

    @Override
    public void saveTest(String param) {

    }

    @Override
    public void saveTest1(String param) {

    }

    @Override
    public void queryAllTest() {

    }

    public abstract User queryUser(User user);
}
