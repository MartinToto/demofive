package com.demofive.dao;

import com.demofive.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Martin on 2019/3/23.
 */
@Mapper
public interface UserDao {
    List<User> listAllUser();

    Integer saveUser(User user);

    Integer countUser();
}
