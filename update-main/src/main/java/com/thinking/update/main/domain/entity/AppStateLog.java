package com.thinking.update.main.domain.entity;
public class AppStateLog {
    private Long id;
    private String appName;
    private Integer lastState;//上一个状态
    private String versionName;
    private String log;//异常时，写入的日志
    private Integer currentState;//当前状态
    private Long versionId;
    private Long protocolId;
    private Long appId;
    private String protocolName;
    private java.util.Date ts;
    public AppStateLog() {
        super();
    }
    public AppStateLog(Long id,String appName,Integer lastState,String versionName,String log,Integer currentState,Long versionId,Long protocolId,Long appId,String protocolName,java.util.Date ts) {
        super();
        this.id = id;
        this.appName = appName;
        this.lastState = lastState;
        this.versionName = versionName;
        this.log = log;
        this.currentState = currentState;
        this.versionId = versionId;
        this.protocolId = protocolId;
        this.appId = appId;
        this.protocolName = protocolName;
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

    public Integer getLastState() {
        return this.lastState;
    }

    public void setLastState(Integer lastState) {
        this.lastState = lastState;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getLog() {
        return this.log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Integer getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }

    public Long getVersionId() {
        return this.versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public Long getProtocolId() {
        return this.protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public Long getAppId() {
        return this.appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getProtocolName() {
        return this.protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public java.util.Date getTs() {
        return this.ts;
    }

    public void setTs(java.util.Date ts) {
        this.ts = ts;
    }

}
