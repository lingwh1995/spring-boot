package com.dragonsoft;

import com.dragonsoft.controller.SpriderController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/11/28 10:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpiderTest {

    @Autowired
    private SpriderController spriderController;

    @Test
    public void fun(){
        spriderController.insert();
    }
}
