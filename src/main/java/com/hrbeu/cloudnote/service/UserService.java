package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    Boolean Register(User user);
}
