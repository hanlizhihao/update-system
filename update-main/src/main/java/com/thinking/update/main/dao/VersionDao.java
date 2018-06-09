package com.thinking.update.main.dao;
import com.thinking.update.main.common.utils.MybatisRedisCache;
import com.thinking.update.main.domain.entity.Version;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;
/**
 * @author Administrator
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface VersionDao{
	/**
	 * 获得Version数据的总行数
	 * @return
	 */
    long getVersionRowCount();
	/**
	 * 获得Version数据集合
	 * @return
	 */
    List<Version> selectVersion();
	/**
	 * 获得一个Version对象,以参数Version对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    List<Version> selectVersionByObj(Version obj);
	/**
	 * 通过Version的id获得Version对象
	 * @param id
	 * @return
	 */
    Version selectVersionById(Long id);
	/**
	 * 插入Version到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertVersion(Version value);
	/**
	 * 插入Version中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyVersion(Version value);
	/**
	 * 批量插入Version到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertVersionByBatch(List<Version> value);
	/**
	 * 通过Version的id删除Version
	 * @param id
	 * @return
	 */
    int deleteVersionById(Long id);
	/**
	 * 通过Version的id更新Version中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateVersionById(Version enti);
	/**
	 * 通过Version的id更新Version中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyVersionById(Version enti);
}