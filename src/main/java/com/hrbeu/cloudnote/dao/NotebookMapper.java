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


    @Select("select * from cn_note where cn_notebook_id=#{bookid} and cn_note_status_id is null;")
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

    @Update("update cn_note set cn_note_status_id = 'recycled' where cn_note_id=#{id};")
    Boolean recycleNote(String id);

    @Select("select * from cn_note where cn_user_id=#{id} and cn_note_status_id='recycled' ;")
    List<Note> getRecycledNotes(String id);

    @Delete("delete from cn_notebook where cn_notebook_id=#{id};")
    Boolean deleteNotebook(String id);

    @Update("update cn_note set cn_notebook_id =#{target} ,cn_note_status_id=null where cn_note_id=#{noteid};")
    Boolean moveNote(@Param("noteid") String noteid, @Param("target") String target);

    @Update("update cn_note set cn_note_type_id = 'favor' where cn_note_id=#{id};")
    Boolean favorNote(String id);

    @Select("select * from cn_note where cn_user_id=#{id} and cn_note_type_id='favor';")
    List<Note> getFavorNotes(String id);

    @Update("update cn_note set cn_note_type_id = null where cn_note_id=#{id};")
    Boolean deleteFavorNote(String id);

    @Select("select cn_user_nick from cn_user where cn_user_id=#{uid};")
    public String getUserName(String uid);

    @Update("Update cn_notebook set cn_notebook_name=#{new_name} where cn_notebook_id=#{bookid};")
    Boolean renameNoteBook(@Param("new_name") String new_name,@Param("bookid") String bookid);
}
