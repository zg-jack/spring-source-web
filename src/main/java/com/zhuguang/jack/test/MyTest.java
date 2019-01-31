package com.zhuguang.jack.test;

import com.zhuguang.jack.annotation.MyAnnotationInstance;
import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.dao.CommonMapper;
import com.zhuguang.jack.mongodb.MongoDBUser;
import com.zhuguang.jack.mongodb.MongoDBUserDao;
import com.zhuguang.jack.redis.RedisUtil;
import com.zhuguang.jack.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:config/spring/applicationContext-core.xml")
public class MyTest {

    @Autowired
    @Qualifier("myServiceImpl")
    MyService myService;

    @Autowired
    @Qualifier("annotationServiceImpl")
    MyService myService1;

    @Test
    public void test1() {
        System.out.println("车菜鸟裹裹");
    }

    @Test
    public void aop() {
        myService.doSomething("Jack");
    }

    @Test
    public void aop1() {
        myService1.doSomething("Jack");
    }

    @Test
    public void aopThrowtest() {
        myService.throwTest("Jack");
    }

    @Autowired
    CommonMapper commonMapper;

    @Autowired
    MyAnnotationInstance myAnnotationInstance;

    @Test
    public void test2() {
        System.out.println(commonMapper.queryContent(new HashMap()));
    }

    @Test
    public void test3() {
        ConsultConfigArea area = new ConsultConfigArea();
        area.setAreaCode("HB");
        area.setAreaName("HB");
        area.setState("1");
        myService1.saveArea(area);
    }

    @Test
    public void test4() {
        try {
            myService.saveTest("Jack22");
        } finally {
            myService.queryAllTest();
        }
    }

    @Test
    public void test5() {
        myService.queryAllTest();
    }

    @Test
    public void test6() {
        System.out.println("==========test6===========" + myAnnotationInstance.getName());
    }

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test7() {
        String  str = "string";//1.字符串
        List<String> list = new ArrayList<String>();//list
        list.add("0");
        list.add("中国");
        list.add("2");
        Set<String> set = new HashSet<String>();//set
        set.add("0");
        set.add("中国");
        set.add("2");
        Map<String, Object> map = new HashMap();//map
        map.put("key1", "str1");
        map.put("key2", "中国");
        map.put("key3", "str3");



        redisUtil.del("myStr","str");//删除数据


        //1.字符串操作
        redisUtil.set("str", str);
        redisUtil.expire("str", 120);//指定失效时间为2分钟
        String str1 = (String) redisUtil.get("str");
        System.out.println(str1);

        //2.list操作
        redisUtil.lSet("list", list);
        redisUtil.expire("list", 120);//指定失效时间为2分钟
        List<Object> list1 = redisUtil.lGet("list", 0, -1);
        System.out.println(list1);

        //3.set操作
        redisUtil.sSet("set", set);
        redisUtil.expire("set", 120);//指定失效时间为2分钟
        Set<Object> set1 = redisUtil.sGet("set");
        System.out.println(set1);


        //3.map操作
        redisUtil.hmset("map", map);
        redisUtil.expire("map", 120);//指定失效时间为2分钟
        Map<Object, Object> map1 = redisUtil.hmget("map");
        System.out.println(map1);
    }
    @Autowired
    @Qualifier("cacheServiceImpl")
    MyService cacheService;

    @Test
    public void test8() {
        cacheService.doSomething("jack");
    }

    @Autowired
    @Qualifier("mongoDBUserDao")
    MongoDBUserDao mongoDBUserDao;

    @Test
    public void test9() {
        mongoDBUserDao.createCollection("zg_user");
    }

    @Test
    public void test10() {
        MongoDBUser user = new MongoDBUser();
        user.setId("2");
        user.setUsername("jack");
        user.setPassword("xxgetuy");
        mongoDBUserDao.insert(user,"zg_user");
    }

    @Test
    public void test11() {
        Map map = new HashMap();
        map.put("id","1");
        MongoDBUser zg_user = mongoDBUserDao.findOne(map, "zg_user");
        System.out.println(zg_user.getId() + ":" + zg_user.getUsername() + ":" + zg_user.getPassword());
    }

    @Test
    public void test12() {
        Map map = new HashMap();
        map.put("id","1");
        map.put("username","roy");
        map.put("password","erqqwe");
        mongoDBUserDao.update(map, "zg_user");
    }

    @Test
    public void test13() {
        List<MongoDBUser> users = mongoDBUserDao.findAll("zg_user");
        for (MongoDBUser user : users) {
            System.out.println(user.getId() + ":" + user.getUsername() + ":" + user.getPassword());
        }
    }
}
