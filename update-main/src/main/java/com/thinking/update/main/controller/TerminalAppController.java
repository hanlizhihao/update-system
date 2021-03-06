package com.thinking.update.main.controller;

import com.github.pagehelper.PageInfo;
import com.thinking.update.main.common.annotation.PrintLog;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.common.utils.AppTaskUtil;
import com.thinking.update.main.common.utils.BeanCopyHelper;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.model.AbnormalNumberVo;
import com.thinking.update.main.domain.model.AppModel;
import com.thinking.update.main.domain.model.EnumVo;
import com.thinking.update.main.domain.model.RunningStateDetailVo;
import com.thinking.update.main.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @create 2018/5/27
 */
@Api(description = "终端应用Api")
@RestController
@Slf4j
@RequestMapping("/app")
public class TerminalAppController extends BaseApplicationController {

    @Resource
    private AppService appService;

    @PrintLog("添加终端App应用")
    @ApiOperation(value = "创建App应用", notes = "创建App应用", httpMethod = "POST")
    @PostMapping(value = "/create")
    public App createApp(@Validated AppModel appModel, Errors errors) {
        if (errors.hasErrors()) {
            throw new BDException("参数校验失败");
        }
        App app = new App();
        BeanCopyHelper.copy(appModel, app);
        setCommonCreateFields(app);
        return appService.insertApp(app);
    }

    @ApiOperation(value = "终端app列表查询", notes = "终端app列表查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", paramType = "query", value = "查询页号"),
            @ApiImplicitParam(name = "size", paramType = "query", value = "每页显示记录数")
    })
    @PrintLog("终端app列表查询")
    @GetMapping(value = "/list")
    public PageInfo<App> appList(Pageable pageable, AppModel appModel) {
        ArrayList<Long> deviceIds = AppTaskUtil.paramConverter(appModel);
        App app = new App();
        BeanCopyHelper.copy(appModel, app);
        return new PageInfo<>(appService.selectAppByPageAndFilter(pageable, app, deviceIds));
    }

    @ApiOperation(value = "根据运行状态查询App", notes = "根据运行状态查询App", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", paramType = "query", value = "查询页号"),
            @ApiImplicitParam(name = "size", paramType = "query", value = "每页显示记录数"),
            @ApiImplicitParam(name = "state", paramType = "query", value = "终端运行状态")
    })
    @PrintLog("根据运行状态查询App")
    @GetMapping(value = "/state/list")
    public PageInfo<App> abnormalAppList(Pageable pageable, AppModel appModel) {
        return new PageInfo<>(appService.selectAppByPageAndRunningState(pageable, appModel));
    }

    @PrintLog("更新终端应用")
    @PostMapping(value = "/update")
    @ApiOperation(value = "更新终端应用 BY hlz", notes = "更新终端应用 BY hlz", httpMethod = "POST")
    public int updateApp(@Validated @RequestBody AppModel model, Errors errors) {
        if (errors.hasErrors() || model.getId() == null) {
            throw new BDException("参数校验失败");
        }
        App app = new App();
        setCommonUpdateFields(app);
        BeanCopyHelper.copy(model, app);
        app.setTargetVersionId(app.getVersionId());
        return appService.updateNonEmptyAppById(app);
    }

    @PrintLog("根据Id获取终端应用")
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "根据Id终端应用 BY hlz", notes = "根据Id获取终端应用 BY hlz", httpMethod = "GET")
    public App getAppById(@PathVariable Long id) {
        return appService.selectAppById(id);
    }

    @PrintLog("根据Id删除终端应用")
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "根据Id删除应用 BY hlz", notes = "根据Id删除终端应用 BY hlz", httpMethod = "DELETE")
    public int deleteAppById(@PathVariable Long id) {
        return appService.deleteAppById(id);
    }

    @PrintLog("获取车载设备枚举列表")
    @GetMapping(value = "/device/list")
    @ApiOperation(value = "获取设备Id列表 BY hlz", notes = "获取设备Id列表 BY hlz", httpMethod = "GET")
    public List<EnumVo> getDeviceIdList() {
        return appService.getDeviceList();
    }

    @PrintLog("统计终端运行状态所占比例")
    @GetMapping(value = "/statistics/state")
    @ApiOperation(value = "统计终端运行状态所占比例 BY hlz", notes = "统计终端运行状态所占比例 BY hlz", httpMethod = "GET")
    public List<EnumVo> getAppStateStatistics() {
        return appService.getAppStateStatistics();
    }

    @PrintLog("各机构异常终端数量")
    @GetMapping(value = "/statistics/abnormal")
    @ApiOperation(value = "各机构异常终端数量 BY hlz", notes = "各机构异常终端数量 BY hlz", httpMethod = "GET")
    public List<List<?>> getAbnormalAppNumber() {
        return appService.getAbnormalAppNumber();
    }

    @PrintLog("查询终端运行状态详情")
    @GetMapping(value = "/runningState/detail/{id}")
    @ApiOperation(value = "终端运行状态详情 BY hlz", notes = "终端运行状态详情 BY hlz", httpMethod = "GET")
    public RunningStateDetailVo getRunningStateDetail(@PathVariable Long id) {
        return appService.getStateDetail(id);
    }
}
