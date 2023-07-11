package com.hrbeu.cloudnote.controller;

import com.hrbeu.cloudnote.pojo.Activity;
import com.hrbeu.cloudnote.pojo.Notebook;
import com.hrbeu.cloudnote.service.ActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ActivityController {
    @Autowired
    ActivityServiceImpl service;

    @PostMapping("/getAllActivities")
    public List<Activity> getAllActivities(){
        List<Activity> list = service.getAllActivities();
        System.out.println("控制层数据："+list);
        return list;
    }

    @PostMapping("/createActivity")
    public Boolean createActivity(String title, String body, BigInteger end_time){
        Activity activity = new Activity(title,body,end_time);
        boolean b = service.createActivity(activity);
        //检测
        String ti = end_time.toString();
        System.out.println("控制层添加的数据:"+title+" "+body+" "+ti);
        return b;
    }

}
