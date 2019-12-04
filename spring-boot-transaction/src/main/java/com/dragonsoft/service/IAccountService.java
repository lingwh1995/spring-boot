package com.dragonsoft.service;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/3 14:23
 */
public interface IAccountService {

    /**
     * 转账
     * @param sourceUser 要转出钱的用户
     * @param targetUser 要转入钱的用户
     * @param money 钱的数目
     */
    void transfer(String sourceUser,String targetUser,int money);
}
