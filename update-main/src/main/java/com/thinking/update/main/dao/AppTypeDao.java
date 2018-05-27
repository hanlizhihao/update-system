package com.thinking.update.main.dao;
import com.thinking.update.main.domain.entity.AppType;
import java.util.List;
public interface AppTypeDao{
	/**
	 * 获得AppType数据的总行数
	 * @return
	 */
    long getAppTypeRowCount();
	/**
	 * 获得AppType数据集合
	 * @return
	 */
    List<AppType> selectAppType();
	/**
	 * 获得一个AppType对象,以参数AppType对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AppType selectAppTypeByObj(AppType obj);
	/**
	 * 通过AppType的id获得AppType对象
	 * @param id
	 * @return
	 */
    AppType selectAppTypeById(Long id);
	/**
	 * 插入AppType到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAppType(AppType value);
	/**
	 * 插入AppType中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAppType(AppType value);
	/**
	 * 批量插入AppType到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAppTypeByBatch(List<AppType> value);
	/**
	 * 通过AppType的id删除AppType
	 * @param id
	 * @return
	 */
    int deleteAppTypeById(Long id);
	/**
	 * 通过AppType的id更新AppType中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAppTypeById(AppType enti);
	/**
	 * 通过AppType的id更新AppType中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAppTypeById(AppType enti);
}