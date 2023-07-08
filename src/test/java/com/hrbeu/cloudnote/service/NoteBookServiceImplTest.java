package com.hrbeu.cloudnote.service;

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

        System.out.println(service.addNoteBook(new Notebook("52f9b276-38ee-447f-a3aa-0d54e7a736e5","b39894f3-04c8-43b0-a5ba-b4e4ec144536", "2","test","","2014-06-27 15:18:59" )));
    }
}