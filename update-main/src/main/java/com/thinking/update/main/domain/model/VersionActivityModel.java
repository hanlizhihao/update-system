package com.thinking.update.main.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Administrator
 * @create 2018/6/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("版本变更Model")
public class VersionActivityModel {

    @ApiModelProperty("终端ID")
    @NotNull
    private Long appId;

    /**
     * 升级状态-0-下载完成，10-正在进行MD5校验，20-MD5校验失败，30-MD5校验成功，40-准备安装，
     * 50-开始安装，60-安装中，70-安装失败，80-安装完成，90-尝试启动主程序，100-程序启动中，
     * 110-启动失败，120-启动成功，130-正在验证主程序状态，140-验证成功，150-验证失败，
     * 160-监测程序是否可以上传数据，170-通过上传数据监测，180-未通过上传数据监测，
     * 190-通过所有验证升级完成，200-尝试重新安装，210-尝试回滚版本
     */
    @ApiModelProperty("版本活动状态")
    @NotNull
    private Integer versionActivityState;

    /**
     * 日志类型，0-文本，1-文件
     */
    @NotNull
    private Integer logType;

    @NotNull
    private Integer runningState;

    private Long currentVersionId;

    private Long targetVersionId;

    private Long protocolId;

    private String log;

    private String logUrl;
}
