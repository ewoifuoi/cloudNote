package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.Utils.NoteUtils;
import com.hrbeu.cloudnote.dao.ActivityMapper;
import com.hrbeu.cloudnote.pojo.Activity;
import com.hrbeu.cloudnote.pojo.Note;
import com.hrbeu.cloudnote.pojo.Note_Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service("ActivityServiceImpl")
public class ActivityServiceImpl {
    @Autowired
    ActivityMapper mapper;

    public List<Activity> getAllActivities(){
        List <Activity> list = mapper.getAllActivities();
        System.out.println("服务层数据："+list);
        return list;
    }

    public Boolean createActivity(Activity activity){
        activity.setCn_activity_id(NoteUtils.getUUID());
        System.out.println("服务层添加的数据："+activity.getCn_activity_id()+" "+activity.getCn_activity_title()+" "+activity.getCn_activity_body()+" "+activity.getCn_activity_end_time());
        return mapper.createActivity(activity);
    }

    public Boolean addNote_Activity(Note note, Activity activity){
        Note_Activity note_activity = null;
        note_activity.setCn_note_activity_id(NoteUtils.getUUID());
        note_activity.setCn_activity_id(activity.getCn_activity_id());
        note_activity.setCn_note_id(note.getCn_note_id());
        note_activity.setCn_note_activity_up(0);
        note_activity.setCn_note_activity_down(0);
        note_activity.setCn_note_activity_title(note.getCn_note_title());
        note_activity.setCn_note_activity_body(note.getCn_note_body());
        System.out.println(note_activity);
        return mapper.addNote_Activity(note_activity);
    }
}
