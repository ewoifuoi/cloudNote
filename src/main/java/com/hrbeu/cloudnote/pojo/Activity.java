package com.hrbeu.cloudnote.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
public class Activity {
    private String cn_activity_id;

    private String cn_activity_title;

    private String cn_activity_body;

    private BigInteger cn_activity_end_time;

    public Activity(String cn_activity_title, String cn_activity_body, BigInteger cn_activity_end_time){
        this.cn_activity_title = cn_activity_title;
        this.cn_activity_body = cn_activity_body;
        this.cn_activity_end_time = cn_activity_end_time;
    }

}
