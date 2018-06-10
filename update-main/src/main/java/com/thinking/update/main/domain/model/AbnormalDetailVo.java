package com.thinking.update.main.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @create 2018/6/3
 */
@Data
@Builder
@ApiModel("异常升级详情")
public class AbnormalDetailVo implements Serializable {

    /**
     * 当前状态
     */
    @ApiModelProperty("当前状态")
    private String currentState;

    /**
     * 上一个状态
     */
    @ApiModelProperty("上一个状态")
    private String lastState;

    /**
     * 时间
     */
    @ApiModelProperty("发生的时间")
    private Date activeTime;

    /**
     * 日志摘要
     */
    @ApiModelProperty("日志摘要")
    private String logDigest;

    private Integer logType;

    private String logUrl;
}
