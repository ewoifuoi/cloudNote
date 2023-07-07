package com.hrbeu.cloudnote.dao;

import com.hrbeu.cloudnote.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from cn_user;")
    public List<User> getAllUsers();

    @Insert("insert into cn_user (cn_user_id, cn_user_name, cn_user_password, cn_user_nick) values (#{cn_user_id}, #{cn_user_name}, #{cn_user_password}, #{cn_user_nick});")
    public Boolean AddUser(User user);
}
