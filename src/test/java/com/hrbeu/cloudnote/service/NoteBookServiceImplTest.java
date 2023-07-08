package com.hrbeu.cloudnote.service;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NoteBookServiceImplTest extends TestCase {

    public void testGetAllNotebook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        NoteBookService service =(NoteBookService) context.getBean("NoteBookServiceImpl");
        System.out.println(service.getAllNotebook());
    }
}