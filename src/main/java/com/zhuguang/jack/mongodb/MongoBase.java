package com.zhuguang.jack.mongodb;

import java.util.List;
import java.util.Map;

public interface MongoBase<T> {
    //添加
    void insert(T object, String collectionName);

    //根据条件查找单个对象
    T findOne(Map<String, Object> params, String collectionName);

    //查找所有
    List<T> findAll(String collectionName);

    //修改
    void update(Map<String, Object> params, String collectionName);

    //创建集合
    void createCollection(String collectionName);

    //根据条件删除
    void remove(Map<String, Object> params, String collectionName);
}
