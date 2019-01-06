package com.zhuguang.jack.prototype;

public class PrototypeTestB {
    public String username;

    PrototypeTestA prototypeTestA;

    public PrototypeTestA getPrototypeTestA() {
        return this.prototypeTestA;
    }

    public void setPrototypeTestA(PrototypeTestA prototypeTestA) {
        this.prototypeTestA = prototypeTestA;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
