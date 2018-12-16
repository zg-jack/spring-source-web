package com.zhuguang.jack.testbean;

public abstract class ShowSixClass {
    public void showsix() {
        getPeople().showsix();
    }

    public abstract People getPeople();
}
