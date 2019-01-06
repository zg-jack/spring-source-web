package com.zhuguang.jack.factoryBean;

import com.zhuguang.jack.testbean.Woman;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class FactoryBeanTest {


    @Autowired(required = false)
    public Woman woman;

    @Autowired
    public void setWoman(Woman woman) {
        this.woman = woman;
    }

    public Object getObject() {
        System.out.println("我自己创建对象！！！");
        return new Object();
    }

    public FactoryBeanTest() {

    }

    public FactoryBeanTest(String paran,Map map) {

    }
}
