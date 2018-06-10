package com.thinking.update.main.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Administrator
 * @create 2018/5/27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEntity implements Serializable {
    /**
     * 创建时间
     */
    private java.util.Date createTime;
    private String createUser;
    /**
     * 更新用户
     */
    private String updateUser;

    private java.util.Date ts;
    /**
     * 更新时间
     */
    private java.util.Date updateTime;
}
