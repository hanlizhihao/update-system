package com.thinking.update.main.service;
import java.util.List;

import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.entity.Task;
import com.thinking.update.main.domain.model.TaskModel;
import com.thinking.update.main.domain.model.TaskVo;
import org.springframework.data.domain.Pageable;

public interface TaskService{
	/**
	 * 获得Task数据的总行数
	 * @return
	 */
    long getTaskRowCount();
	/**
	 * 获得Task数据集合
	 * @return
	 */
    List<Task> selectTask();
	/**
	 * 获得一个Task对象,以参数Task对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    List<Task> selectTaskByObj(Task obj);
	/**
	 * 通过Task的id获得Task对象
	 * @param id
	 * @return
	 */
    Task selectTaskById(Long id);
	/**
	 * 插入Task到数据库,包括null值
	 * @param value
	 * @param taskModel
	 * @return
	 */
    Task insertTask(Task value, TaskModel taskModel);

	/**
	 * 批量更新App
	 * @param app
	 * @param appIds
	 */
    void batchUpdateAppProtocol(App app, List<Long> appIds);

	/**
	 * 查询分页任务
	 * @param pageable
	 * @param task
	 * @return
	 */
	List<TaskVo> selectTaskByPageAndFilter(Pageable pageable, Task task);
	/**
	 * 插入Task中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyTask(Task value);
	/**
	 * 批量插入Task到数据库
	 * @param value
	 * @return
	 */
    int insertTaskByBatch(List<Task> value);
	/**
	 * 通过Task的id删除Task
	 * @param id
	 * @return
	 */
    int deleteTaskById(Long id);
	/**
	 * 通过Task的id更新Task中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateTaskById(Task enti);
	/**
	 * 通过Task的id更新Task中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyTaskById(Task enti);

	/**
	 * 更新任务
	 * @param taskModel
	 * @return
	 */
	int updateTask(Task task, TaskModel taskModel);
}