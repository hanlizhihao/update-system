package com.thinking.update.main.controller;

import com.github.pagehelper.PageInfo;
import com.thinking.update.main.common.annotation.PrintLog;
import com.thinking.update.main.common.utils.BeanCopyHelper;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.model.AbnormalAppVo;
import com.thinking.update.main.domain.model.AbnormalDetailVo;
import com.thinking.update.main.domain.model.AppModel;
import com.thinking.update.main.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.thinking.update.main.common.utils.AppTaskUtil.paramConverter;

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
    public PageInfo<AbnormalAppVo> appList(Pageable pageable, AppModel appModel) {
        ArrayList<Long> deviceIds = paramConverter(appModel);
        App app = new App();
        BeanCopyHelper.copy(appModel, app);
        return new PageInfo<>(appService.selectAbnormalPageByDeviceIds(pageable, deviceIds));
    }



    @PrintLog("查询异常升级的异常活动列表即异常详情")
    @GetMapping(value = "/detail/{id}")
    @ApiOperation(value = "异常升级活动的列表 BY hlz", notes = "异常升级活动的列表 BY hlz", httpMethod = "GET")
    public List<AbnormalDetailVo> getAbnormalDetailByAppId(@PathVariable Long id) {
        return appService.getAbnormalDetails(id);
    }

}
