package org.william.util.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

/**
 * Mongo客户端操作类
 */
@Component
public class MongoOps {
	
    @Autowired(required = false)
    private MongoTemplate mongoTemplate;

    /**
     * 插入json文档到集合
     * @param collectionName
     * @param json
     * @throws MongoException
     */
    public void insertJson(String collectionName, String json) throws MongoException {
        try {
            BasicDBObject dbObject = (BasicDBObject) JSON.parse(json);
            mongoTemplate.getDb().getCollection(collectionName).insert(dbObject);
        } catch (Exception e) {
            throw new MongoException(String.format("[Mongo] insertJson failed, error: %s", e.getMessage()), e);
        }
    }

    /**
     * 插入json与map到集合
     * @param collectionName
     * @param json
     * @param map
     * @throws MongoException
     */
    public void insertJsonWithMap(String collectionName, String json, Map map) throws MongoException {
        try {
            BasicDBObject dbObject = (BasicDBObject) JSON.parse(json);
            dbObject.putAll(map);
            mongoTemplate.getDb().getCollection(collectionName).insert(dbObject);
        } catch (Exception e) {
            throw new MongoException(String.format("[Mongo] insertJsonWithMap failed, error: %s", e.getMessage()), e);
        }
    }

    /**
     * 插入Object到集合
     * @param collectionName
     * @param obj
     * @throws MongoException
     */
    public void insertObject(String collectionName, Object obj) throws MongoException {
        try {
            mongoTemplate.insert(obj, collectionName);
        } catch (Exception e) {
            throw new MongoException(String.format("[Mongo] insertObject failed, error: %s", e.getMessage()), e);
        }
    }

    /**
     * 插入多个Object到集合
     * @param collectionName
     * @param objects
     * @throws MongoException
     */
    public void insertObjects(String collectionName, Collection<? extends Object> objects) throws MongoException {
        try {
            mongoTemplate.insert(objects, collectionName);
        } catch (Exception e) {
            throw new MongoException(String.format("[Mongo] insertObjects failed, error: %s", e.getMessage()), e);
        }
    }
 }
