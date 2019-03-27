package com.demofive.controller;

import com.demofive.domain.User;
import com.demofive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Martin on 2019/3/23.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    @ResponseBody
    private List<User> listUser(){
        List<User> userList = userService.listAllUser();
        Jedis jedis = new Jedis();
        jedis.set("allUser", String.valueOf(userList));
        return userList;
    }

    @RequestMapping(value = "/listUserRedis",method = RequestMethod.GET)
    @ResponseBody
    private String listUserRedis(){
        Jedis jedis = new Jedis();
        if(jedis.exists("allUser")){
            return jedis.get("allUser");
        }
        return null;
    }

    @RequestMapping(value = "/saveUser", method=RequestMethod.POST)
    @ResponseBody
    private Integer saveUser(@RequestBody User user){
        Integer saveNum = userService.saveUser(user);
        return saveNum;
    }
}
