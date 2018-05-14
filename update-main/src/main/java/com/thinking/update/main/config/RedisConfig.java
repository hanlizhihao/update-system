package com.thinking.update.main.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanlizhi
 * @create 2017-11-01 17:16
 */

@Component
@ConfigurationProperties(prefix = "spring")
@Data
public class RedisConfig {

    private Map<String,String> redis = new HashMap<>();


}
