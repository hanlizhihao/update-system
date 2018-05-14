package com.thinking.update.main.entity;
public class App implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String targetVersionName;
    private Long createUserId;
    private Long deviceId;//设备id
    private java.util.Date createTime;//创建时间
    private Long runningState;//终端运行状态0-正常，1-异常
    private Long versionId;
    private Long protocolId;//协议
    private String runningStateName;//终端运行状态名称
    private String appName;//app名称-appTypeName
    private Integer appTypeId;//app类型id
    private java.util.Date updateTime;//更新时间
    private Long versionState;//0-未设置目标版本，10-未设置目标已收到确认，20-已设置未确认，30-一致，40-不一致
    private String versionName;
    private String updateUser;//更新用户
    private Long updateUserId;//更新用户id
    private Long targetVersionId;//目标版本
    private Object updateState;//升级状态-0-下载完成，10-正在进行MD5校验，20-MD5校验失败，30-MD5校验成功，40-准备安装，50-开始安装，60-安装中，70-安装失败，80-安装完成，90-尝试启动主程序，100-程序启动中，110-启动失败，120-启动成功，130-正在验证主程序状态，140-验证成功，150-验证失败，160-监测程序是否可以上传数据，170-通过上传数据监测，180-未通过上传数据监测，190-通过所有验证升级完成，200-尝试重新安装，210-尝试回滚版本
    private String createUser;
    private String protocolName;//协议名称
    private java.util.Date ts;//时间戳
    public App() {
        super();
    }
    public App(Long id,String targetVersionName,Long createUserId,Long deviceId,java.util.Date createTime,Long runningState,Long versionId,Long protocolId,String runningStateName,String appName,Integer appTypeId,java.util.Date updateTime,Long versionState,String versionName,String updateUser,Long updateUserId,Long targetVersionId,Object updateState,String createUser,String protocolName,java.util.Date ts) {
        super();
        this.id = id;
        this.targetVersionName = targetVersionName;
        this.createUserId = createUserId;
        this.deviceId = deviceId;
        this.createTime = createTime;
        this.runningState = runningState;
        this.versionId = versionId;
        this.protocolId = protocolId;
        this.runningStateName = runningStateName;
        this.appName = appName;
        this.appTypeId = appTypeId;
        this.updateTime = updateTime;
        this.versionState = versionState;
        this.versionName = versionName;
        this.updateUser = updateUser;
        this.updateUserId = updateUserId;
        this.targetVersionId = targetVersionId;
        this.updateState = updateState;
        this.createUser = createUser;
        this.protocolName = protocolName;
        this.ts = ts;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTargetVersionName() {
        return this.targetVersionName;
    }

    public void setTargetVersionName(String targetVersionName) {
        this.targetVersionName = targetVersionName;
    }

    public Long getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public Long getRunningState() {
        return this.runningState;
    }

    public void setRunningState(Long runningState) {
        this.runningState = runningState;
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

    public String getRunningStateName() {
        return this.runningStateName;
    }

    public void setRunningStateName(String runningStateName) {
        this.runningStateName = runningStateName;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getAppTypeId() {
        return this.appTypeId;
    }

    public void setAppTypeId(Integer appTypeId) {
        this.appTypeId = appTypeId;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getVersionState() {
        return this.versionState;
    }

    public void setVersionState(Long versionState) {
        this.versionState = versionState;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Long getUpdateUserId() {
        return this.updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Long getTargetVersionId() {
        return this.targetVersionId;
    }

    public void setTargetVersionId(Long targetVersionId) {
        this.targetVersionId = targetVersionId;
    }

    public Object getUpdateState() {
        return this.updateState;
    }

    public void setUpdateState(Object updateState) {
        this.updateState = updateState;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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
