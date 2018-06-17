package com.thinking.update.main.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author Administrator
 * @create 2018/6/3
 */

@ApiModel("升级系统 任务Model")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TaskModel {

    @ApiModelProperty("任务名称")
    private String taskName;

    @ApiModelProperty("任务备注")
    private String remark;

    @ApiModelProperty("所有需要切换版本的app")
    private List<Long> appIds;

    @ApiModelProperty("批量更新的目标版本ID VersionId")
    private Long versionId;

    private String versionName;

    @ApiModelProperty("任务Id")
    @NotEmpty
    private Long taskId;
}
