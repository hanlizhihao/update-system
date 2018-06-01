package com.thinking.update.main.controller;

import com.thinking.update.main.common.annotation.PrintLog;
import com.thinking.update.main.domain.entity.MauthDept;
import com.thinking.update.main.domain.entity.VehicleInfo;
import com.thinking.update.main.domain.model.EnumVo;
import com.thinking.update.main.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @create 2018/5/28
 */

@Api(description = "车辆与组织信息Api")
@RestController
@Slf4j
@RequestMapping("/vehicle")
public class VehicleController {

    @Resource
    private VehicleService vehicleService;

    @PrintLog("获取树形菜单的组织信息")
    @ApiOperation(value = "根据组织Id查询车辆与组织结构信息", notes ="根据组织Id查询车辆或组织结构信息" , httpMethod = "GET")
    @GetMapping(value = "/tree/{id}")
    public List<MauthDept> getTreeDepartList(@PathVariable Long id) {
        return vehicleService.getOneChildrenLevelById(id);
    }

    @PrintLog("获取组织下的所有车辆信息")
    @ApiOperation(value = "根据组织Id获取组织下的所有设备id",
            notes ="根据组织Id获取组织下的所有设备id" ,
            httpMethod = "GET")
    @GetMapping(value = "/treeList/{id}")
    public List<Integer> getDeviceIdsListById(@PathVariable Long id) {
        return vehicleService.getDeviceIdsByDepartId(id);
    }

}
