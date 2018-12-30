package com.zhuguang.jack.testbean;

import org.springframework.beans.factory.annotation.Autowired;

public class Man implements People {

    @Autowired
    Son son;

    @Override
    public void showsix() {
        System.out.println("i am man!");
    }
}
