package com.zhuguang.jack.prototype;

public class PrototypeTestA {
    public String username;

    PrototypeTestB prototypeTestB;

    public PrototypeTestB getPrototypeTestB() {
        return this.prototypeTestB;
    }

    public void setPrototypeTestB(PrototypeTestB prototypeTestB) {
        this.prototypeTestB = prototypeTestB;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
