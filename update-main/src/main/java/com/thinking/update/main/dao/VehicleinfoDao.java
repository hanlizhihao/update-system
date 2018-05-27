package com.thinking.update.main.dao;
import com.thinking.update.main.domain.entity.VehicleInfo;
import java.util.List;
public interface VehicleinfoDao{
	/**
	 * 获得Vehicleinfo数据的总行数
	 * @return
	 */
    long getVehicleinfoRowCount();
	/**
	 * 获得Vehicleinfo数据集合
	 * @return
	 */
    List<VehicleInfo> selectVehicleinfo();
	/**
	 * 获得一个Vehicleinfo对象,以参数Vehicleinfo对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    VehicleInfo selectVehicleinfoByObj(VehicleInfo obj);
	/**
	 * 通过Vehicleinfo的id获得Vehicleinfo对象
	 * @param id
	 * @return
	 */
    VehicleInfo selectVehicleinfoById(Object id);
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