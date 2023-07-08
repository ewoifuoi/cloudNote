package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.dao.NotebookMapper;
import com.hrbeu.cloudnote.pojo.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NoteBookServiceImpl")
public class NoteBookServiceImpl implements NoteBookService {
    @Autowired
    NotebookMapper mapper;

    @Override
    public List<Notebook> getAllNotebook(){
        return mapper.getAllNotebook();
    }

}
