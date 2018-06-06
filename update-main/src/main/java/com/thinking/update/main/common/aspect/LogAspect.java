package com.thinking.update.main.common.aspect;

import com.thinking.update.common.dao.UsersDao;
import com.thinking.update.common.entity.Users;
import com.thinking.update.main.common.annotation.PrintLog;
import com.thinking.update.main.common.utils.HttpContextUtils;
import com.thinking.update.main.common.utils.IPUtils;
import com.thinking.update.main.common.utils.JSONUtils;
import com.thinking.update.main.controller.BaseApplicationController;
import com.thinking.update.main.dao.LogDao;
import com.thinking.update.main.domain.entity.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.Date;

/**
 * @author Administrator
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Resource
    private LogDao logMapper;

    @Resource
    private UsersDao usersDao;

    @Pointcut("@annotation(com.thinking.update.main.common.annotation.PrintLog)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point, time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        PrintLog syslog = method.getAnnotation(PrintLog.class);
        if (syslog != null) {
            // 注解上的描述
            sysLog.setOperation(syslog.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            String jsonParam = JSONUtils.beanToJson(args[0]);
            if (jsonParam.length() >= 5000) {
                jsonParam = jsonParam.substring(0, 4999);
            }
            sysLog.setParams(jsonParam);
        } catch (Exception e) {
            log.error("切面打印日志异常", e);
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));
        sysLog.setUsername(BaseApplicationController.currentUserName());
        Users users = new Users();
        users.setUsername(BaseApplicationController.currentUserName());
        users = usersDao.selectUsersByObj(users);
        sysLog.setUserId(users.getId());
        sysLog.setTime((int) time);
        // 系统当前时间
        Date date = new Date();
        sysLog.setGmtCreate(date);
        // 保存系统日志
        logMapper.save(sysLog);
    }
}
