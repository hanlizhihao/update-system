package com.thinking.update.main.dao;
import com.thinking.update.main.domain.entity.App;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface AppDao{
	/**
	 * 获得App数据的总行数
	 * @return
	 */
    long getAppRowCount();
	/**
	 * 获得App数据集合
	 * @return
	 */
    List<App> selectApp();

	/**
	 * 根据id获取所有App
	 * @param ids
	 * @return
	 */
	List<App> selectAppByIds(List<Long> ids);
	/**
	 * 获得一个App对象,以参数App对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    List<App> selectAppByObj(App obj);

	/**
	 * 带过滤条件的分页查询
	 * @param obj
	 * @return
	 */
	List<App> filterAppByObj(App obj);

	/**
	 * 带过滤条件的分页查询
	 * @param obj App
	 * @param deviceIds ids数组
	 * @return
	 */
	List<App> getAppForPageByObjAndDeviceIds(@Param("obj") App obj, @Param("deviceIds") List<Long> deviceIds);

	/**
	 * 基于deviceIds以及异常状态集合来查询
	 * @param states 异常状态列表
	 * @param deviceIds ids数组
	 * @return
	 */
	List<App> getAppForPageByDeviceIdsAndStateList(@Param("states") List<Integer> states,
												   @Param("deviceIds") List<Long> deviceIds);
	/**
	 * 通过App的id获得App对象
	 * @param id
	 * @return
	 */
    App selectAppById(Long id);
	/**
	 * 插入App到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertApp(App value);
	/**
	 * 插入App中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyApp(App value);
	/**
	 * 批量插入App到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAppByBatch(List<App> value);
	/**
	 * 通过App的id删除App
	 * @param id
	 * @return
	 */
    int deleteAppById(Long id);
	/**
	 * 通过App的id更新App中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAppById(App enti);
	/**
	 * 通过App的id更新App中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAppById(App enti);

	/**
	 * 批量更新协议版本
	 * @param ids 需要更新的App
	 * @param app 更新成为目标值
	 * @return 更新数量
	 */
    int batchUpdateAppsForIdsByApp(@Param("ids") List<Long> ids, @Param("app") App app);

	/**
	 * 批量更新
	 * @param list
	 * @return
	 */
	int batchUpdate(List<App> list);
}