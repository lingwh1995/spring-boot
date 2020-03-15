package com.dragonsoft.test;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.util.HashMap;

/**
 * 测试MongoDriver操作Mongo驱动:单节点模式
 * 插入样例数据:
 *      use spitdb
 *      db.spit.insert({_id:'0001',messge:'hello mongo!',visited:NumberInt('100')});
 *      db.spit.insert({_id:'0002',messge:'zhangsan!',visited:NumberInt('200')});
 *      db.spit.insert({_id:'0003',messge:'lisi!',visited:NumberInt('300')});
 * @author ronin
 */
public class MongoDriverSingleTest {

    /**
     * Java操作MongoDB方式1:查询
     */
    @Test
    public void fun1() {
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress("192.168.1.131", 27017);
        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("admin", "admin", "123456".toCharArray());
        //设置连接选项
        MongoClientOptions options = MongoClientOptions.builder()
                //设置连接超时时间为10s
                .connectTimeout(1000 * 10)
                //设置最长等待时间为10s
                .maxWaitTime(1000 * 10)
                .build();
        MongoClient mongoClient = new MongoClient(serverAddress, mongoCredential,options);
        System.out.println("获取到的Mongo客户端:" + mongoClient);

        //得到想要操作的数据库
        MongoDatabase database = mongoClient.getDatabase("spitdb");

        //获取mongodb中所有的集合名称
        for (String collectionName : database.listCollectionNames()) {
            System.out.println(collectionName);
        }

        //获取mongodb中所有的集合名称
        for (Document document : database.listCollections()) {
            System.out.println(document);
        }
        //获取想要操作的集合/表
        MongoCollection<Document> collection = database.getCollection("spit");
        //遍历集合获取所有的文档
        FindIterable<Document> documents = collection.find();
        for (Document document : documents) {
            System.out.println(document);
        }

        System.out.println("-----------------------------------------------------------------------");
        //根据条件进行查询
        //筛选用户id为0001的: db.spit.find({id,'0001'});
        BasicDBObject condition1 = new BasicDBObject("_id", "0001");
        FindIterable<Document> documentsByCondition1 = collection.find(condition1);
        for (Document document : documentsByCondition1) {
            System.out.println(document);
        }
        System.out.println("-----------------------------------------------------------------------");
        //筛选用户visited为0001的: db.spit.find({visited,{$gt:100}});
        BasicDBObject condition2 = new BasicDBObject("visited", new BasicDBObject("$gt",100));
        FindIterable<Document> documentsByCondition2 = collection.find(condition2);
        for (Document document : documentsByCondition2) {
            System.out.println(document);
        }

        mongoClient.close();
    }

    /**
     * Java操作MongoDB方式2:查询
     */
    @Test
    public void fun2() {
        String mongoUrl= "mongodb://admin:123456@192.168.1.131:27017/?ssl=false";
        //设置连接选项
        MongoClientOptions.Builder optionsBuilder = new MongoClientOptions
                .Builder()
                //设置连接超时时间为10s
                .connectTimeout(1000 * 10)
                //设置最长等待时间为10s
                .maxWaitTime(1000 * 10);
        MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoUrl,optionsBuilder));
        System.out.println("获取到的Mongo客户端:" + mongoClient);

        //得到想要操作的数据库
        MongoDatabase database = mongoClient.getDatabase("spitdb");

        //获取mongodb中所有的集合名称
        for (String collectionName : database.listCollectionNames()) {
            System.out.println(collectionName);
        }

        //获取mongodb中所有的集合名称
        for (Document document : database.listCollections()) {
            System.out.println(document);
        }
        //获取想要操作的集合/表
        MongoCollection<Document> collection = database.getCollection("spit");
        //遍历集合获取所有的文档
        FindIterable<Document> documents = collection.find();
        for (Document document : documents) {
            System.out.println(document);
        }

        System.out.println("-----------------------------------------------------------------------");
        //根据条件进行查询
        //筛选用户id为0001的: db.spit.find({id,'0001'});
        BasicDBObject condition1 = new BasicDBObject("_id", "0001");
        FindIterable<Document> documentsByCondition1 = collection.find(condition1);
        for (Document document : documentsByCondition1) {
            System.out.println(document);
        }
        System.out.println("-----------------------------------------------------------------------");
        //筛选用户visited为0001的: db.spit.find({visited,{$gt:100}});
        BasicDBObject condition2 = new BasicDBObject("visited", new BasicDBObject("$gt",100));
        FindIterable<Document> documentsByCondition2 = collection.find(condition2);
        for (Document document : documentsByCondition2) {
            System.out.println(document);
        }

        mongoClient.close();
    }

    /**
     * Java操作MongoDB方式:添加
     */
    @Test
    public void fun3() {
        String mongoUrl= "mongodb://admin:123456@192.168.1.131:27017/?ssl=false";
        //设置连接选项
        MongoClientOptions.Builder optionsBuilder = new MongoClientOptions
                .Builder()
                //设置连接超时时间为10s
                .connectTimeout(1000 * 10)
                //设置最长等待时间为10s
                .maxWaitTime(1000 * 10);
        MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoUrl,optionsBuilder));
        System.out.println("获取到的Mongo客户端:" + mongoClient);

        //得到想要操作的数据库
        MongoDatabase database = mongoClient.getDatabase("spitdb");
        //获取想要操作的集合/表
        MongoCollection<Document> collection = database.getCollection("spit");

        System.out.println("-----------------------------------------------------------------------");
        //执行添加操作
        HashMap<String, Object> param = new HashMap<>();
        param.put("_id","0004");
        param.put("messge","zhaoliu");
        param.put("visited",400);
        Document document = new Document(param);
        collection.insertOne(document);
        mongoClient.close();
    }
}
