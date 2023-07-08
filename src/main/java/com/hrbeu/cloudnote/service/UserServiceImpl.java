package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.dao.UserMapper;
import com.hrbeu.cloudnote.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Util;
import java.util.List;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public Boolean Register(User user) {
        user.setCn_user_id(NoteUtils.getUUID());
        user.setCn_user_password(NoteUtils.getMD5(user.getCn_user_password()));
        return userMapper.AddUser(user);
    }

    @Override
    public User login(String name, String pwd) {
        User u = null;

        String loginpwd = NoteUtils.getMD5(pwd);
        List<User> list = userMapper.getUserByname(name);

        System.out.println("根据姓名查询结果数里 = "+list.size());
        for (User users : list) {
            System.out.println(users);
            boolean b = users.getCn_user_password().equals(loginpwd);
            if(b)
                u = users;
        }

        return u;
    }
}
