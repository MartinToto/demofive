package com.demofive.service;

import com.demofive.domain.User;

import java.util.List;

/**
 * Created by Martin on 2019/3/23.
 */
public interface UserService {
    List<User> listAllUser();

    Integer saveUser(User user);

    Integer countUser();
}
