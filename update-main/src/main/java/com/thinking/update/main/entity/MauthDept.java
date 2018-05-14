package com.thinking.update.main.entity;
public class MauthDept {
    private Integer deptId;//机构主键
    private Integer code;//机构编号
    private Long updatedAt;//更新时间
    private Integer level;//机构等级
    private String name;//机构名称
    private Long createdAt;//创建时间
    private String remark;//描述
    private Integer lft;//左值
    private Integer areaNumber;//地区编号
    private Integer rgt;//右值
    public MauthDept() {
        super();
    }
    public MauthDept(Integer deptId,Integer code,Long updatedAt,Integer level,String name,Long createdAt,String remark,Integer lft,Integer areaNumber,Integer rgt) {
        super();
        this.deptId = deptId;
        this.code = code;
        this.updatedAt = updatedAt;
        this.level = level;
        this.name = name;
        this.createdAt = createdAt;
        this.remark = remark;
        this.lft = lft;
        this.areaNumber = areaNumber;
        this.rgt = rgt;
    }
    public Integer getDeptId() {
        return this.deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getLft() {
        return this.lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getAreaNumber() {
        return this.areaNumber;
    }

    public void setAreaNumber(Integer areaNumber) {
        this.areaNumber = areaNumber;
    }

    public Integer getRgt() {
        return this.rgt;
    }

    public void setRgt(Integer rgt) {
        this.rgt = rgt;
    }

}
