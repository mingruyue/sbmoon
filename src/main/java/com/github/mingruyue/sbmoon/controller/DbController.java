package com.github.mingruyue.sbmoon.controller;

import com.github.mingruyue.sbmoon.domain.User;
import com.github.mingruyue.sbmoon.redis.RedisService;
import com.github.mingruyue.sbmoon.result.Result;
import com.github.mingruyue.sbmoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DbController {
    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("get")
    @ResponseBody
    public Result<User> getUser(){
        User user = userService.getById(1);
        return Result.success(user);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<Long> redisGet(){
        Long v1 = redisService.get("key1", Long.class);
        return Result.success(v1);
    }
}
