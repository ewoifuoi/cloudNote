package com.hrbeu.cloudnote.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Note_Activity {
    private String cn_note_activity_id;

    private String cn_activity_id;

    private String cn_note_id;

    private int cn_note_activity_up;

    private int cn_note_activity_down;

    private String cn_note_activity_title;

    private String cn_note_activity_body;

    public Note_Activity(String cn_activity_id, String cn_note_id, int cn_note_activity_up, int cn_note_activity_down, String cn_note_activity_title, String cn_note_activity_body){
        this.cn_activity_id = cn_activity_id;
        this.cn_note_id = cn_note_id;
        this.cn_note_activity_up = cn_note_activity_up;
        this.cn_note_activity_down = cn_note_activity_down;
        this.cn_note_activity_title = cn_note_activity_title;
        this.cn_note_activity_body = cn_note_activity_body;
    }

}
