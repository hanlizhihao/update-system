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
public class App extends AbstractEntity implements Serializable {
    private Long id;
    private String targetVersionName;
    /**
     * 设备id
     */
    private Long deviceId;

    private Integer runningState;
    private Long versionId;
    /**
     * 协议
     */
    private Long protocolId;
    /**
     * 终端运行状态名称
     */
    private String runningStateName;
    /**
     * app名称-appTypeName
     */
    private String appName;
    /**
     * app类型id
     */
    private Long appTypeId;
    /**
     * 版本管理状态 0-未设置目标版本，10-未设置目标已收到确认，20-已设置未确认，30-一致，40-不一致
     */
    private Integer versionState;
    private String versionName;
    /**
     * 目标版本
     */
    private Long targetVersionId;
    /**
     * 升级状态-0-下载完成，10-正在进行MD5校验，20-MD5校验失败，30-MD5校验成功，40-准备安装，
     * 50-开始安装，60-安装中，70-安装失败，80-安装完成，90-尝试启动主程序，100-程序启动中，
     * 110-启动失败，120-启动成功，130-正在验证主程序状态，140-验证成功，150-验证失败，
     * 160-监测程序是否可以上传数据，170-通过上传数据监测，180-未通过上传数据监测，
     * 190-通过所有验证升级完成，200-尝试重新安装，210-尝试回滚版本
     */
    private Integer updateState;
    /**
     * 协议名称
     */
    private String protocolName;
    /**
     * app对应最新升级状态日志id
     */
    private Long activityLogId;

    /**
     * app对应的最新version日志id
     */
    private Long versionLogId;

    /**
     * 这个App应用是否处于一个升级任务中，0-没有，1-有
     */
    private Integer isLock;

}
