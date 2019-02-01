package com.zhuguang.jack.cache;

import com.alibaba.fastjson.JSONObject;
import com.zhuguang.jack.mongodb.MongoDBUser;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.io.Serializable;
import java.sql.Connection;
import java.util.concurrent.Callable;

public class MongodbCache implements Cache {

    private String name;

    private MongoTemplate mongoTemplate;

    private String collection;

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this.mongoTemplate;
    }

    @Override
    public ValueWrapper get(Object key) {
        System.out.println("------缓存获取mongodb-------"+key.toString());
        Object value = null;
        String keyf = key.toString();
        byte[] keyb = keyf.getBytes();
        MongodbCacheBean bean = mongoTemplate.findOne(new Query(Criteria.where("id").is(keyb)),
                MongodbCacheBean.class,
                collection);
        if(bean != null) {
            System.out.println("------获取到数据为:" + bean.getId() + ":" + bean.getValue() + "---------");
            value = SerializationUtils.deserialize(bean.getValue());
        }
        return value != null ? new SimpleValueWrapper(value) : null;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        System.out.println("-------加入缓存mongodb------");
        System.out.println("--------key----:"+key);
        System.out.println("--------value----:"+value);
        String keyString  = key.toString();
        byte[] keyb = keyString.getBytes();
        byte[] valueb = SerializationUtils.serialize((Serializable) value);
        MongodbCacheBean bean = new MongodbCacheBean();
        bean.setId(keyb);
        bean.setValue(valueb);
        mongoTemplate.insert(bean,collection);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        return null;
    }

    @Override
    public void evict(Object key) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(key)),collection);
    }

    @Override
    public void clear() {
        mongoTemplate.remove(new Query(),collection);
    }
}
