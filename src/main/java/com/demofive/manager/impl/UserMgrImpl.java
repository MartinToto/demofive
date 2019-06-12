package com.demofive.manager.impl;


import com.demofive.dao.UserDao;

import com.demofive.manager.UserMgr;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import user.domain.User;


import java.util.List;

/**
 * Created by Martin on 2019/3/23.
 */
@Transactional
@Service("userMgr")
public class UserMgrImpl implements UserMgr {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listAllUser() {
        return userDao.listAllUser();
    }

    @Transactional
    @Override
    public Integer saveUser(User user) {
        int[] arr = new int[]{1,2,3};
        Integer saveNum = 0;
        String[] strs = new String[]{};
            saveNum = userDao.saveUser(user);
            System.out.println("saveNum============="+saveNum);
            Integer countNum = userDao.countUser();
            System.out.println("countNum============="+countNum);
//            throw new RuntimeException();
//        int s = 1/0;
        System.out.println("countNum============="+countNum);
//        throw new MyException("222222");
        return saveNum;
    }

    @Override
    public Integer countUser() {
        return userDao.countUser();
    }
}
