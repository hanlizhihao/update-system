package com.thinking.update.main.entity;
public class Users {
    private Long id;
    private String password;
    private Integer enabled;//1-开启，0-关闭
    private String username;
    public Users() {
        super();
    }
    public Users(Long id,String password,Integer enabled,String username) {
        super();
        this.id = id;
        this.password = password;
        this.enabled = enabled;
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

    public Integer getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
