package org.william.util.mongo;




/**
 * Mongo操作异常类
 */
public class MongoException extends Exception {

    public MongoException(String message) {
        super(message);
    }

    public MongoException(String message, Throwable e) {
        super(message, e);
    }
}
