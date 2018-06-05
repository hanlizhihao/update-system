package com.thinking.update.main.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 * @create 2018/6/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileVo {

    @ApiModelProperty("文件名称")
    private String fileName;

    @ApiModelProperty("md5校验码")
    private String md5;

    @ApiModelProperty("文件大小")
    private Long fileSize;

    @ApiModelProperty("文件下载路径")
    private String path;

    @ApiModelProperty("文件在服务器上真实名称")
    private String realName;

}
