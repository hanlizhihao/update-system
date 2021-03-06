package com.thinking.update.main.dao;
import com.thinking.update.main.common.utils.MybatisRedisCache;
import com.thinking.update.main.domain.entity.Task;
import com.thinking.update.main.domain.entity.TaskDetail;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author Administrator
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface TaskDetailDao{
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
    List<TaskDetail> selectTaskDetailByObj(TaskDetail obj);

	/**
	 * 获取正在进行的任务的所有详情
	 * @param ids
	 * @return
	 */
	List<TaskDetail> selectByTaskIds(@Param("ids") List<Task> ids);

	/**
	 * 查询正在进行的Task是否包含指定id的App
	 * @param id
	 * @return
	 */
	List<TaskDetail> selectRunningTaskDetailByAppId(Long id);
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
	 * 批量插入TaskDetail到数据库,包括null值
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

	/**
	 * 批量更新Detail
	 * @param list
	 * @return
	 */
	int updateTaskDetailByBatch(List<TaskDetail> list);

}