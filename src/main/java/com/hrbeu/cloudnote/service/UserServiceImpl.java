package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.dao.UserMapper;
import com.hrbeu.cloudnote.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
