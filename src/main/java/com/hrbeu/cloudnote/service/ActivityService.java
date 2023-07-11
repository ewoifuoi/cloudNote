package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.pojo.Activity;

import java.math.BigInteger;
import java.util.List;

public interface ActivityService {
    List<Activity> getAllActivities();

    public Boolean createActivity(Activity activity);

    public Boolean addNote_Activity();
}
