package com.thinking.update.main.domain.model;

import lombok.*;

/**
 * @author Administrator
 * @create 2018/6/7
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ActivityVo extends VersionVo {

    private Boolean updateChange;

}
