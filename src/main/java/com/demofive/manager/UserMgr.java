package com.demofive.manager;



import user.domain.User;

import java.util.List;

/**
 * Created by Martin on 2019/5/12.
 */
public interface UserMgr {
    List<User> listAllUser();
    Integer saveUser(User user);
    Integer countUser();
}
