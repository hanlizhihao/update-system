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
public class Task extends AbstractEntity implements Serializable {
    private Long id;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务涉及的app数量
     */
    private Integer appNumber;
    private Integer finishedNumber;
    /**
     * 描述
     */
    private String remark;
    /**
     * 任务涉及的所有机构
     */
    private String departments;
    /**
     * 任务完成比例
     */
    private Double percent;
    /**
     * 任务状态 0-正在进行，1-已经删除，2-已经完成
     */
    private Integer state;
}
