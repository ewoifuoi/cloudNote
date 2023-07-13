package com.hrbeu.cloudnote.aspect;

import java.sql.Timestamp;
import java.util.Date;

public class SysLog {
    private String Operation;
    private String MethodName;
    private String Ip;

    @Override
    public String toString() {
        return "SysLog{" +
                "Operation='" + Operation + '\'' +
                ", MethodName='" + MethodName + '\'' +
                ", Ip='" + Ip + '\'' +
                ", ParamName='" + ParamName + '\'' +
                ", CreateTime=" + CreateTime +
                '}';
    }

    public void setOperation(String operation) {
        Operation = operation;
    }

    public void setMethodName(String methodName) {
        MethodName = methodName;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public String getOperation() {
        return Operation;
    }

    public String getMethodName() {
        return MethodName;
    }

    public String getIp() {
        return Ip;
    }

    public String getParamName() {
        return ParamName;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setParamName(String paramName) {
        ParamName = paramName;
    }

    public void setCreateTime(Timestamp createTime) {
        CreateTime = createTime;
    }

    private String ParamName;
    private Timestamp CreateTime;

}
