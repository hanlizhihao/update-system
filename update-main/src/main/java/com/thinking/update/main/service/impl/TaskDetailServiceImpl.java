package com.thinking.update.main.service.impl;
import java.util.List;
import com.thinking.update.main.dao.TaskDetailDao;
import com.thinking.update.main.domain.entity.TaskDetail;
import com.thinking.update.main.service.TaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author Administrator
 */
@Service
public class TaskDetailServiceImpl implements TaskDetailService{
    @Autowired
    private TaskDetailDao taskDetailDao;
    @Override
    public long getTaskDetailRowCount(){
        return taskDetailDao.getTaskDetailRowCount();
    }
    @Override
    public List<TaskDetail> selectTaskDetail(){
        return taskDetailDao.selectTaskDetail();
    }
    @Override
    public List<TaskDetail> selectTaskDetailByObj(TaskDetail obj){
        return taskDetailDao.selectTaskDetailByObj(obj);
    }
    @Override
    public TaskDetail selectTaskDetailById(Long id){
        return taskDetailDao.selectTaskDetailById(id);
    }
    @Override
    public int insertTaskDetail(TaskDetail value){
        return taskDetailDao.insertTaskDetail(value);
    }
    @Override
    public int insertNonEmptyTaskDetail(TaskDetail value){
        return taskDetailDao.insertNonEmptyTaskDetail(value);
    }
    @Override
    public int insertTaskDetailByBatch(List<TaskDetail> value){
        return taskDetailDao.insertTaskDetailByBatch(value);
    }
    @Override
    public int deleteTaskDetailById(Long id){
        return taskDetailDao.deleteTaskDetailById(id);
    }
    @Override
    public int updateTaskDetailById(TaskDetail enti){
        return taskDetailDao.updateTaskDetailById(enti);
    }
    @Override
    public int updateNonEmptyTaskDetailById(TaskDetail enti){
        return taskDetailDao.updateNonEmptyTaskDetailById(enti);
    }

    public TaskDetailDao getTaskDetailDao() {
        return this.taskDetailDao;
    }

    public void setTaskDetailDao(TaskDetailDao taskDetailDao) {
        this.taskDetailDao = taskDetailDao;
    }

}