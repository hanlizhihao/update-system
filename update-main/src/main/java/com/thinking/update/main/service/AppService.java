package com.thinking.update.main.service;
import java.util.List;
import com.thinking.update.main.entity.App;
public interface AppService{
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
	 * 获得一个App对象,以参数App对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    App selectAppByObj(App obj);
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
	 * 批量插入App到数据库
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
}