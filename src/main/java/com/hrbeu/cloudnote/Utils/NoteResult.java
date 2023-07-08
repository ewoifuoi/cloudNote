package com.hrbeu.cloudnote.Utils;

public class NoteResult {

    private  int code;
    private  String msg;
    private Object data;


    public NoteResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public NoteResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public NoteResult() {

    }

    public static NoteResult registerSuccess(){
        return new NoteResult(1,"Register  Success");
    }
    public static NoteResult registerFail(){
        return new NoteResult(2,"注册失败");
    }
    public static NoteResult loginSuccess(){
        return new NoteResult(3,"登录成功");
    }
    public static NoteResult loginFail(){
        return new NoteResult(4,"登录失败");
    }





    // get set
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
