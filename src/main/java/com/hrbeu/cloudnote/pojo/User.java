package com.hrbeu.cloudnote.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {


    private String cn_user_id;

    private String cn_user_name;
    private String cn_user_password;
    private String cn_user_token;
    private String cn_user_nick;

    public User(String cn_user_name, String cn_user_password, String cn_user_nick) {
        this.cn_user_name = cn_user_name;
        this.cn_user_password = cn_user_password;
        this.cn_user_nick = cn_user_nick;
    }
}
