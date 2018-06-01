package com.thinking.update.main.controller;

import com.github.pagehelper.PageInfo;
import com.thinking.update.main.common.annotation.PrintLog;
import com.thinking.update.main.common.utils.BeanCopyHelper;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.model.AppModel;
import com.thinking.update.main.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @create 2018/6/1
 */

@Api(description = "异常状态应用Api")
@RestController
@Slf4j
@RequestMapping("/abnormal")
public class AbnormalController extends BaseApplicationController {

    @Resource
    private AppService appService;

    @ApiOperation(value = "异常终端App列表查询", notes = "异常终端App列表查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", paramType = "query", value = "查询页号"),
            @ApiImplicitParam(name = "size", paramType = "query", value = "每页显示记录数")
    })
    @PrintLog("异常终端App列表查询")
    @GetMapping(value = "/list")
    public PageInfo<App> appList(Pageable pageable, AppModel appModel, @Param("deviceIds") List<Long> deviceIds) {
        App app = new App();
        BeanCopyHelper.copy(appModel, app);
        return new PageInfo<>(appService.selectAbnormalPageBydeviceIds(pageable, deviceIds));
    }

}
