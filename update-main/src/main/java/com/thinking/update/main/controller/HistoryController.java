package com.thinking.update.main.controller;

import com.thinking.update.main.domain.entity.SysLog;
import com.thinking.update.main.service.SysLogService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @create 2018/6/5
 */
@Api(description = "历史记录Api")
@RestController
@Slf4j
@RequestMapping("/history")
public class HistoryController {

    @Resource
    private SysLogService service;

    @GetMapping(value = "/list")
    public List<SysLog> getSysLog() {
        return service.selectSysLog();
    }
}
