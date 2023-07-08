package com.hrbeu.cloudnote.controller;

import com.hrbeu.cloudnote.Utils.NoteResult;
import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.pojo.User;
import com.hrbeu.cloudnote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@RestController

public class UserController {

    @Autowired
    private UserService service;
    @PostMapping("/register")
    public NoteResult Register(String regist_username, String nickname, String regist_password) throws NoSuchAlgorithmException {

        User user = new User(regist_username,regist_password,nickname);
        System.out.println(user);
        if(service.Register(user)) {
            return NoteResult.registerSuccess();
        }
        else {
            return NoteResult.registerFail();
        }

    }

    @GetMapping("/register")
    public String Register(Model model) {
        return "这是一条测试";
    }

    @PostMapping("/login")
    public NoteResult login(String regist_username, String regist_password, HttpSession session){

        System.out.println(regist_username + " " + regist_password);
        User u = service.login(regist_username,regist_password);
        if(u==null){
            return NoteResult.loginFail();
        }else{
            session.setAttribute("user",u);
            return NoteResult.loginSuccess();
        }
    }
}
