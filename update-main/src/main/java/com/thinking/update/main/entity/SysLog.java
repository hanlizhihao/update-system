package com.thinking.update.main.entity;
public class SysLog {
    private Long id;
    private java.util.Date gmtCreate;//创建时间
    private String method;//请求方法
    private Long userId;//用户id
    private String ip;//IP地址
    private Integer time;//响应时间
    private String params;//请求参数
    private String operation;//用户操作
    private String username;//用户名
    public SysLog() {
        super();
    }
    public SysLog(Long id,java.util.Date gmtCreate,String method,Long userId,String ip,Integer time,String params,String operation,String username) {
        super();
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.method = method;
        this.userId = userId;
        this.ip = ip;
        this.time = time;
        this.params = params;
        this.operation = operation;
        this.username = username;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtCreate(java.util.Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getParams() {
        return this.params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
