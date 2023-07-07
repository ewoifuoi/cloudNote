package com.hrbeu.cloudnote.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
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
}
