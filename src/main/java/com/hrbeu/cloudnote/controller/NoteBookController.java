package com.hrbeu.cloudnote.controller;

import com.hrbeu.cloudnote.Utils.NoteResult;
import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.pojo.Notebook;
import com.hrbeu.cloudnote.service.NoteBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        Date d = new Date();
        System.out.println(d.getTime() +" ==== 当前毫秒数");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 生成一个格式化对象
        String date = sdf.format(d); //格式化时间
        nb.setCn_notebook_createtime(date);   //创建时间
        boolean b = service.addNoteBook(nb);
        NoteResult nr = new NoteResult(7,"创建笔记本成功,create Notebook success",null);
        return nr;
    }
}
