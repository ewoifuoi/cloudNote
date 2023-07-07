package com.hrbeu.cloudnote.Utils;

import junit.framework.TestCase;

import java.security.NoSuchAlgorithmException;

public class NoteUtilsTest extends TestCase {

    public void testGetMD5() throws NoSuchAlgorithmException {
        String pwd = "123";

        System.out.println(NoteUtils.getMD5(pwd));
    }
}