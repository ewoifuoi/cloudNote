package com.hrbeu.cloudnote.dao;

import com.hrbeu.cloudnote.pojo.Activity;
import com.hrbeu.cloudnote.pojo.Note_Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ActivityMapper {
    @Select("Select * from cn_activity;")
    public List<Activity> getAllActivities();

    @Insert("insert into cn_activity (cn_activity_id, cn_activity_title, cn_activity_body, cn_activity_end_time) values (#{cn_activity_id}, #{cn_activity_title}, #{cn_activity_body}, #{cn_activity_end_time}); ")
    public Boolean createActivity(Activity activity);

    @Insert("Insert into cn_note_activity(cn_note_activity_id,cn_activity_id,cn_note_id,cn_note_activity_up,\n"+
            "cn_note_activity_down,cn_note_activity_title,cn_note_activity_body)\n"+
            "values+\n"+
            "(#{cn_note_activity_id},#{cn_activity_id},#{cn_note_id},#{cn_note_activity_up},#{cn_note_activity_down},\n"+
            "#{cn_note_activity_title},#{cn_note_activity_body});")
    public Boolean addNote_Activity(Note_Activity note_activity);
}
