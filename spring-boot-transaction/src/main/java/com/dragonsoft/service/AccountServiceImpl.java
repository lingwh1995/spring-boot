package com.dragonsoft.service;

import com.dragonsoft.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试SpringBoot注解类型的事务
 * @author ronin
 * @version V1.0
 * @since 2019/12/3 14:24
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class AccountServiceImpl implements IAccountService{

    @Autowired
    private AccountDao accountDao;

    /**
     * 转账功能
     * @param sourceUser 要转出钱的用户
     * @param targetUser 要转入钱的用户
     * @param money 钱的数目
     */
    @Override
    public void transfer(String sourceUser,String targetUser,int money) {
        accountDao.transferOut(sourceUser,money);
        accountDao.transferIn(targetUser,money);
    }
}
