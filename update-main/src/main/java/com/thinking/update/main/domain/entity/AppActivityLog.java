package com.thinking.update.main.domain.entity;

import java.io.Serializable;

public class AppActivityLog implements Serializable {
    private Long id;
    private Long versionLogId;//版本日志id
    private String lastUpdateState;
    private String log;//终端错误日志描述
    private Long versionId;//当前版本
    private String version;
    private String targetVersion;
    private String appName;
    private Long logType;//日志类型，0-文本，1-文件
    private Long targetVersionId;
    private String logUrl;//日志下载地址
    private String updateState;
    private Long appId;//app id
    private java.util.Date ts;
    public AppActivityLog() {
        super();
    }
    public AppActivityLog(Long id,Long versionLogId,String lastUpdateState,String log,Long versionId,String version,String targetVersion,String appName,Long logType,Long targetVersionId,String logUrl,String updateState,Long appId,java.util.Date ts) {
        super();
        this.id = id;
        this.versionLogId = versionLogId;
        this.lastUpdateState = lastUpdateState;
        this.log = log;
        this.versionId = versionId;
        this.version = version;
        this.targetVersion = targetVersion;
        this.appName = appName;
        this.logType = logType;
        this.targetVersionId = targetVersionId;
        this.logUrl = logUrl;
        this.updateState = updateState;
        this.appId = appId;
        this.ts = ts;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersionLogId() {
        return this.versionLogId;
    }

    public void setVersionLogId(Long versionLogId) {
        this.versionLogId = versionLogId;
    }

    public String getLastUpdateState() {
        return this.lastUpdateState;
    }

    public void setLastUpdateState(String lastUpdateState) {
        this.lastUpdateState = lastUpdateState;
    }

    public String getLog() {
        return this.log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Long getVersionId() {
        return this.versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
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

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Long getLogType() {
        return this.logType;
    }

    public void setLogType(Long logType) {
        this.logType = logType;
    }

    public Long getTargetVersionId() {
        return this.targetVersionId;
    }

    public void setTargetVersionId(Long targetVersionId) {
        this.targetVersionId = targetVersionId;
    }

    public String getLogUrl() {
        return this.logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getUpdateState() {
        return this.updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }

    public Long getAppId() {
        return this.appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public java.util.Date getTs() {
        return this.ts;
    }

    public void setTs(java.util.Date ts) {
        this.ts = ts;
    }

}
