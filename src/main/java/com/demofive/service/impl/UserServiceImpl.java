package com.demofive.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demofive.domain.User;
import com.demofive.manager.UserMgr;
import com.demofive.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * Created by Martin on 2019/5/11.
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMgr userMgr;

    @Override
    public List<User> listAllUser() {
        return userMgr.listAllUser();
    }

    @Override
    public Integer saveUser(User user) {
        return userMgr.saveUser(user);
    }

    @Override
    public Integer countUser() {
        return userMgr.countUser();
    }


}
