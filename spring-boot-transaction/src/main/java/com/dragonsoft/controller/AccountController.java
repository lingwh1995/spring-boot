package com.dragonsoft.controller;

import com.dragonsoft.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/3 14:35
 */
@Controller
public class AccountController {

    @Autowired
    private IAccountService accountService;

    /**
     * 注意:此方法通过SpringbootTest进行测试
     * @param sourceUser
     * @param targetUser
     * @param money
     */
    public void transfer(String sourceUser,String targetUser,int money){
        accountService.transfer(sourceUser,targetUser,money);
    }
}
