package com.thinking.update.main.domain.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author Administrator
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Version extends AbstractEntity implements Serializable {
    private Long id;
    /**
     * 存储在服务器上的名称
     */
    private String md5Name;
    /**
     * 文件真实名称
     */
    private String fileName;
    /**
     * 对文件的md5校验码
     */
    private String md5Code;
    private String remark;
    /**
     * 0-安装程序，1-协议
     */
    private Integer type;
    /**
     * 文件的下载地址
     */
    private String url;
    /**
     * 文件大小 单位：MB
     */
    private Double fileSize;
    /**
     * 描述名称
     */
    private String versionName;

}
