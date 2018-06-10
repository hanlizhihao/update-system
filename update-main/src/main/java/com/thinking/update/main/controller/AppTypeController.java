package com.thinking.update.main.controller;

import com.thinking.update.main.common.annotation.PrintLog;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.domain.entity.AppType;
import com.thinking.update.main.domain.model.EnumVo;
import com.thinking.update.main.service.AppTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @create 2018/5/27
 */
@RequestMapping("/appType")
@RestController
@Api(description = "终端应用类型")
@Slf4j
public class AppTypeController  {

    @Resource
    private AppTypeService appTypeService;

    @PrintLog("应用类别查询枚举值")
    @GetMapping(value = "/list")
    @ApiOperation(value = "终端应用类型列表", notes = "终端应用类型列表", httpMethod = "GET")
    public List<EnumVo> getAppTypeList() {
        return appTypeService.getAppTypeList();
    }

    @PrintLog("应用类别全部信息")
    @GetMapping(value = "/all/list")
    @ApiOperation(value = "应用类别全部信息", notes = "应用类别全部信息", httpMethod = "GET")
    public List<AppType> getAppTypeAll() {
        return appTypeService.selectAppType();
    }

    @PrintLog("创建分类")
    @ApiOperation(value = "创建App分类", notes = "创建App分类", httpMethod = "POST")
    @PostMapping(value = "/create")
    public AppType createAppType(@Validated AppType type, Errors errors) {
        if (errors.hasErrors()) {
            throw new BDException("appType参数校验失败");
        }
        return appTypeService.insertAppType(type);
    }

    @PrintLog("更新终端应用分类")
    @PostMapping(value = "/update")
    @ApiOperation(value = "更新终端应用分类 BY hlz", notes = "更新终端应用分类 BY hlz", httpMethod = "POST")
    public int updateAppType(@Validated AppType appType, Errors errors) {
        if (errors.hasErrors() || appType.getId() == null) {
            throw new BDException("参数校验失败");
        } else {
            return appTypeService.updateNonEmptyAppTypeById(appType);
        }
    }

    @PrintLog("删除终端应用分类")
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "根据Id删除应用分类 BY hlz", notes = "根据Id删除终端应用分类 BY hlz", httpMethod = "DELETE")
    public int deleteAppById(@PathVariable Long id) {
        return appTypeService.deleteAppTypeById(id);
    }
}
