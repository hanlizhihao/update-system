package com.thinking.update.main.service.impl;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.thinking.update.main.common.enums.VersionManageStateEnum;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.controller.BaseApplicationController;
import com.thinking.update.main.dao.AppDao;
import com.thinking.update.main.dao.TaskDao;
import com.thinking.update.main.dao.TaskDetailDao;
import com.thinking.update.main.dao.VehicleDao;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.entity.Task;
import com.thinking.update.main.domain.entity.TaskDetail;
import com.thinking.update.main.domain.entity.VehicleInfo;
import com.thinking.update.main.domain.model.TaskModel;
import com.thinking.update.main.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class TaskServiceImpl implements TaskService{
    @Resource
    private TaskDao taskDao;
    @Resource
    private VehicleDao vehicleDao;
    @Resource
    private TaskDetailDao taskDetailDao;
    @Resource
    private AppDao appDao;

    @Override
    public long getTaskRowCount(){
        return taskDao.getTaskRowCount();
    }
    @Override
    public List<Task> selectTask(){
        return taskDao.selectTask();
    }
    @Override
    public Task selectTaskByObj(Task obj){
        return taskDao.selectTaskByObj(obj);
    }
    @Override
    public Task selectTaskById(Long id){
        return taskDao.selectTaskById(id);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Task insertTask(Task value, TaskModel taskModel){
        if (!CollectionUtils.isEmpty(taskModel.getAppIds())) {
            List<VehicleInfo> vehicleInfoList = vehicleDao.selectVehicleByAppIds(taskModel.getAppIds());
            StringBuilder stringBuilder = new StringBuilder();
            HashMap<String, String> company = new HashMap<>(5);
            for (VehicleInfo vehicleInfo: vehicleInfoList) {
                if (company.get(vehicleInfo.getCompanyName()) == null) {
                    stringBuilder.append(vehicleInfo.getCompanyName());
                    stringBuilder.append(",");
                    company.put(vehicleInfo.getCompanyName(), "");
                }
            }
            String departments = stringBuilder.toString();
            value.setDepartments(departments.substring(0, departments.length()-1));
            value.setFinishedNumber(0);
            value.setPercent(0.0);
            taskDao.insertTask(value);
            insertTaskDetail(value.getId(), taskModel.getAppIds());
            updateAppsByIds(taskModel);
            return value;
        }
        throw new BDException("升级任务没有包含需要升级终端App");
    }

    private void updateAppsByIds(TaskModel taskModel) {
        App app = new App();
        app.setUpdateTime(new Date(System.currentTimeMillis()));
        app.setUpdateUser(Objects.requireNonNull(BaseApplicationController.currentUserDetails()).getUsername());
        app.setTs(new Date(System.currentTimeMillis()));
        app.setTargetVersionId(taskModel.getVersionId());
        app.setTargetVersionName(taskModel.getVersionName());
        appDao.batchUpdateApp(taskModel.getAppIds(), app);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchUpdateAppProtocol(App app, List<Long> appIds) {
        int result = appDao.batchUpdateApp(appIds, app);
        if (result != appIds.size()) {
            throw new BDException("批量更新App协议失败");
        }
    }

    @Override
    public List<Task> selectTaskByPageAndFilter(Pageable pageable, Task task) {
        
        return null;
    }

    private void insertTaskDetail(Long taskId, List<Long> appIds) {
        List<TaskDetail> taskDetails = new LinkedList<>();
        appIds.parallelStream().forEach(appId -> {
            TaskDetail taskDetail = new TaskDetail();
            taskDetail.setAppId(appId);
            taskDetail.setTaskId(taskId);
            taskDetails.add(taskDetail);
        });
        taskDetailDao.insertTaskDetailByBatch(taskDetails);
    }

    @Override
    public int insertNonEmptyTask(Task value){
        return taskDao.insertNonEmptyTask(value);
    }
    @Override
    public int insertTaskByBatch(List<Task> value){
        return taskDao.insertTaskByBatch(value);
    }
    @Override
    public int deleteTaskById(Long id){
        return taskDao.deleteTaskById(id);
    }
    @Override
    public int updateTaskById(Task enti){
        return taskDao.updateTaskById(enti);
    }
    @Override
    public int updateNonEmptyTaskById(Task enti){
        return taskDao.updateNonEmptyTaskById(enti);
    }

    @Override
    public int updateTask(Task task, TaskModel taskModel) {
        task.setId(taskModel.getTaskId());
        if (!StringUtils.isEmpty(taskModel.getTaskName())) {
            task.setTaskName(taskModel.getTaskName());
        }
        if (!StringUtils.isEmpty(taskModel.getRemark())) {
            task.setRemark(taskModel.getRemark());
        }
        if (!CollectionUtils.isEmpty(taskModel.getAppIds())) {
            updateAppsByIds(taskModel);
        }
        List<App> apps = appDao.selectAppByIds(taskModel.getAppIds());
        task.setFinishedNumber(Math.toIntExact(apps.parallelStream()
                .filter(app -> app.getVersionId().equals(app.getTargetVersionId())).count()));

        return taskDao.updateNonEmptyTaskById(task);
    }

    public TaskDao getTaskDao() {
        return this.taskDao;
    }

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

}