package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.pojo.Note;
import com.hrbeu.cloudnote.pojo.Notebook;

import java.util.List;

public interface NoteBookService {
    List<Notebook> getAllNotebook();
    List<Notebook> getUserNotebook(String uid);

    Boolean addNoteBook(Notebook notebook);

    List<Note> getAllNoteBynotebook(String bookid);

    Boolean addNote(Note note);

    List<Note> getNoteById(String noteid);
}
