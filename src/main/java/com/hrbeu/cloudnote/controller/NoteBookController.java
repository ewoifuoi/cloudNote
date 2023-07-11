package com.hrbeu.cloudnote.controller;

import com.hrbeu.cloudnote.Utils.NoteResult;
import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.pojo.Note;
import com.hrbeu.cloudnote.pojo.Notebook;
import com.hrbeu.cloudnote.service.NoteBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class NoteBookController {
    @Autowired
    NoteBookServiceImpl service;

    @GetMapping ("/getNotebookByuserid")
    public NoteResult getAllNotebookByuserid(String uid){

        List<Notebook> list = service.getUserNotebook(uid);
        NoteResult nr = new NoteResult(6,"查询笔记本",list);
        return nr;
    }

    @RequestMapping("/addNoteBook")
    public NoteResult addNotebook(String uid,String bookname){
        String bookid = NoteUtils.getUUID();
        Notebook nb = new Notebook();
        nb.setCn_notebook_id(bookid);
        nb.setCn_notebook_name(bookname);
        nb.setCn_user_id(uid);
        nb.setCn_notebook_type_id("3");

        nb.setCn_notebook_createtime(NoteUtils.getCurrentTime());   //创建时间
        boolean b = service.addNoteBook(nb);
        NoteResult nr = new NoteResult(7,"创建笔记本成功,create Notebook success",null);
        return nr;
    }

    @GetMapping("/getNoteList/{bookid}")
    public NoteResult getNotelist(@PathVariable String bookid){
        List<Note> ln = service.getAllNoteBynotebook(bookid);
        System.out.println(ln);
        NoteResult result = new NoteResult(10,"查询笔记",ln);
        return result;
    }

    @PostMapping("/addNote")
    public NoteResult addNote(String notebookid, String noteName, String userid){
        String noteid = NoteUtils.getUUID();
        Note note = new Note();
        note.setCn_note_id(noteid);
        note.setCn_notebook_id(notebookid);
        note.setCn_user_id(userid);
        note.setCn_note_title(noteName);
        Date d = new Date();
        note.setCn_note_create_time(d.getTime());
        note.setCn_note_last_modify_time(d.getTime());
        boolean b = service.addNote(note);
        System.out.println(note);
        NoteResult nr = new NoteResult(9,"添加笔记成功",null);
        return nr;
    }
}
