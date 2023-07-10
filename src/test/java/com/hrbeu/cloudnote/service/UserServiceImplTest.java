package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImplTest {


    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserServiceImpl) context.getBean("UserServiceImpl");
        System.out.println(service.getAllUsers());
    }

    @Test
    public void RegisterTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl service = (UserServiceImpl) context.getBean("UserServiceImpl");
        service.Register(new User("test","jfklew","这是一个测试"));
    }

    @Test
    public void UpDatePwd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl service = (UserServiceImpl) context.getBean("UserServiceImpl");
        service.ChangePassword("f74f5c6e-70a7-45ac-b80a-88d16fe4e155","knight");
    }
}
