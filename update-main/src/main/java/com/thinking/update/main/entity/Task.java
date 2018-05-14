package com.thinking.update.main.entity;
public class Task {
    private Long id;
    private String taskName;//任务名称
    private java.util.Date createTime;
    private Object finishedNumber;
    private String remark;//描述
    private String departmentIds;
    private java.util.Date updateTime;
    private String updateUser;
    private Object appNumber;//任务涉及的app数量
    private Double persent;//任务完成比例
    private String departments;//任务涉及的所有机构
    private String createUser;
    private java.util.Date ts;
    public Task() {
        super();
    }
    public Task(Long id,String taskName,java.util.Date createTime,Object finishedNumber,String remark,String departmentIds,java.util.Date updateTime,String updateUser,Object appNumber,Double persent,String departments,String createUser,java.util.Date ts) {
        super();
        this.id = id;
        this.taskName = taskName;
        this.createTime = createTime;
        this.finishedNumber = finishedNumber;
        this.remark = remark;
        this.departmentIds = departmentIds;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.appNumber = appNumber;
        this.persent = persent;
        this.departments = departments;
        this.createUser = createUser;
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

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
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

    public String getDepartmentIds() {
        return this.departmentIds;
    }

    public void setDepartmentIds(String departmentIds) {
        this.departmentIds = departmentIds;
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

    public Object getAppNumber() {
        return this.appNumber;
    }

    public void setAppNumber(Object appNumber) {
        this.appNumber = appNumber;
    }

    public Double getPersent() {
        return this.persent;
    }

    public void setPersent(Double persent) {
        this.persent = persent;
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

    public java.util.Date getTs() {
        return this.ts;
    }

    public void setTs(java.util.Date ts) {
        this.ts = ts;
    }

}
