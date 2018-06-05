package com.thinking.update.main.controller;

import com.github.pagehelper.PageInfo;
import com.thinking.update.common.entity.Users;
import com.thinking.update.common.service.UsersService;
import com.thinking.update.main.common.annotation.PrintLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @create 2018/6/5
 */
@Api(description = "用户Api")
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Resource
    private UsersService usersService;

    @PrintLog("用户列表")
    @GetMapping("/list")
    @ApiOperation(value = "用户列表分页显示", notes = "用户列表分页显示", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", paramType = "query", value = "查询页号"),
            @ApiImplicitParam(name = "size", paramType = "query", value = "每页显示记录数")
    })
    public PageInfo<Users> getUsers(Pageable pageable, Users users) {
        return new PageInfo<>(usersService.selectUsersPageAndFilter(pageable, users));
    }

    @PrintLog("添加User")
    @ApiOperation(value = "添加App", notes = "添加App", httpMethod = "POST")
    @PostMapping(value = "/create")
    public Users createUser(Users users) {
        return usersService.insertNonEmptyUsers(users);
    }

    @PrintLog("更新User")
    @PostMapping(value = "/update")
    @ApiOperation(value = "更新User BY hlz", notes = "更新User BY hlz", httpMethod = "POST")
    public int updateApp(Users users) {
        return usersService.updateNonEmptyUsersById(users);
    }

    @PrintLog("根据Id删除User")
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "根据Id删除User BY hlz", notes = "根据Id删除终端应用 BY hlz", httpMethod = "DELETE")
    public int deleteUserById(@PathVariable Long id) {
        return usersService.deleteUsersById(id);
    }
}
