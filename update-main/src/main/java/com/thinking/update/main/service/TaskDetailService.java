package com.thinking.update.main.service;
import java.util.List;
import com.thinking.update.main.domain.entity.TaskDetail;
public interface TaskDetailService{
	/**
	 * 获得TaskDetail数据的总行数
	 * @return
	 */
    long getTaskDetailRowCount();
	/**
	 * 获得TaskDetail数据集合
	 * @return
	 */
    List<TaskDetail> selectTaskDetail();
	/**
	 * 获得一个TaskDetail对象,以参数TaskDetail对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    TaskDetail selectTaskDetailByObj(TaskDetail obj);
	/**
	 * 通过TaskDetail的id获得TaskDetail对象
	 * @param id
	 * @return
	 */
    TaskDetail selectTaskDetailById(Long id);
	/**
	 * 插入TaskDetail到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertTaskDetail(TaskDetail value);
	/**
	 * 插入TaskDetail中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyTaskDetail(TaskDetail value);
	/**
	 * 批量插入TaskDetail到数据库
	 * @param value
	 * @return
	 */
    int insertTaskDetailByBatch(List<TaskDetail> value);
	/**
	 * 通过TaskDetail的id删除TaskDetail
	 * @param id
	 * @return
	 */
    int deleteTaskDetailById(Long id);
	/**
	 * 通过TaskDetail的id更新TaskDetail中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateTaskDetailById(TaskDetail enti);
	/**
	 * 通过TaskDetail的id更新TaskDetail中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyTaskDetailById(TaskDetail enti);
}