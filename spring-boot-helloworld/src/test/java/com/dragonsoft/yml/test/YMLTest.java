package com.dragonsoft.yml.test;


import com.dragonsoft.Application;
import com.dragonsoft.yml.domian.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ronin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class YMLTest {

    @Qualifier("personYml")
    @Autowired
    private Person person;

    @Test
    public void fun(){
        System.out.println(person);
    }
}
