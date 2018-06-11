package com.thinking.update.main.controller;

import com.fasterxml.jackson.core.TreeNode;
import com.thinking.update.main.common.annotation.PrintLog;
import com.thinking.update.main.domain.entity.MauthDept;
import com.thinking.update.main.domain.model.TreeVo;
import com.thinking.update.main.service.MauthDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @create 2018/6/3
 */

@Api(description = "组织信息Api")
@RestController
@Slf4j
@RequestMapping("/dept")
public class MauthDeptController {

    @Resource
    private MauthDeptService mauthDeptService;

    @PrintLog("获取树形菜单的组织信息")
    @ApiOperation(value = "根据组织Id查询组织结构信息", notes ="根据组织Id查询组织结构信息" , httpMethod = "GET")
    @GetMapping(value = "/tree/{id}")
    public List<MauthDept> getTreeDepartList(@PathVariable Integer id) {
        return mauthDeptService.getMauthUnderById(id);
    }

    @PrintLog("查询树形菜单全部节点")
    @ApiOperation(value = "查询组织菜单全部节点", notes = "查询组织菜单全部节点", httpMethod = "GET")
    @GetMapping(value = "/all/tree")
    public List<TreeVo> getAllTree() {
        TreeVo treeNode = mauthDeptService.getAllTreeVo();
        List<TreeVo> treeVoList = new ArrayList<>();
        treeVoList.add(treeNode);
        return treeVoList;
    }
}
