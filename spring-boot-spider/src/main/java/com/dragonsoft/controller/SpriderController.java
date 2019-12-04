package com.dragonsoft.controller;

import com.dragonsoft.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/11/14 16:53
 */
@RestController
@RequestMapping("JD")
public class SpriderController {

    @Autowired
    private SpiderService spiderService;

    @RequestMapping("gather")
    public void insert() {
        spiderService.gather("手机",1,3,50);
    }

}
