package com.thinking.update.main.service.impl;
import java.util.List;
import com.thinking.update.main.dao.TaskDao;
import com.thinking.update.main.entity.Task;
import com.thinking.update.main.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskDao taskDao;
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
    public int insertTask(Task value){
        return taskDao.insertTask(value);
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

    public TaskDao getTaskDao() {
        return this.taskDao;
    }

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

}