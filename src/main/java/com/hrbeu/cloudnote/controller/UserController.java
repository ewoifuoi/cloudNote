package com.hrbeu.cloudnote.controller;

import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.pojo.User;
import com.hrbeu.cloudnote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping("/register")
    public String Register(String regist_username, String nickname, String regist_password) throws NoSuchAlgorithmException {
        User user = new User(regist_username,regist_password,nickname);
        return "";
    }
}
