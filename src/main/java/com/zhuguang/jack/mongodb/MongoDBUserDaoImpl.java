package com.zhuguang.jack.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("mongoDBUserDao")
public class MongoDBUserDaoImpl implements MongoDBUserDao {

    @Autowired
    @Qualifier("mongoTemplate")
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(MongoDBUser object, String collectionName) {
        mongoTemplate.insert(object, collectionName);
    }

    @Override
    public MongoDBUser findOne(Map<String, Object> params, String collectionName) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(params.get("id"))), MongoDBUser.class,
                collectionName);
    }

    @Override
    public List<MongoDBUser> findAll(String collectionName) {
        return mongoTemplate.findAll(MongoDBUser.class, collectionName);
    }

    @Override
    public void update(Map<String, Object> params, String collectionName) {
        Update update = new Update();
        if (null != params.get("username")) {
            update.set("username", params.get("username"));
        }
        if (null != params.get("password")) {
            update.set("password", params.get("password"));
        }
        mongoTemplate.upsert(new Query(Criteria.where("id").is(params.get("id"))), update, MongoDBUser.class,
                collectionName);
    }

    @Override
    public void createCollection(String collectionName) {
        mongoTemplate.createCollection(collectionName);
    }

    @Override
    public void remove(Map<String, Object> params, String collectionName) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(params.get("id"))), MongoDBUser.class, collectionName);
    }
}
