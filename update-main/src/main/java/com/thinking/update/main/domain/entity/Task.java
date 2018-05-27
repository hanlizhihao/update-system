package com.thinking.update.main.domain.entity;

import java.io.Serializable;

public class Task implements Serializable {
    private Long id;
    private String taskName;//任务名称
    private java.util.Date updateTime;
    private String updateUser;
    private java.util.Date createTime;
    private Object appNumber;//任务涉及的app数量
    private Object finishedNumber;
    private String remark;//描述
    private String departments;//任务涉及的所有机构
    private String createUser;
    private Double percent;//任务完成比例
    private java.util.Date ts;
    public Task() {
        super();
    }
    public Task(Long id,String taskName,java.util.Date updateTime,String updateUser,java.util.Date createTime,Object appNumber,Object finishedNumber,String remark,String departments,String createUser,Double percent,java.util.Date ts) {
        super();
        this.id = id;
        this.taskName = taskName;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.appNumber = appNumber;
        this.finishedNumber = finishedNumber;
        this.remark = remark;
        this.departments = departments;
        this.createUser = createUser;
        this.percent = percent;
        this.ts = ts;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public Object getAppNumber() {
        return this.appNumber;
    }

    public void setAppNumber(Object appNumber) {
        this.appNumber = appNumber;
    }

    public Object getFinishedNumber() {
        return this.finishedNumber;
    }

    public void setFinishedNumber(Object finishedNumber) {
        this.finishedNumber = finishedNumber;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDepartments() {
        return this.departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Double getPercent() {
        return this.percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public java.util.Date getTs() {
        return this.ts;
    }

    public void setTs(java.util.Date ts) {
        this.ts = ts;
    }

}
