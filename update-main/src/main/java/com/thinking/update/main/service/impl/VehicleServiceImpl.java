package com.thinking.update.main.service.impl;
import com.thinking.update.main.dao.VehicleDao;
import com.thinking.update.main.domain.entity.VehicleInfo;
import com.thinking.update.main.service.VehicleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class VehicleServiceImpl implements VehicleService {
    @Resource
    private VehicleDao vehicleDao;

    @Override
    public long getVehicleRowCount(){
        return vehicleDao.getVehicleRowCount();
    }
    @Override
    public List<VehicleInfo> selectVehicle(){
        return vehicleDao.selectVehicle();
    }
    @Override
    public int insertVehicle(VehicleInfo value){
        return vehicleDao.insertVehicleinfo(value);
    }
    @Override
    public int insertNonEmptyVehicle(VehicleInfo value){
        return vehicleDao.insertNonEmptyVehicleinfo(value);
    }
    @Override
    public int insertVehicleByBatch(List<VehicleInfo> value){
        return vehicleDao.insertVehicleinfoByBatch(value);
    }
    @Override
    public int deleteVehicleById(Object id){
        return vehicleDao.deleteVehicleinfoById(id);
    }
    @Override
    public int updateVehicleById(VehicleInfo enti){
        return vehicleDao.updateVehicleinfoById(enti);
    }
    @Override
    public int updateNonEmptyVehicleById(VehicleInfo enti){
        return vehicleDao.updateNonEmptyVehicleinfoById(enti);
    }

    @Override
    public List<Integer> getDeviceIdsByDepartId(Long id) {
        return null;
    }

    public VehicleDao getVehicleDao() {
        return this.vehicleDao;
    }

    public void setVehicleDao(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

}