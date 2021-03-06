package com.thinking.update.main.dao;
import com.thinking.update.main.common.utils.MybatisRedisCache;
import com.thinking.update.main.domain.entity.AppVersionLog;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;
/**
 * @author Administrator
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface AppVersionLogDao{
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

    AppVersionLog selectOneByObj(AppVersionLog log);
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
	 * 批量插入AppVersionLog到数据库,包括null值
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