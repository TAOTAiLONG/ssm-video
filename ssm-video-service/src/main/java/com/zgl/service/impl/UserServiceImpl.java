package com.zgl.service.impl;

import com.zgl.dao.UserMapper;
import com.zgl.pojo.User;
import com.zgl.pojo.UserExample;
import com.zgl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> login(User user) {

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(user.getEmail());
        criteria.andPasswordEqualTo(user.getPassword());
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> findUserByEmail(String email) {

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        return userMapper.selectByExample(example);
    }

    @Override
    public Integer updateUser(User user) {

        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer insertUser(User user) {

        return userMapper.insertSelective(user);
    }
}
