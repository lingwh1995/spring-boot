package com.dragonsoft.test;

import com.dragonsoft.entity.Person;
import org.ho.yaml.Yaml;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ronin
 * @version V1.0
 * @since 2020/3/5 13:58
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JyamlTest {

    /**
     * 使用Jyaml将yml文件解析成实体
     */
    @Test
    public void fun1(){
        Person person = null;
        try {
            person = Yaml.loadType(JyamlTest.class.getResourceAsStream("/person.yml"), Person.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(person);
    }

    /**
     * 使用Jyaml将yml文件解析成Map
     *  注意:如果想要使用Map接收解析结果,则Yaml.loadType()的第二个参数一定要为Map的实现类
     */
    @Test
    public void fun2(){
        Map personMap = null;
        try {
                personMap = Yaml.loadType(JyamlTest.class.getResourceAsStream("/person.yml"), HashMap.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(personMap);
    }
}
