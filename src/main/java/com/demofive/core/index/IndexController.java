package com.demofive.core.index;

import com.demofive.core.service.RedisService;
import com.demofive.domain.User;
import com.demofive.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Martin on 2019/3/23.
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    private String index(){
        logger.info("logMethod:"+Thread.currentThread().getStackTrace()[1].getMethodName()+"-------------start");
        return "index";
    }


}
