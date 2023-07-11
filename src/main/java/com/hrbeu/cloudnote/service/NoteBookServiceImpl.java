package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.dao.NotebookMapper;
import com.hrbeu.cloudnote.pojo.Note;
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

    @Override
    public List<Notebook> getUserNotebook(String uid) {
        return mapper.getUserNoteBook(uid);
    }

    @Override
    public Boolean addNoteBook(Notebook notebook) {
        return mapper.addNoteBook(notebook);
    }

    @Override
    public List<Note> getAllNoteBynotebook(String bookid) {
        return mapper.getAllNoteBynotebook(bookid);
    }

    @Override
    public Boolean addNote(Note note) {
        return mapper.addNote(note);
    }

    @Override
    public  List<Note> getNoteById(String noteid){return mapper.getNoteById(noteid);}

    @Override
    public Boolean save_note(String note_id, String note_title, String note_body){
        System.out.println("服务层的数据："+note_id+" "+note_title+" "+note_body);
        return mapper.saveNote(note_id,note_title,note_body);
    }

}
