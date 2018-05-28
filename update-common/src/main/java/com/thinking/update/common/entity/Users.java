package com.thinking.update.common.entity;

import java.io.Serializable;

public class Users implements Serializable {
    private Long id;
    private String password;
    private String realName;
    private Integer enabled;//1-开启，0-关闭
    private String picture;
    private String username;
    public Users() {
        super();
    }
    public Users(Long id,String password,String realName,Integer enabled,String picture,String username) {
        super();
        this.id = id;
        this.password = password;
        this.realName = realName;
        this.enabled = enabled;
        this.picture = picture;
        this.username = username;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return this.realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
