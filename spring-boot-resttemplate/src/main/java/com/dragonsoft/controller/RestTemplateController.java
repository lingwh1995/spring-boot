package com.dragonsoft.controller;

import com.dragonsoft.domain.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 为RestTemplate调用提供数据
 * @author ronin
 * @version V1.0
 * @since 2019/11/15 13:53
 */
@Controller
public class RestTemplateController {

    /**
     * GET方式的请求:需要传递参数
     * @param name
     * @return
     */
    @ResponseBody
    @GetMapping("get")
    public User testget(@RequestParam("name") String name){
        User user = null;
        if("zs".equals(name)){
            user = new User("zhangsan","18");
        }else if("ls".equals(name)){
            user = new User("李四","18");
        }
        return user;
    }

    /**
     * GET方式的请求:不需要传递参数
     * @return
     */
    @ResponseBody
    @GetMapping(value="/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUsers(@PathVariable("id") Integer id){
        if(id == 1){
            return new User("zs","18");
        }
        return null;
    }

    /**
     * POST方式的请求
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("post")
    public User testPost(User user){
        System.out.println("要新增的user的是:"+user);
        return user;
    }


    /**
     * PUT方式的请求
     * @param user
     * @return
     */
    @ResponseBody
    @PutMapping("put")
    public User testPut(User user){
        System.out.println("要更新的user的是:"+user);
        return user;
    }

    /**
     * DELETE方式的请求
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping("delete/{id}")
    public User testDelete(@PathVariable("id") String id){
        System.out.println("要删除的user的ID是:"+id);
        return null;
    }
}
