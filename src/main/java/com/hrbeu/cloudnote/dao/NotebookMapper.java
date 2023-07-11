package com.hrbeu.cloudnote.dao;

import com.hrbeu.cloudnote.pojo.Note;
import com.hrbeu.cloudnote.pojo.Notebook;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NotebookMapper {

    @Select("select * from cn_notebook ;")
    public List<Notebook> getAllNotebook();

    @Select("select * from cn_notebook where cn_user_id=#{id};")
    public List<Notebook> getUserNoteBook(String id);

    @Insert("insert into cn_notebook(cn_notebook_id,cn_user_id,cn_notebook_type_id,\n" +
            "                                cn_notebook_name,cn_notebook_desc,cn_notebook_createtime)\n" +
            "          values(#{cn_notebook_id},#{cn_user_id},#{cn_notebook_type_id},\n" +
            "                 #{cn_notebook_name},#{cn_notebook_desc},#{cn_notebook_createtime});")
    public Boolean addNoteBook(Notebook notebook);


    @Select("select * from cn_note where cn_notebook_id=#{bookid};")
    List<Note> getAllNoteBynotebook(String bookid);

    @Insert("insert into cn_note(\n" +
            "            cn_note_id,cn_notebook_id,cn_user_id,\n" +
            "                     cn_note_title,cn_note_create_time,cn_note_last_modify_time\n" +
            "        ) values (\n" +
            "            #{cn_note_id},#{cn_notebook_id},#{cn_user_id}\n" +
            "        ,#{cn_note_title},#{cn_note_create_time},#{cn_note_last_modify_time}\n" +
            "                         )")
    Boolean addNote(Note note);

    @Delete("delete from cn_note where cn_note_id=#{id};")
    Boolean deleteNote(String id);

    @Select("select * from cn_note where cn_note_id=#{noteid};")
    List<Note> getNoteById(String noteid);

    @Update("update cn_note set cn_note_title=#{note_title},cn_note_body=#{note_body} where cn_note_id=#{note_id};")
    Boolean saveNote(@Param("note_id") String note_id, @Param("note_title") String note_title, @Param("note_body") String note_body);
}
