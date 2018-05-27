package com.thinking.update.main.controller;

import com.thinking.update.main.common.utils.BeanCopyHelper;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.model.AppModel;
import com.thinking.update.main.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @create 2018/5/27
 */
@Api(description = "终端应用Api")
@RestController
@Slf4j
@RequestMapping("/update/app")
public class TerminalAppController extends BaseApplicationController {

    @Resource
    private AppService appService;

    @ApiOperation(value = "创建App应用", notes = "创建App应用", httpMethod = "POST")
    @PostMapping(value = "/create")
    @Validated
    public App createApp(AppModel appModel) {
        App app = new App();
        BeanCopyHelper.copy(appModel, app);
        setCommonCreateFields(app);
        return appService.insertApp(app);
    }
}
