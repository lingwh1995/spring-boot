package com.dragonsoft.service;

import com.dragonsoft.domain.User;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/5 13:32
 */
@Service
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
