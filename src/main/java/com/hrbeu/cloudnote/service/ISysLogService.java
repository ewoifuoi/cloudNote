package com.hrbeu.cloudnote.service;

import com.hrbeu.cloudnote.aspect.SysLog;
import com.hrbeu.cloudnote.dao.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ISysLogService")
public class ISysLogService {

    @Autowired
    LogMapper mapper;

    public Boolean save(SysLog sysLog) {
        return mapper.save(sysLog);
    }
}
