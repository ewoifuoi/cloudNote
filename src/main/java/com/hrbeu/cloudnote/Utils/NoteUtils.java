package com.hrbeu.cloudnote.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class NoteUtils {

    public static String getMD5(String pwd) {
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] output = md5.digest(pwd.getBytes());
            return Base64.getEncoder().encodeToString(output);
        }
        catch (Exception e){
            return "";
        }

    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static String getCurrentTime() {
        Date d = new Date();
        System.out.println(d.getTime() +" ==== 当前毫秒数");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 生成一个格式化对象
        String date = sdf.format(d); //格式化时间
        return date;
    }
}
