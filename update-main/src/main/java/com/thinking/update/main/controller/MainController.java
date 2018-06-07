package com.thinking.update.main.controller;

import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.model.DeviceModel;
import com.thinking.update.main.domain.model.VersionVo;
import com.thinking.update.main.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Api(description = "远程应用Api")
@RestController
@Slf4j
@RequestMapping("/android")
public class MainController {

    @Resource
    private AppService appService;

    @ApiOperation(value = "终端查询设备版本信息", notes = "终端获取自己的版本信息", httpMethod = "POST")
    @PostMapping(value = "/info")
    public VersionVo getAppInfo(@Validated DeviceModel deviceModel, Errors errors) {
        if (errors.hasErrors()) {
            throw new BDException("参数校验失败");
        }
        return appService.getVersionInfo(deviceModel);
    }

    
}
