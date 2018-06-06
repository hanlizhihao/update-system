package com.thinking.update.main.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@Api(description = "远程应用Api")
@RestController
@Slf4j
@RequestMapping("/android")
public class MainController {

    @ApiOperation(value = "终端获取自己的版本信息", notes = "终端获取自己的版本信息", httpMethod = "POST")
    @PostMapping(value = "/info")
    public String getMain() {
        return "index";
    }
}
