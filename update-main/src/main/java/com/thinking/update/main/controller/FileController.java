package com.thinking.update.main.controller;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.nio.file.Paths;

/**
 * @author Administrator
 * @create 2018/6/17
 */
@Controller
@Slf4j
@ConfigurationProperties(prefix = "app")
public class FileController {
    @Setter
    private String uploadDirectory;
    @Resource
    private ResourceLoader resourceLoader;

    @RequestMapping(method = RequestMethod.GET, produces = "application/octet-stream",
            value = "/download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        try {
            org.springframework.core.io.Resource resource = resourceLoader.getResource("file:" +
                    Paths.get(uploadDirectory, filename).toString());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attchement;filename=" + filename);
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        } catch (Exception e) {
            log.error("响应文件数据异常", e);
            return ResponseEntity.notFound().build();
        }
    }
}
