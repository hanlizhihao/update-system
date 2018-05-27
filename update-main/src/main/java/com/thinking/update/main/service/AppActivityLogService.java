package com.thinking.update.main.service;
import java.util.List;
import com.thinking.update.main.entity.AppActivityLog;
public interface AppActivityLogService{
	/**
	 * 获得AppActivityLog数据的总行数
	 * @return
	 */
    long getAppActivityLogRowCount();
	/**
	 * 获得AppActivityLog数据集合
	 * @return
	 */
    List<AppActivityLog> selectAppActivityLog();
	/**
	 * 获得一个AppActivityLog对象,以参数AppActivityLog对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AppActivityLog selectAppActivityLogByObj(AppActivityLog obj);
	/**
	 * 通过AppActivityLog的id获得AppActivityLog对象
	 * @param id
	 * @return
	 */
    AppActivityLog selectAppActivityLogById(Long id);
	/**
	 * 插入AppActivityLog到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAppActivityLog(AppActivityLog value);
	/**
	 * 插入AppActivityLog中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAppActivityLog(AppActivityLog value);
	/**
	 * 批量插入AppActivityLog到数据库
	 * @param value
	 * @return
	 */
    int insertAppActivityLogByBatch(List<AppActivityLog> value);
	/**
	 * 通过AppActivityLog的id删除AppActivityLog
	 * @param id
	 * @return
	 */
    int deleteAppActivityLogById(Long id);
	/**
	 * 通过AppActivityLog的id更新AppActivityLog中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAppActivityLogById(AppActivityLog enti);
	/**
	 * 通过AppActivityLog的id更新AppActivityLog中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAppActivityLogById(AppActivityLog enti);
}