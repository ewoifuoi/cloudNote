package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.pojo.Notebook;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NoteBookServiceImplTest extends TestCase {

    public void testGetAllNotebook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        NoteBookService service =(NoteBookService) context.getBean("NoteBookServiceImpl");
        System.out.println(service.getAllNotebook());
    }

    public void testAddNoteBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        NoteBookService service =(NoteBookService) context.getBean("NoteBookServiceImpl");

        String name = "一个用于测试的笔记本";

        System.out.println(service.addNoteBook(new Notebook(NoteUtils.getUUID(),"b39894f3-04c8-43b0-a5ba-b4e4ec144536", "2",name,"",NoteUtils.getCurrentTime() )));
    }
}