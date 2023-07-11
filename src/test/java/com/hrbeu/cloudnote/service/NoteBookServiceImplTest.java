package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.pojo.Note;
import com.hrbeu.cloudnote.pojo.Notebook;
import junit.framework.TestCase;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.rmi.CORBA.Util;
import java.util.Date;

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

    public void testTestGetAllNotebook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        NoteBookService service =(NoteBookService) context.getBean("NoteBookServiceImpl");
        System.out.println(service.getAllNoteBynotebook("516f6f4f-eaa3-4c76-84ff-530b92c7f64d"));
    }

    public void testAddNote() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        NoteBookService service =(NoteBookService) context.getBean("NoteBookServiceImpl");
        Note note = new Note(NoteUtils.getUUID(), "8b13a2b4-8ee9-4aaf-8041-68fb6d068027", "b39894f3-04c8-43b0-a5ba-b4e4ec144536", "测试笔记", new Date().getTime(),new Date().getTime());
        System.out.println(service.addNote(note));
    }

    public void testTestAddNote() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        NoteBookService service =(NoteBookService) context.getBean("NoteBookServiceImpl");

        Note note = new Note(NoteUtils.getUUID(), "8b13a2b4-8ee9-4aaf-8041-68fb6d068027", "b39894f3-04c8-43b0-a5ba-b4e4ec144536", "测试笔记", new Date().getTime(),new Date().getTime());
        System.out.println(service.addNote(note));
    }
}