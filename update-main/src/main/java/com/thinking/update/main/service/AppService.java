package com.thinking.update.main.service;
import java.util.List;

import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.model.EnumVo;
import org.springframework.data.domain.Pageable;

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
	 * @param obj 筛选条件
	 * @param pageable page页码,size单页数量
	 * @param deviceIds 树形菜单选择的设备Id数组
	 * @return
	 */
	List<App> selectAppByPageAndFilter(Pageable pageable, App obj, List<Long> deviceIds);

	/**
	 * 获得一个App对象,以参数App对象中不为空的属性作为条件进行查询
	 * @param pageable page页码,size单页数量
	 * @param deviceIds 树形菜单选择的设备Id数组
	 * @return
	 */
	List<App> selectAbnormalPageBydeviceIds(Pageable pageable, List<Long> deviceIds);
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
    App insertApp(App value);
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

    List<EnumVo> getDeviceList();
}