package com.hrbeu.cloudnote.controller;

import com.hrbeu.cloudnote.Utils.NoteResult;
import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.pojo.Note;
import com.hrbeu.cloudnote.pojo.Notebook;
import com.hrbeu.cloudnote.service.NoteBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        NoteResult result = new NoteResult(6,"查询笔记本",list);
        return result;
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
        NoteResult result = new NoteResult(7,"创建笔记本成功,create Notebook success",null);
        return result;
    }

    @GetMapping("/getNoteList/{bookid}")
    public NoteResult getNotelist(@PathVariable String bookid){
        List<Note> ln = service.getAllNoteBynotebook(bookid);
        System.out.println(ln);
        NoteResult result = new NoteResult(10,"查询笔记",ln);
        return result;
    }

    @GetMapping("/getNote/{noteid}")
    public NoteResult getNote(@PathVariable String noteid){
        System.out.println(noteid);
        List<Note> list = service.getNoteById(noteid);
        NoteResult result = new NoteResult(10,"查询笔记",list);
        System.out.println(result);
        return result;
    }

    @GetMapping("/save_note")
    public Boolean save_note(String noteId,String note_title,String note_body){
         return service.save_note(noteId, note_title, note_body);
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
        NoteResult result = new NoteResult(9,"添加笔记成功",null);
        return result;
    }

    @PostMapping("/favorNote")
    public NoteResult favorNote(String id){
        service.favorNote(id);
        NoteResult result = new NoteResult();
        return result;
    }

    @PostMapping("/getFavorNotes")
    public NoteResult getFavorNotes(String uid){
        System.out.println("控制层id："+uid);
        List<Note> list = service.getFavorNotes(uid);
        NoteResult result = new NoteResult(9,"",list);
        return  result;
    }

    @PostMapping("/deletefavorNote")
    public  NoteResult deleteFavorNote(String id){
        service.deleteFavorNote(id);
        NoteResult result = new NoteResult();
        return  result;
    }

    @PostMapping("/deleteNote")
    public NoteResult deleteNote(String id) {
        service.deleteNote(id);
        NoteResult result = new NoteResult();
        return result;
    }

    @PostMapping("/recycleNote")
    public NoteResult recycleNote(String id) {
        service.recycleNote(id);
        NoteResult result = new NoteResult();
        return result;
    }

    @PostMapping("/getRecycledNotes")
    public NoteResult getRecycledNotes(String uid) {
        List<Note> list = service.getRecycledNotes(uid);
        NoteResult result = new NoteResult(9,"", list);
        return result;
    }

    @PostMapping("/deleteNotebook")
    public NoteResult deleteNotebook(String id){
        service.deleteNotebook(id);
        NoteResult result = new NoteResult();
        return result;
    }


    @PostMapping("/moveNote")
    public NoteResult moveNote(String noteid , String target) {

        service.moveNote(noteid,target);
        NoteResult result = new NoteResult();
        return result;
    }

    @PostMapping("/clearDustbin")
    public NoteResult clearDustbin(String uid) {

        System.out.println("controller:"+uid);
        service.clearDustbin(uid);

        NoteResult result = new NoteResult();
        return result;
    }

    @PostMapping("/getUserName")
    public String getUserName(String uid){
        return service.getUserName(uid);
    }
}
