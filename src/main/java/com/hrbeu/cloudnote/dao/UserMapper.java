package com.hrbeu.cloudnote.dao;

import com.hrbeu.cloudnote.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from cn_user;")
    public List<User> getAllUsers();
}
