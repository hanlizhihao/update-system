package com.thinking.update.main.controller;

import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.domain.entity.AbstractEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author Administrator
 * @create 2018/5/27
 */
@Slf4j
public abstract class BaseApplicationController {

    public static String currentUserName() {
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        if (oAuth2Authentication != null) {
            return (String)oAuth2Authentication.getPrincipal();
        }
        return null;
    }

    public static Object setCommonFields(Object object, boolean isCreate) {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class<?> clazz = object.getClass();
        try {
            MethodHandle tsHandle = lookup.findSetter(clazz, "ts", Date.class);
            MethodHandle updateTimeHandle = lookup.findSetter(clazz, "updateTime", Date.class);
            MethodHandle updateUserHandle = lookup.findSetter(clazz, "updateUser", String.class);
            Date currentTime = new Date(System.currentTimeMillis());
            tsHandle.invoke(object, currentTime);
            updateTimeHandle.invoke(object, currentTime);
            updateUserHandle.invoke(object, currentUserName());
            if (isCreate) {
                MethodHandle createTimeHandle = lookup.findSetter(clazz,"createTime",Date.class);
                MethodHandle createUserHandle = lookup.findSetter(clazz, "createUser", String.class);
                createTimeHandle.invoke(object, currentTime);
                createUserHandle.invoke(object, currentUserName());
            }

        } catch (Throwable throwable) {
            log.error("MethodHandle调用异常", throwable);
            throw new BDException("不能设置通用创建属性");
        }
        return object;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(Boolean.class,new CustomBooleanEditor(true));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(format,true));
    }

    /**
     *
     * @param entity
     */
    protected void setCommonCreateFields(AbstractEntity entity) {
        Date date = new Date(System.currentTimeMillis());
        entity.setCreateUser(currentUserName());
        entity.setCreateTime(date);
        entity.setUpdateUser(currentUserName());
        entity.setUpdateTime(date);
        entity.setTs(date);
    }

    /**
     * 设置通用更新字段值
     * @param entity
     */
    protected void setCommonUpdateFields(AbstractEntity entity) {
        Date date = new Date(System.currentTimeMillis());
        entity.setUpdateUser(currentUserName());
        entity.setUpdateTime(date);
        entity.setTs(date);
    }
}
