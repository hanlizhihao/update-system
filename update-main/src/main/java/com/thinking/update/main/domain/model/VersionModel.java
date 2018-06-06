package com.thinking.update.main.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Administrator
 * @create 2018/6/5
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("上传的文件")
public class VersionModel extends FileVo{

    @ApiModelProperty("文件类型")
    private Integer type;

    @ApiModelProperty("文件描述")
    private String remark;

    @ApiModelProperty("版本名称")
    private String versionName;

    private Long id;
}
