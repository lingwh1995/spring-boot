package com.dragonsoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/3 14:30
 */
@Repository
public class AccountDao {

   @Autowired
   private JdbcTemplate jdbcTemplate;

    /**
     * 转入
     * @param user 要转入钱的用户
     * @param money 要转入的钱的数目
     */
    public void transferIn(String user,int money) {
        String transferInSql = "UPDATE T_ACCOUNT SET MONEY = MONEY-?  WHERE USERNAME = ?";
        jdbcTemplate.update(transferInSql,new Object[]{money,user});
    }

    /**
     * 转出
     * @param user 要转出钱的用户
     * @param money 要转出的钱的数目
     */
    public void transferOut(String user,int money){
        String transferInSql = "UPDATE T_ACCOUNT SET MONEY = MONEY+?  WHERE USERNAME = ?";
        jdbcTemplate.update(transferInSql,new Object[]{money,user});
        //模拟发生异常
        System.out.println(1/0);
    }
}
