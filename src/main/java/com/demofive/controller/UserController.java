package com.demofive.controller;

import com.demofive.core.service.RedisService;
import com.demofive.domain.User;
import com.demofive.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * Created by Martin on 2019/3/23.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    @ResponseBody
    private List<User> listUser(){
        List<User> userList = userService.listAllUser();

//        stringRedisTemplate.opsForSet().members("hello");
        return userList;
    }

    @RequestMapping(value = "/testRedis",method = RequestMethod.GET)
    @ResponseBody
    private String testRedis(){
        logger.info("logMethod:"+Thread.currentThread().getStackTrace()[1].getMethodName()+"----------------------start");
        StringBuffer sb = new StringBuffer();
        redisService.set("str", "str");
        sb.append("str=").append(redisService.get("str").toString()).append(",");
        redisService.hmSet("hmset","key","val");
        sb.append("hmset=").append(redisService.hmGet("hmset","key")).append(",");
        redisService.lPush("list","val");
        sb.append("list=").append(redisService.lRange("list",0,1).toString()).append(",");
        redisService.add("set","val");
        sb.append("set=").append(redisService.setMembers("set").toString()).append(",");
        redisService.zAdd("zset","val1",1);
        redisService.zAdd("zset","val2",2);
        sb.append("zset=").append(redisService.rangeByScore("zset",1,2)).append(",");
        logger.info("logMethod:"+Thread.currentThread().getStackTrace()[1].getMethodName()+"----------------------end");
        return sb.toString();
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


    @RequestMapping(value = "/countUser", method=RequestMethod.POST)
    @ResponseBody
    private Integer countUser(@RequestBody User user){
        Integer countNum = userService.countUser();
        return countNum;
    }
}
