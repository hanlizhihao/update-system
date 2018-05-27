package com.thinking.update.main.domain.entity;

import java.io.Serializable;

public class AppType  implements Serializable {
    private Long id;
    private String typeName;//类型名称
    private String remark;//备注
    public AppType() {
        super();
    }
    public AppType(Long id,String typeName,String remark) {
        super();
        this.id = id;
        this.typeName = typeName;
        this.remark = remark;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
