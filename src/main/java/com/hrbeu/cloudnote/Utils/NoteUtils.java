package com.hrbeu.cloudnote.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class NoteUtils {

    public static String getMD5(String pwd) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] output = md5.digest(pwd.getBytes());
        return Base64.getEncoder().encodeToString(output);
    }
}
