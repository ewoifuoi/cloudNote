package com.hrbeu.cloudnote.dao;

import com.hrbeu.cloudnote.aspect.SysLog;
import org.apache.ibatis.annotations.Insert;

public interface LogMapper {

    @Insert("insert into sys_log (operation, createTime, method_name, param_name, ip) values (#{operation}, #{createTime}, #{methodName}, #{paramName}, #{ip});")
    Boolean save(SysLog sysLog);
}
