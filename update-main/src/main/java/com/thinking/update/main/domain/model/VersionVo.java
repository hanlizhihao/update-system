package com.thinking.update.main.domain.model;

import com.thinking.update.main.domain.entity.Version;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 * @create 2018/6/6
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VersionVo implements Serializable {

    private Long appId;

    private Boolean needUpdate;

    /**
     * 需要更新的版本
     */
    private List<Version> version;

    /**
     * 版本需要共同升级成功
     */
    private Boolean transactional;
}
