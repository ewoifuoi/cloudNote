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

    @Override
    public Boolean deleteNote(String id) {
        return mapper.deleteNote(id);
    }

    @Override
    public Boolean recycleNote(String id) {
        return mapper.recycleNote(id);
    }

    @Override
    public List<Note> getRecycledNotes(String id) {
        return mapper.getRecycledNotes(id);
    }

    @Override
    public Boolean deleteNotebook(String id) {

        List<Note> notes = mapper.getNoteById(id);
        for(Note note :notes) {
            System.out.println(note.getCn_note_title());
            mapper.deleteNote(note.getCn_note_id());
        }
        mapper.deleteNotebook(id);

        return true;
    }


}
