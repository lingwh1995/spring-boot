package com.dragonsoft;
import	java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author ronin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 测试JdbcTemplate
     */
    @Test
    public void fun(){
        System.out.println("--------------------------------");
        String sql = "SELECT * FROM EMP";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(item-> System.out.println(item));
        System.out.println("--------------------------------");
    }
}
