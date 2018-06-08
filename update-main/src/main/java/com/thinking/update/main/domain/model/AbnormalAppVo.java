package com.thinking.update.main.domain.model;

import com.thinking.update.main.domain.entity.App;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Administrator
 * @create 2018/6/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AbnormalAppVo extends App {
    private String department;

    private String plateNumber;
}
