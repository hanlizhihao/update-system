package com.thinking.update.main.domain.model;

import com.thinking.update.main.domain.entity.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Administrator
 * @create 2018/6/17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageVersionVo extends Version {
    private String fileSizeString;
    private String versionType;
}
