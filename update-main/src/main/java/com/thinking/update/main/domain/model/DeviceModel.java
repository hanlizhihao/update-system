package com.thinking.update.main.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author Administrator
 * @create 2018/6/6
 */
@ApiModel("升级系统 设备Model")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DeviceModel {

    @ApiModelProperty("设备Id")
    @NotNull
    private Long deviceId;
    @ApiModelProperty("终端运行状态")
    /**
     * 终端运行状态0-正常，1-异常
     */
    private Integer runningState;

    /**
     * 应用类型Id
     */
    @ApiModelProperty("应用类型Id")
    @NotNull
    private Long appTypeId;

    @ApiModelProperty("终端应用的唯一Id")
    private Long appId;

    @ApiModelProperty("上传文件的Url地址")
    private String fileUrl;

    @ApiModelProperty("日志摘要")
    private String logSummary;

    @ApiModelProperty("日志全文")
    private String log;

    @ApiModelProperty("当前版本Id")
    private Long currentVersionId;

    @ApiModelProperty("当前协议版本Id")
    private Long currentProtocolId;
}
