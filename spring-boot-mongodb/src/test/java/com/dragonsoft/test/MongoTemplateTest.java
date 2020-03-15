package com.dragonsoft.test;

import com.dragonsoft.entity.Spit;
import com.dragonsoft.service.SpitMongoRepositotyService;
import com.dragonsoft.service.SpitMongonTemplateService;
import com.mongodb.client.result.DeleteResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ronin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTemplateTest {

    @Autowired
    private SpitMongonTemplateService spitMongonTemplateService;

    /**
     * 查询所有Spit
     */
    @Test
    public void fun1(){
        List<Spit> spits = spitMongonTemplateService.findAll();
        System.out.println("------------------------------------------------");
        spits.forEach(item -> System.out.println(item));
        System.out.println("------------------------------------------------");
    }

    /**
     * 根据id查询单个Spit
     */
    @Test
    public void fun2(){
        Spit spit = spitMongonTemplateService.findById("0001");
        System.out.println("------------------------------------------------");
        System.out.println(spit);
        System.out.println("------------------------------------------------");
    }

    /**
     * 保存Spit
     */
    @Test
    public void fun3(){
        Spit spit = new Spit();
        spit.set_id("0005");
        spit.setMessge("i am kangyj");
        spit.setVisited("500");
        Spit saveResult = spitMongonTemplateService.save(spit);
        fun1();
    }

    /**
     * 根据SpitId删除spit
     */
    @Test
    public void fun4(){
        //调用fun3()先添加一个
        fun3();
        fun1();
        Spit spit = spitMongonTemplateService.findById("0005");
        DeleteResult deleteResult = spitMongonTemplateService.remove(spit);
        System.out.println(deleteResult);
        fun1();
    }

    /**
     * 更新Spit
     */
    @Test
    public void fun5(){
        //先添加再更新
        Spit spit = new Spit();
        spit.set_id("0006");
        spit.setMessge("我是原来的内容");
        spit.setVisited("500");
        Spit saveResult = spitMongonTemplateService.save(spit);
        fun1();
        //我是更新后的内容
        spit = spitMongonTemplateService.findById(spit.get_id());
        spit.setMessge("我是更新后的内容");
        spit = spitMongonTemplateService.update(spit);
        fun1();
    }
}
