package com.thinking.update.main.controller;

import com.github.pagehelper.PageInfo;
import com.thinking.update.main.common.annotation.PrintLog;
import com.thinking.update.main.common.enums.VersionTypeEnum;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.dao.VersionDao;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.entity.Task;
import com.thinking.update.main.domain.entity.Version;
import com.thinking.update.main.domain.model.TaskModel;
import com.thinking.update.main.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 升级任务是指批量的更改版本和协议的操作
 * @author Administrator
 * @create 2018/6/3
 */
@Api(description = "升级任务")
@RestController
@Slf4j
@RequestMapping("/task")
public class TaskController extends BaseApplicationController {

    @Resource
    private TaskService taskService;

    @Resource
    private VersionDao versionDao;

    @PrintLog("基于任务的批量更新App")
    @ApiOperation(value = "创建升级任务，批量更新协议", notes = "创建升级任务", httpMethod = "POST")
    @PostMapping(value = "/create")
    public Task createTask(@RequestBody TaskModel taskModel) {
        Version version = versionDao.selectVersionById(taskModel.getVersionId());
        taskModel.setVersionName(version.getVersionName());
        if (version.getType() == VersionTypeEnum.INSTALL_PACKAGE.getValue()) {
            Task task = new Task();
            task.setTaskName(taskModel.getTaskName());
            task.setRemark(taskModel.getRemark());
            setCommonCreateFields(task);
            return taskService.insertTask(task, taskModel);
        } else {
            updateProtocol(taskModel);
            return null;
        }
    }

    private void updateProtocol(TaskModel taskModel) {
        App app = new App();
        app.setProtocolId(taskModel.getVersionId());
        setCommonUpdateFields(app);
        taskService.batchUpdateAppProtocol(app, taskModel.getAppIds());
    }

    @PrintLog("Web端更新任务")
    @ApiOperation(value = "Web端更新任务", notes = "Web端更新任务", httpMethod = "POST")
    @PostMapping(value = "/update")
    public int updateTask(@RequestBody TaskModel taskModel) {
        if (taskModel.getTaskId() == null) {
            throw new BDException("参数校验失败");
        }
        Version version = versionDao.selectVersionById(taskModel.getVersionId());
        if (version.getType() == VersionTypeEnum.INSTALL_PACKAGE.getValue()) {
            Task task = new Task();
            setCommonUpdateFields(task);
            return taskService.updateTask(task, taskModel);
        } else {
            updateProtocol(taskModel);
        }
        return 1;
    }

    @ApiOperation(value = "升级任务列表", notes = "升级任务列表", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", paramType = "query", value = "查询页号"),
            @ApiImplicitParam(name = "size", paramType = "query", value = "每页显示记录数")
    })
    @PrintLog("升级任务列表查询")
    @GetMapping(value = "/list")
    public PageInfo<Task> taskList(Pageable pageable, Task task) {
        return new PageInfo<>(taskService.selectTaskByPageAndFilter(pageable, task));
    }

    @PrintLog("取消升级任务 By TaskId")
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "根据Id删除应用 BY hlz", notes = "根据Id删除终端应用 BY hlz", httpMethod = "DELETE")
    public int deleteTaskById(@PathVariable Long id) {
        return taskService.deleteTaskById(id);
    }
}
