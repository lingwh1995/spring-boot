package com.dragonsoft.service;

import com.dragonsoft.domain.User;

/**
 * @author ronin
 */
public interface RaabitService {
    /**
     * 监听消息队列中消息的变化
     */
    void listen(User user);
}
