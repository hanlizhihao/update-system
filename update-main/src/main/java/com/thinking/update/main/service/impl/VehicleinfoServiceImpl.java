package com.thinking.update.main.service.impl;

import com.thinking.update.main.dao.VehicleinfoDao;
import com.thinking.update.main.entity.Vehicleinfo;
import com.thinking.update.main.service.VehicleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleinfoServiceImpl implements VehicleinfoService{
    @Autowired
    private VehicleinfoDao vehicleinfoDao;
    @Override
    public long getVehicleinfoRowCount(){
        return vehicleinfoDao.getVehicleinfoRowCount();
    }
    @Override
    public List<Vehicleinfo> selectVehicleinfo(){
        return vehicleinfoDao.selectVehicleinfo();
    }
    @Override
    public Vehicleinfo selectVehicleinfoByObj(Vehicleinfo obj){
        return vehicleinfoDao.selectVehicleinfoByObj(obj);
    }
    @Override
    public Vehicleinfo selectVehicleinfoById(Integer id){
        return vehicleinfoDao.selectVehicleinfoById(id);
    }
    @Override
    public int insertVehicleinfo(Vehicleinfo value){
        return vehicleinfoDao.insertVehicleinfo(value);
    }
    @Override
    public int insertNonEmptyVehicleinfo(Vehicleinfo value){
        return vehicleinfoDao.insertNonEmptyVehicleinfo(value);
    }
    @Override
    public int insertVehicleinfoByBatch(List<Vehicleinfo> value){
        return vehicleinfoDao.insertVehicleinfoByBatch(value);
    }
    @Override
    public int deleteVehicleinfoById(Integer id){
        return vehicleinfoDao.deleteVehicleinfoById(id);
    }
    @Override
    public int updateVehicleinfoById(Vehicleinfo enti){
        return vehicleinfoDao.updateVehicleinfoById(enti);
    }
    @Override
    public int updateNonEmptyVehicleinfoById(Vehicleinfo enti){
        return vehicleinfoDao.updateNonEmptyVehicleinfoById(enti);
    }

    public VehicleinfoDao getVehicleinfoDao() {
        return this.vehicleinfoDao;
    }

    public void setVehicleinfoDao(VehicleinfoDao vehicleinfoDao) {
        this.vehicleinfoDao = vehicleinfoDao;
    }

}