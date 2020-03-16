package com.dragonsoft;

import com.dragonsoft.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * Springboot中使用JdbcTemplate
 * @author ronin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootJdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void fun(){
        String sql = "SELECT * FROM T_USER";
        List<Map<String,Object>> users = jdbcTemplate.queryForList(sql);
        System.out.println("----------------------------------------------");
        users.forEach(item -> System.out.println(item));
        System.out.println("----------------------------------------------");
    }
}
