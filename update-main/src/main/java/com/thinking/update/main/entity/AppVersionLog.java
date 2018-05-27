package com.thinking.update.main.entity;
public class AppVersionLog {
    private Long id;
    private String appName;//车牌号+应用名称
    private String stateName;
    private Long targetVersionId;//目标版本id
    private Long versionId;//当前版本id
    private Long state;//版本变更状态0-升级中，1-升级完成，2-升级失败
    private Long appId;
    private String version;//当前版本名称
    private String targetVersion;//目标升级版本
    private java.util.Date ts;
    public AppVersionLog() {
        super();
    }
    public AppVersionLog(Long id,String appName,String stateName,Long targetVersionId,Long versionId,Long state,Long appId,String version,String targetVersion,java.util.Date ts) {
        super();
        this.id = id;
        this.appName = appName;
        this.stateName = stateName;
        this.targetVersionId = targetVersionId;
        this.versionId = versionId;
        this.state = state;
        this.appId = appId;
        this.version = version;
        this.targetVersion = targetVersion;
        this.ts = ts;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Long getTargetVersionId() {
        return this.targetVersionId;
    }

    public void setTargetVersionId(Long targetVersionId) {
        this.targetVersionId = targetVersionId;
    }

    public Long getVersionId() {
        return this.versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public Long getState() {
        return this.state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getAppId() {
        return this.appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTargetVersion() {
        return this.targetVersion;
    }

    public void setTargetVersion(String targetVersion) {
        this.targetVersion = targetVersion;
    }

    public java.util.Date getTs() {
        return this.ts;
    }

    public void setTs(java.util.Date ts) {
        this.ts = ts;
    }

}
