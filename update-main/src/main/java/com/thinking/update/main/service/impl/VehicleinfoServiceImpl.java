package com.thinking.update.main.service.impl;
import java.util.List;
import com.thinking.update.main.dao.VehicleinfoDao;
import com.thinking.update.main.domain.entity.VehicleInfo;
import com.thinking.update.main.service.VehicleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VehicleinfoServiceImpl implements VehicleinfoService{
    @Autowired
    private VehicleinfoDao vehicleinfoDao;
    @Override
    public long getVehicleinfoRowCount(){
        return vehicleinfoDao.getVehicleinfoRowCount();
    }
    @Override
    public List<VehicleInfo> selectVehicleinfo(){
        return vehicleinfoDao.selectVehicleinfo();
    }
    @Override
    public VehicleInfo selectVehicleinfoByObj(VehicleInfo obj){
        return vehicleinfoDao.selectVehicleinfoByObj(obj);
    }
    @Override
    public VehicleInfo selectVehicleinfoById(Object id){
        return vehicleinfoDao.selectVehicleinfoById(id);
    }
    @Override
    public int insertVehicleinfo(VehicleInfo value){
        return vehicleinfoDao.insertVehicleinfo(value);
    }
    @Override
    public int insertNonEmptyVehicleinfo(VehicleInfo value){
        return vehicleinfoDao.insertNonEmptyVehicleinfo(value);
    }
    @Override
    public int insertVehicleinfoByBatch(List<VehicleInfo> value){
        return vehicleinfoDao.insertVehicleinfoByBatch(value);
    }
    @Override
    public int deleteVehicleinfoById(Object id){
        return vehicleinfoDao.deleteVehicleinfoById(id);
    }
    @Override
    public int updateVehicleinfoById(VehicleInfo enti){
        return vehicleinfoDao.updateVehicleinfoById(enti);
    }
    @Override
    public int updateNonEmptyVehicleinfoById(VehicleInfo enti){
        return vehicleinfoDao.updateNonEmptyVehicleinfoById(enti);
    }

    public VehicleinfoDao getVehicleinfoDao() {
        return this.vehicleinfoDao;
    }

    public void setVehicleinfoDao(VehicleinfoDao vehicleinfoDao) {
        this.vehicleinfoDao = vehicleinfoDao;
    }

}