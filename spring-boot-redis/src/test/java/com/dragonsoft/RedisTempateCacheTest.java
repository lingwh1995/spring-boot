package com.dragonsoft;

import com.dragonsoft.controller.UserController;
import com.dragonsoft.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ronin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTempateCacheTest {

    @Autowired
    private UserController userControlelr;

    @Test
    public void fun(){
        System.out.println("----------------------------------");
        User user1 = userControlelr.getUserById("001");
        System.out.println(user1);
        System.out.println("----------------------------------");
        User user2 = userControlelr.getUserById("001");
        System.out.println(user2);
        System.out.println("----------------------------------");
    }

    /**
     * SpringBoot缓存原理:
     *      CacheManager创建缓存组件(如Redis缓存组件),由缓存组件来对缓存执行实际的CRUD操作
     *      加入Redis启动器后,容器中保存的是RedisManager
     *      RedisManager帮我们创建RedisCache作为缓存组件,RedisCache通过操作Redis来缓存数据
     */
}
