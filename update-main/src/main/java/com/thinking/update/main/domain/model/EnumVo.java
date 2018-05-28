package com.thinking.update.main.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Administrator
 * @create 2018/5/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnumVo implements Serializable {

    /**
     * DeviceId
     */
    private String value;

    /**
     * Device title名称
     */
    private String title;
}
