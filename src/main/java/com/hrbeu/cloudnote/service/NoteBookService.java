package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.pojo.Notebook;

import java.util.List;

public interface NoteBookService {
    List<Notebook> getAllNotebook();
    List<Notebook> getUserNotebook(String uid);

    Boolean addNoteBook(Notebook notebook);
}
