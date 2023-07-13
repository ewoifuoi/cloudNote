package com.hrbeu.cloudnote.aspect;

import com.alibaba.fastjson.JSON;
import com.hrbeu.cloudnote.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;



@Aspect
@Component
public class LogAscpect {
    @Autowired
    private ISysLogService logService;


    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.hrbeu.cloudnote.aspect.Log)")
    public void logPoinCut() {

    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void savaLog(JoinPoint joinpoin){

        SysLog sysLog = new SysLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinpoin.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        Log Log = method.getAnnotation(Log.class);

        if(Log != null){
            String value  = Log.value();
            sysLog.setOperation(value);
        }

        //获取请求的类名
        String className = joinpoin.getTarget().getClass().getName();

        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethodName(className + "." + methodName);

        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        String ip = IpUtils.getRealIp(request);
        sysLog.setIp(ip);

        //请求参数
        Object args [] = joinpoin.getArgs();
        String param = JSON.toJSONString(args);
        sysLog.setParamName(param.substring(0,100));
        sysLog.setCreateTime(new Timestamp(new Date().getTime()));
        logService.save(sysLog);
    }
}
