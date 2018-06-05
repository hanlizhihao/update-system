package com.thinking.update.main.domain.model;

import lombok.*;

import java.util.List;

/**
 * @author Administrator
 * @create 2018/6/5
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AbnormalNumberVo {

    private List<String> companyNames;

    private List<Long> abnormalNumber;
}
