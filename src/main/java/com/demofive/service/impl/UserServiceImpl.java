package com.demofive.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.demofive.manager.UserMgr;
import org.springframework.beans.factory.annotation.Autowired;
import user.domain.User;
import user.service.UserService;


import java.util.List;

/**
 * Created by Martin on 2019/5/11.
 */
@Service(version = "1.0.1")
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
