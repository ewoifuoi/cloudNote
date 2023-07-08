package com.hrbeu.cloudnote.dao;

import com.hrbeu.cloudnote.pojo.Notebook;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
}
