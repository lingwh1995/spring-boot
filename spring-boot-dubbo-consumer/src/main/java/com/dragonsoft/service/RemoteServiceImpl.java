package com.dragonsoft.service;


import org.springframework.stereotype.Service;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/5 13:33
 */
@Service
public class RemoteServiceImpl implements IRemoteService {

    @Override
    public String sayHello() {
        return "Hello,Dubbo!I am remote service!";
    }
}
