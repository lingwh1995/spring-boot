package com.dragonsoft.service;

import com.dragonsoft.domain.User;

/**
 * @author ronin
 */
public interface FanoutService {
    void monitor1(User user);
    void monitor2(User user);
    void monitor3(User user);
}
