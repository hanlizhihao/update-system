package com.thinking.update.main.entity;
public class Version {
    private Long id;
    private Long createUserId;
    private String md5Name;//存储在服务器上的名称
    private java.util.Date createTime;
    private String fileName;//文件真实名称
    private String md5Code;//对文件的md5校验码
    private String remark;
    private Long type;//0-安装程序，1-协议
    private String url;//文件的下载地址
    private Object fileSize;//文件大小 单位：MB
    private java.util.Date updateTime;
    private String versionName;//描述名称
    private String updateUser;
    private Long updateUserId;
    private String createUser;
    private java.util.Date ts;
    public Version() {
        super();
    }
    public Version(Long id,Long createUserId,String md5Name,java.util.Date createTime,String fileName,String md5Code,String remark,Long type,String url,Object fileSize,java.util.Date updateTime,String versionName,String updateUser,Long updateUserId,String createUser,java.util.Date ts) {
        super();
        this.id = id;
        this.createUserId = createUserId;
        this.md5Name = md5Name;
        this.createTime = createTime;
        this.fileName = fileName;
        this.md5Code = md5Code;
        this.remark = remark;
        this.type = type;
        this.url = url;
        this.fileSize = fileSize;
        this.updateTime = updateTime;
        this.versionName = versionName;
        this.updateUser = updateUser;
        this.updateUserId = updateUserId;
        this.createUser = createUser;
        this.ts = ts;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getMd5Name() {
        return this.md5Name;
    }

    public void setMd5Name(String md5Name) {
        this.md5Name = md5Name;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMd5Code() {
        return this.md5Code;
    }

    public void setMd5Code(String md5Code) {
        this.md5Code = md5Code;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getType() {
        return this.type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(Object fileSize) {
        this.fileSize = fileSize;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
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
