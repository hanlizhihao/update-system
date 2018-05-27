package com.thinking.update.main.service;
import java.util.List;
import com.thinking.update.main.entity.AppVersionLog;
public interface AppVersionLogService{
	/**
	 * 获得AppVersionLog数据的总行数
	 * @return
	 */
    long getAppVersionLogRowCount();
	/**
	 * 获得AppVersionLog数据集合
	 * @return
	 */
    List<AppVersionLog> selectAppVersionLog();
	/**
	 * 获得一个AppVersionLog对象,以参数AppVersionLog对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AppVersionLog selectAppVersionLogByObj(AppVersionLog obj);
	/**
	 * 通过AppVersionLog的id获得AppVersionLog对象
	 * @param id
	 * @return
	 */
    AppVersionLog selectAppVersionLogById(Long id);
	/**
	 * 插入AppVersionLog到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAppVersionLog(AppVersionLog value);
	/**
	 * 插入AppVersionLog中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAppVersionLog(AppVersionLog value);
	/**
	 * 批量插入AppVersionLog到数据库
	 * @param value
	 * @return
	 */
    int insertAppVersionLogByBatch(List<AppVersionLog> value);
	/**
	 * 通过AppVersionLog的id删除AppVersionLog
	 * @param id
	 * @return
	 */
    int deleteAppVersionLogById(Long id);
	/**
	 * 通过AppVersionLog的id更新AppVersionLog中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAppVersionLogById(AppVersionLog enti);
	/**
	 * 通过AppVersionLog的id更新AppVersionLog中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAppVersionLogById(AppVersionLog enti);
}