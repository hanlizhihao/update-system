package com.thinking.update.main.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Administrator
 * @create 2018/6/5
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RunningStateDetailVo {

    private String deviceId;

    private String appName;

    private String department;

    /**
     * 当前版本
     */
    private String currentVersion;

    /**
     * 最近稳定运行版本
     */
    private String stableVersion;

    private String protocol;

    private String stableProtocol;

    private Date beginTime;

    private String duration;

    /**
     * 日志
     */
    private String log;
}
