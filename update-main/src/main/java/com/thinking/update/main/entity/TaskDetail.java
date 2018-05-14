package com.thinking.update.main.entity;
public class TaskDetail {
    private Long id;
    private Long taskId;
    private Long appId;
    public TaskDetail() {
        super();
    }
    public TaskDetail(Long id,Long taskId,Long appId) {
        super();
        this.id = id;
        this.taskId = taskId;
        this.appId = appId;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getAppId() {
        return this.appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

}
