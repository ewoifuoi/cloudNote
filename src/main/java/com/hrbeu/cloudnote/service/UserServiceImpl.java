package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.dao.UserMapper;
import com.hrbeu.cloudnote.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public boolean getPswByuserid(String uid, String last_password){
        String pwd = NoteUtils.getMD5(last_password);
        String pwd_check = userMapper.getUserById(uid);
        boolean b = pwd.equals(pwd_check);
        return b;
    }

    @Override
    public boolean ChangePassword(String uid, String new_password){
        String cn_user_password = NoteUtils.getMD5(new_password);
        System.out.println("id = "+uid+"  密码 = "+cn_user_password);
        userMapper.UpdatePwd(uid, cn_user_password);
        return true;
    }
}
