package com.dragonsoft.service;

import com.dragonsoft.domain.User;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/5 13:32
 */
public interface IRemoteService {

    /**
     * 测试dubbo
     * @return
     */
    String sayHello();

    /**
     * 获取User对象
     * @return
     */
    User getUser();
}
