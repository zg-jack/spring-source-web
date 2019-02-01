package com.zhuguang.jack.cache;

public class MongodbCacheBean {
    private byte[] id;

    private byte[] value;

    public byte[] getId() {
        return this.id;
    }

    public void setId(byte[] id) {
        this.id = id;
    }

    public byte[] getValue() {
        return this.value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }
}
