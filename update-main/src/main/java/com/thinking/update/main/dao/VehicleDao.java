package com.thinking.update.main.dao;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.entity.VehicleInfo;
import java.util.List;
/**
 * @author Administrator
 */
public interface VehicleDao {
	/**
	 * 获得Vehicleinfo数据的总行数
	 * @return
	 */
    long getVehicleRowCount();
	/**
	 * 获得Vehicleinfo数据集合
	 * @return
	 */
    List<VehicleInfo> selectVehicle();

    List<VehicleInfo> selectVehicleByAppIds(List<Long> appIds);

	/**
	 * 通过app获取车辆信息列表
	 * @param apps
	 * @return
	 */

	List<VehicleInfo> selectByApps(List<App> apps);
	/**
	 * 获得一个Vehicleinfo对象,以参数Vehicleinfo对象中不为空的属性作为条件进行查询
	 * @param apps 参数app
	 * @return
	 */
    List<VehicleInfo> selectAllColumnByApps(List<App> apps);

	/**
	 * 根据App查询车辆信息
	 * @param app
	 * @return
	 */
	VehicleInfo selectByApp(App app);
	/**
	 * 通过Vehicleinfo的id获得Vehicleinfo对象
	 * @param id
	 * @return
	 */
    List<VehicleInfo> selectVehicleByDeptId(Integer id);
	/**
	 * 插入Vehicleinfo到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertVehicleinfo(VehicleInfo value);
	/**
	 * 插入Vehicleinfo中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyVehicleinfo(VehicleInfo value);
	/**
	 * 批量插入Vehicleinfo到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertVehicleinfoByBatch(List<VehicleInfo> value);
	/**
	 * 通过Vehicleinfo的id删除Vehicleinfo
	 * @param id
	 * @return
	 */
    int deleteVehicleinfoById(Object id);
	/**
	 * 通过Vehicleinfo的id更新Vehicleinfo中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateVehicleinfoById(VehicleInfo enti);
	/**
	 * 通过Vehicleinfo的id更新Vehicleinfo中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyVehicleinfoById(VehicleInfo enti);
}