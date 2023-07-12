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

    Boolean save_note(String note_id, String note_title, String note_body);

    Boolean deleteNote(String id);

    Boolean recycleNote(String id);

    List<Note> getRecycledNotes(String id);

    Boolean deleteNotebook(String id);

    Boolean favorNote(String id);

    List<Note> getFavorNotes(String id);

    Boolean deleteFavorNote(String id);

    Boolean moveNote(String noteid, String target);

    Boolean clearDustbin(String uid);

    String getUserName(String uid);
}
