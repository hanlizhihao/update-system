package com.thinking.update.main.dao;
import com.thinking.update.main.common.utils.MybatisRedisCache;
import com.thinking.update.main.domain.entity.Task;
import com.thinking.update.main.domain.model.TaskVo;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;
/**
 * @author Administrator
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface TaskDao{
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
	 * 基于Task做like模糊查询
	 * @param obj
	 * @return
	 */
	List<TaskVo> filterTaskByObj(Task obj);
	/**
	 * 通过Task的id获得Task对象
	 * @param id
	 * @return
	 */
    Task selectTaskById(Long id);
	/**
	 * 插入Task到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertTask(Task value);
	/**
	 * 插入Task中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyTask(Task value);
	/**
	 * 批量插入Task到数据库,包括null值
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
}