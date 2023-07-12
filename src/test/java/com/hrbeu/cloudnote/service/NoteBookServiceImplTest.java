package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.pojo.Note;
import com.hrbeu.cloudnote.pojo.Notebook;
import junit.framework.TestCase;
import lombok.Data;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.rmi.CORBA.Util;
import java.util.Date;
import java.util.List;

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

    public void testGetNote(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        NoteBookService service =(NoteBookService) context.getBean("NoteBookServiceImpl");
        List<Note> list = service.getNoteById("0889368d-76af-49f5-b26f-cc17a00b84ad");
        System.out.println(list);
    }


    public void testSave_note() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        NoteBookService service =(NoteBookService) context.getBean("NoteBookServiceImpl");
        Boolean b = service.save_note("0ca3e5e1-af32-4d0c-8014-fce69f59ff05","离谱啊哦","确实");
        System.out.println(b);
    }

    public void testFavorNote() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        NoteBookService service =(NoteBookService) context.getBean("NoteBookServiceImpl");
        Boolean b = service.favorNote("5ba9813a-bbf9-472e-9d88-9dc79e9e74c2");
        System.out.println(b);
    }

    public void testGetFavorNotes() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        NoteBookService service =(NoteBookService) context.getBean("NoteBookServiceImpl");
        List<Note> list = service.getFavorNotes("058048f8-3f26-464a-a350-bf111d535136");
        System.out.println("测试数据："+list);
    }

    public void testDeleteFavorNote() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        NoteBookService service =(NoteBookService) context.getBean("NoteBookServiceImpl");
        Boolean b = service.deleteFavorNote("5ba9813a-bbf9-472e-9d88-9dc79e9e74c2");
        System.out.println(b);
    }

    public void testGetUserName() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        NoteBookService service =(NoteBookService) context.getBean("NoteBookServiceImpl");
        String b = service.getUserName("");
        System.out.println(b);
    }
}