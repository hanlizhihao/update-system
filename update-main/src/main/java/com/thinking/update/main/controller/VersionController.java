package com.thinking.update.main.controller;

import com.thinking.update.main.common.annotation.PrintLog;
import com.thinking.update.main.domain.model.EnumVo;
import com.thinking.update.main.service.VersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @create 2018/5/28
 */
@Api(description = "应用安装程序和协议文件Api")
@RestController
@Slf4j
@RequestMapping("/update")
public class VersionController {

    @Resource
    private VersionService versionService;

    @PrintLog("列表查询应用版本")
    @ApiOperation(value = "列表展示应用安装程序", notes = "列表查询应用版本", httpMethod = "GET")
    @GetMapping(value = "/version/list")
    public List<EnumVo> getVersionList() {
        return versionService.getPackageList();
    }

    @PrintLog("列表查询协议")
    @ApiOperation(value = "列表展示协议文件", notes = "列表查询协议", httpMethod = "POST")
    @GetMapping(value = "/protocol/list")
    public List<EnumVo> getProtocolList() {
        return versionService.getProtocolList();
    }

}
