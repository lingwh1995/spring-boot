package com.dragonsoft;

import com.dragonsoft.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

/**
 * 测试SpringBoot环境下使用原生Hibernate
 * @author ronin
 * @version V1.0
 * @since 2019/11/19 14:23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBoot_HibernateTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    public void fun1(){
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        //获取SessionFactory
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        User user = session.get( User.class,"1");
        transaction.commit();
        //提交事务
        System.out.println(user);
    }
}
