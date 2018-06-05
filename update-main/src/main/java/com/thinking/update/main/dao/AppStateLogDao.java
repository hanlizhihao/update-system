package com.thinking.update.main.dao;
import com.thinking.update.main.domain.entity.AppStateLog;
import java.util.List;
public interface AppStateLogDao{
	/**
	 * 获得AppStateLog数据的总行数
	 * @return
	 */
    long getAppStateLogRowCount();
	/**
	 * 获得AppStateLog数据集合
	 * @return
	 */
    List<AppStateLog> selectAppStateLog();
	/**
	 * 获得一个AppStateLog对象,以参数AppStateLog对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AppStateLog selectAppStateLogByObj(AppStateLog obj);

	/**
	 * 查找最新的上一个状态是正常，当前状态是异常的日志
	 * @param appId
	 * @return
	 */
	AppStateLog selectLatestLastStateIsNormalLogByAppId(Long appId);
	/**
	 * 查找最新的上一个状态是正常，当前状态是异常的日志
	 * @param appId
	 * @return
	 */
	AppStateLog selectNormalStateLogByAppId(Long appId);

	/**
	 * 通过AppStateLog的id获得AppStateLog对象
	 * @param id
	 * @return
	 */
    AppStateLog selectAppStateLogById(Long id);
	/**
	 * 插入AppStateLog到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAppStateLog(AppStateLog value);
	/**
	 * 插入AppStateLog中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAppStateLog(AppStateLog value);
	/**
	 * 批量插入AppStateLog到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAppStateLogByBatch(List<AppStateLog> value);
	/**
	 * 通过AppStateLog的id删除AppStateLog
	 * @param id
	 * @return
	 */
    int deleteAppStateLogById(Long id);
	/**
	 * 通过AppStateLog的id更新AppStateLog中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAppStateLogById(AppStateLog enti);
	/**
	 * 通过AppStateLog的id更新AppStateLog中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAppStateLogById(AppStateLog enti);
}