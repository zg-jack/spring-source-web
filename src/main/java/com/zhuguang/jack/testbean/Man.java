package com.zhuguang.jack.testbean;

public class Man implements People {

//    @Lazy
//    @Autowired
    Son son;

    @Override
    public void showsix() {
        System.out.println("i am man!");
    }
}
