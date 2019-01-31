package com.zhuguang.jack.service;

import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.bean.ConsultContent;
import com.zhuguang.jack.bean.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("cacheServiceImpl")
public class CacheServiceImpl implements MyService {

    @Cacheable(cacheNames = "content",key = "'doSomething' + #param")
    @Override
    public String doSomething(String param) {
        System.out.println("===========" + param);
        return "=================" + param;
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

    @Cacheable(cacheNames = "mapCache",key = "#user.uid")
    @Override
    public User queryUser(User user) {
        System.out.println("===========用户查询=========" + user.getUid());
        return user;
    }
}
