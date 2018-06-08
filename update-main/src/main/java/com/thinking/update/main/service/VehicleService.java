package com.thinking.update.main.service;
import java.util.List;

import com.thinking.update.main.domain.entity.MauthDept;
import com.thinking.update.main.domain.entity.VehicleInfo;
/**
 * @author Administrator
 */
public interface VehicleService {
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
	/**
	 * 通过Vehicleinfo的id获得Vehicleinfo对象
	 * @param id
	 * @return
	 */
    VehicleInfo selectVehicleById(Object id);
	/**
	 * 插入Vehicleinfo到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertVehicle(VehicleInfo value);
	/**
	 * 插入Vehicleinfo中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyVehicle(VehicleInfo value);
	/**
	 * 批量插入Vehicleinfo到数据库
	 * @param value
	 * @return
	 */
    int insertVehicleByBatch(List<VehicleInfo> value);
	/**
	 * 通过Vehicleinfo的id删除Vehicleinfo
	 * @param id
	 * @return
	 */
    int deleteVehicleById(Object id);
	/**
	 * 通过Vehicleinfo的id更新Vehicleinfo中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateVehicleById(VehicleInfo enti);
	/**
	 * 通过Vehicleinfo的id更新Vehicleinfo中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyVehicleById(VehicleInfo enti);

    List<Integer> getDeviceIdsByDepartId(Long id);
}