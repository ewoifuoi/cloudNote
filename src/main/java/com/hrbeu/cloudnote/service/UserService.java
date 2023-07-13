package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.aspect.Log;
import com.hrbeu.cloudnote.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public Boolean Register(User user);


    public User login(String uname, String pwd);

    public boolean getPswByuserid(String uid, String last_password);

    public boolean ChangePassword(String uid, String new_password);
}
