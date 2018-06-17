package com.thinking.update.main.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Administrator
 * @create 2018/5/27
 */

@ApiModel("升级系统 终端应用")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AppModel implements Serializable {
    @ApiModelProperty("AppID")
    private Long id;
    @ApiModelProperty("设备Id")
    @NotNull
    private Long deviceId;
    @ApiModelProperty("终端运行状态")
    /**
     * 终端运行状态0-正常，1-异常
     */
    private Long runningState;
    @NotNull
    @ApiModelProperty("当前版本Id")
    private Long versionId;
    @ApiModelProperty("当前协议Id")
    @NotNull
    private Long protocolId;
    @ApiModelProperty("应用类型Id")
    private Long appTypeId;
    /**
     * 版本管理状态 0-未设置目标版本，10-未设置目标已收到确认，20-已设置未确认，30-一致，40-不一致
     */
    @ApiModelProperty("版本管理状态")
    private Long versionState;
    @ApiModelProperty("应用目标版本Id")
    private Long targetVersionId;
    @ApiModelProperty("升级状态")
    private Integer updateState;

    @ApiModelProperty("树形菜单选择的id")
    private String deviceIds;

    @ApiModelProperty("所在升级任务Id")
    private Long taskId;
}
