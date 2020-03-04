package com.dragonsoft;

import com.dragonsoft.dao.mysql.IUserDaoMysql;
import com.dragonsoft.dao.oracle.IUserDaoOracle;
import com.dragonsoft.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/11/18 14:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisXmlTest {

    @Autowired
    private IUserDaoOracle userDaoOracle;

    @Autowired
    private IUserDaoMysql userDaoMysql;

    /**
     * 测试从Oracle数据库中查询数据
     */
    @Test
    public void fun1(){
        System.out.println("-----------------------------");
        System.out.println(userDaoOracle);
        User user = userDaoOracle.getUserById("001");
        System.out.println(user);
        System.out.println("-----------------------------");
        List<User> users = userDaoOracle.getUsers();
        users.forEach(item -> System.out.println(item));
        System.out.println("-----------------------------");
    }

    /**
     * 测试从mysql数据库中获取数据
     */
    @Test
    public void fun2(){
        System.out.println("-----------------------------");
        System.out.println(userDaoMysql);
        User user = userDaoMysql.getUserById("001");
        System.out.println(user);
        System.out.println("-----------------------------");
        List<User> users = userDaoMysql.getUsers();
        users.forEach(item -> System.out.println(item));
        System.out.println("-----------------------------");
    }
}
