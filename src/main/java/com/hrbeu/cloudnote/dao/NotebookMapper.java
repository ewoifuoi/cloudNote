package com.hrbeu.cloudnote.dao;

import com.hrbeu.cloudnote.pojo.Notebook;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NotebookMapper {

    @Select("select * from cn_notebook ;")
    public List<Notebook> getAllNotebook();
}
