package com.it.springbootdemo.service.service_impl;


import com.it.springbootdemo.mapper.UserMapper;
import com.it.springbootdemo.model.User;
import com.it.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public String test(int id) {


        return userMapper.findUserByName(id);
    }

    @Override
    public User test2(int id) {
        return  userMapper.findUserByName2(id);
    }
}
