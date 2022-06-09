package com.dragonsoft.controller;

import com.dragonsoft.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JsonController {


    @GetMapping("/hello")
    public Map<String, String> hello(){
        Person lisi = new Person("lisi", "20");

        Map<String, String> map = new HashMap<String, String>();
        map.put("name","zhangsan");
        map.put("age","18");
        map.put("school","ufe");
        map.put("hobby","soccerball");
        map.put("friend",lisi.toString());
        return map;
    }
}
