package com.dragonsoft.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.dragonsoft.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/5 13:33
 */
@Component
@Service
public class RemoteServiceImpl implements IRemoteService {

    @Override
    public String sayHello() {
        return "Hello,Dubbo!I am remote service!";
    }

    @Override
    public User getUser() {
        return new User("001","张三","123456");
    }
}
