package com.dragonsoft.test;

import com.dragonsoft.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

/**
 * @author ronin
 * @version V1.0
 * @since 2020/3/5 13:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SnakeyamlTest {

    /**
     * 使用snakeyaml解析yml文件,并将解析结果封装到实体中
     */
    @Test
    public void fun1() {
        Yaml yaml = new Yaml();
        Person person = yaml.loadAs(SnakeyamlTest.class.getResourceAsStream("/person.yml"), Person.class);
        System.out.println(person);
    }

    /**
     * 使用snakeyaml解析yml文件,并将解析结果封装到Map中
     */
    @Test
    public void fun2() {
        Yaml yaml = new Yaml();
        Map personMap = yaml.loadAs(SnakeyamlTest.class.getResourceAsStream("/person.yml"), Map.class);
        System.out.println(personMap);
    }
}
