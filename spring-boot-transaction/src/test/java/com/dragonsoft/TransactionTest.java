package com.dragonsoft;

import com.dragonsoft.controller.AccountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/3 14:37
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionTest {

    @Autowired
    private AccountController accountController;

    @Test
    public void fun(){
        accountController.transfer("zhangsan","lisi",10);
    }
}
