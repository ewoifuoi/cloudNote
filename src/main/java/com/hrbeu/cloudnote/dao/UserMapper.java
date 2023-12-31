package com.hrbeu.cloudnote.dao;

import com.hrbeu.cloudnote.pojo.Notebook;
import com.hrbeu.cloudnote.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from cn_user;")
    public List<User> getAllUsers();

    @Insert("insert into cn_user (cn_user_id, cn_user_name, cn_user_password, cn_user_nick) values (#{cn_user_id}, #{cn_user_name}, #{cn_user_password}, #{cn_user_nick});")
    public Boolean AddUser(User user);

    @Select("select * from cn_user where cn_user_name=#{name};")
    public List<User> getUserByname(String name);

    @Select("Select cn_user_password from cn_user where cn_user_id=#{uid};")
    public String getUserById(String uid);

    @Update("update cn_user set cn_user_password=#{pwd} where cn_user_id=#{uid};")
    public Boolean UpdatePwd(@Param("uid") String uid,@Param("pwd") String pwd);


}
