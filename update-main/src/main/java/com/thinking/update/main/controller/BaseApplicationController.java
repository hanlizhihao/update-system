package com.thinking.update.main.controller;

import com.thinking.update.main.domain.entity.AbstractEntity;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @create 2018/5/27
 */
public abstract class BaseApplicationController {

    public static UserDetails currentUserDetails() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            return principal instanceof UserDetails ? (UserDetails) principal : null;
        }
        return null;
    }

    private String getUserName() {
        UserDetails userDetails = currentUserDetails();
        return userDetails == null? null: userDetails.getUsername();
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
        entity.setCreateUser(this.getUserName());
        entity.setUpdateUser(this.getUserName());
        entity.setTs(new Date(System.currentTimeMillis()));
    }

    /**
     * 设置通用更新字段值
     * @param entity
     */
    protected void setCommonUpdateFields(AbstractEntity entity) {
        entity.setUpdateUser(this.getUserName());
        entity.setTs(new Date(System.currentTimeMillis()));
    }
}
