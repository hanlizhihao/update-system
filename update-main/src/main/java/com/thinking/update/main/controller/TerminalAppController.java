package com.thinking.update.main.controller;

import com.github.pagehelper.PageInfo;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.common.utils.BeanCopyHelper;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.model.AppModel;
import com.thinking.update.main.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

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

    @ApiOperation(value = "终端app列表查询", notes = "终端app列表查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", paramType = "query", value = "查询页号"),
            @ApiImplicitParam(name = "size", paramType = "query", value = "每页显示记录条数")
    })
    @GetMapping(value = "/list")
    public PageInfo<App> appList(Pageable pageable, AppModel appModel) {
        App app = new App();
        BeanCopyHelper.copy(appModel, app);
        return new PageInfo<>(appService.selectAppByPageAndFilter(pageable, app));
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "更新终端应用 BY hlz", notes = "更新终端应用 BY hlz", httpMethod = "POST")
    public int updateApp(@Validated AppModel model, Errors errors) {
        if (errors.hasErrors() || model.getId() == null) {
            throw new BDException("参数校验失败");
        } else {
            App app = new App();
            BeanCopyHelper.copy(model, app);
            return appService.updateNonEmptyAppById(app);
        }
    }
}
