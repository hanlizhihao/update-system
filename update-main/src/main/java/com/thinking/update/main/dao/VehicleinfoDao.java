package com.thinking.update.main.dao;

import com.thinking.update.main.entity.Vehicleinfo;

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
    List<Vehicleinfo> selectVehicleinfo();
	/**
	 * 获得一个Vehicleinfo对象,以参数Vehicleinfo对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Vehicleinfo selectVehicleinfoByObj(Vehicleinfo obj);
	/**
	 * 通过Vehicleinfo的id获得Vehicleinfo对象
	 * @param id
	 * @return
	 */
    Vehicleinfo selectVehicleinfoById(Integer id);
	/**
	 * 插入Vehicleinfo到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertVehicleinfo(Vehicleinfo value);
	/**
	 * 插入Vehicleinfo中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyVehicleinfo(Vehicleinfo value);
	/**
	 * 批量插入Vehicleinfo到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertVehicleinfoByBatch(List<Vehicleinfo> value);
	/**
	 * 通过Vehicleinfo的id删除Vehicleinfo
	 * @param id
	 * @return
	 */
    int deleteVehicleinfoById(Integer id);
	/**
	 * 通过Vehicleinfo的id更新Vehicleinfo中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateVehicleinfoById(Vehicleinfo enti);
	/**
	 * 通过Vehicleinfo的id更新Vehicleinfo中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyVehicleinfoById(Vehicleinfo enti);
}