package com.hrbeu.cloudnote.controller;

import com.hrbeu.cloudnote.Utils.NoteResult;
import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.aspect.Log;
import com.hrbeu.cloudnote.pojo.Notebook;
import com.hrbeu.cloudnote.pojo.User;
import com.hrbeu.cloudnote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.List;

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

    @Log(value = "用户登录")
    @PostMapping("/login")
    public NoteResult login(String regist_username, String regist_password, HttpSession session){
        User u = service.login(regist_username,regist_password);
        NoteResult noteResult = new NoteResult(3,"登录成功", u);
        if(u==null){
            return NoteResult.loginFail();
        }else{
            session.setAttribute("user",u);
            return noteResult;
        }
    }

    @PostMapping("/getPswByuserid")
    public boolean getPswByuserid(String uid, String last_password) throws NoSuchAlgorithmException {
        return service.getPswByuserid(uid, last_password);
    }

    @PostMapping("/changePwd")
    public boolean changePwd(String uid, String new_password){
        return service.ChangePassword(uid, new_password);
    }
}
