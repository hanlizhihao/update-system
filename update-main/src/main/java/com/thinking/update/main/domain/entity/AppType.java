package com.thinking.update.main.domain.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Administrator
 */
public class AppType  implements Serializable {
    private Long id;
    /**
     * 类型名称
     */
    @NotNull
    private String typeName;
    /**
     * 备注
     */
    @NotNull
    private String remark;
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
