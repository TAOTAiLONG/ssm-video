package com.zgl.service;

import com.zgl.pojo.User;

import java.util.List;

public interface UserService {

    List<User> login(User user);

    List<User> findUserByEmail(String email);

    int updateUser(User user);
}
