package com.dragonsoft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ronin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Test
    public void fun() throws SQLException {
        System.out.println("-------------------------------------");
        System.out.println("获取到的数据源对象:"+dataSource.getClass());
        System.out.println("获取到的连接:"+dataSource.getConnection());
        Connection connection = dataSource.getConnection();
        String sql = "SELECT * FROM EMP";
        ResultSet rs = connection.prepareStatement(sql).executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1)+"---"+rs.getString(2));
        }
        System.out.println("-------------------------------------");
    }
}
