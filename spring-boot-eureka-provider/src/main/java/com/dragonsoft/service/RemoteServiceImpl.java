package com.dragonsoft.service;

import org.springframework.stereotype.Service;

/**
 * @author ronin
 */
@Service
public class RemoteServiceImpl implements IRemoteService{

    @Override
    public String sayHello() {
        return "Hello,Eureka!";
    }
}
