package com.hrbeu.cloudnote.controller;

import com.hrbeu.cloudnote.Utils.NoteResult;
import com.hrbeu.cloudnote.pojo.Notebook;
import com.hrbeu.cloudnote.service.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteTypeController {

    @Autowired
    NoteBookService service;
    @GetMapping("/getNotebookByuserid.do")
    public NoteResult getAllNotebookByuserid(String uid){

        List<Notebook> list = service.getAllNotebook();
        NoteResult nr = new NoteResult(6,"查询笔记本",list);
        return nr;
    }
}
