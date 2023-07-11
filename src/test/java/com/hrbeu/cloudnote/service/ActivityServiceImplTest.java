package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.pojo.Activity;
import com.hrbeu.cloudnote.pojo.Note;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
import java.util.Date;

public class ActivityServiceImplTest {
    @Test
    public void getAllActivities(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        ActivityServiceImpl service = (ActivityServiceImpl) context.getBean("ActivityServiceImpl");
        System.out.println(service.getAllActivities());
    }
    @Test
    public void createActivity(){
        BigInteger num1 = new BigInteger("1234567890");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        ActivityServiceImpl service = (ActivityServiceImpl) context.getBean("ActivityServiceImpl");

        System.out.println(service.createActivity(new Activity("测试标题","测试活动简介",num1)));
    }

    @Test
    public void addNote_Activity(){
        BigInteger num1 = new BigInteger("1234567890");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        ActivityServiceImpl service = (ActivityServiceImpl) context.getBean("ActivityServiceImpl");
        Note note = new Note(NoteUtils.getUUID(), "8b13a2b4-8ee9-4aaf-8041-68fb6d068027", "b39894f3-04c8-43b0-a5ba-b4e4ec144536", "测试笔记", new Date().getTime(),new Date().getTime());
        Activity activity = new Activity("测试标题","测试活动简介",num1);
        service.addNote_Activity(note, activity);
    }

    @Test
    public void testTestGetAllActivities() {
        BigInteger num1 = new BigInteger("1234567890");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        ActivityServiceImpl service = (ActivityServiceImpl) context.getBean("ActivityServiceImpl");


        System.out.println(service.getAllActivities());

    }

    public void testTestCreateActivity() {
    }

    public void testTestAddNote_Activity() {
    }
}
