package com.dragonsoft;

import com.dragonsoft.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

/**
 * 测试在SpringBoot环境下使用原生JPA
 * @author ronin
 * @version V1.0
 * @since 2019/11/19 14:29
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBoot_JPATest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 获取EntityManager的方法1:
     *      通过entityManagerFactory获取
     */
    @Test
    public void fun1(){
        User user = entityManager.find(User.class, "1");
        System.out.println(user);
    }

    /**
     * 获取EntityManager的方法2:
     *      通过@PersistenceContext获取
     */
    @Test
    public void fun2(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.getReference(User.class, "1");
        System.out.println(user);
    }
}
