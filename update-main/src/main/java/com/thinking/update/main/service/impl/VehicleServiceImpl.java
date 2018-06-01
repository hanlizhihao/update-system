package com.thinking.update.main.service.impl;
import com.thinking.update.main.dao.VehicleinfoDao;
import com.thinking.update.main.domain.entity.MauthDept;
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
    private VehicleinfoDao vehicleinfoDao;
    @Override
    public long getVehicleRowCount(){
        return vehicleinfoDao.getVehicleinfoRowCount();
    }
    @Override
    public List<VehicleInfo> selectVehicle(){
        return vehicleinfoDao.selectVehicleinfo();
    }
    @Override
    public VehicleInfo selectVehicleByObj(VehicleInfo obj){
        return vehicleinfoDao.selectVehicleinfoByObj(obj);
    }
    @Override
    public VehicleInfo selectVehicleById(Object id){
        return vehicleinfoDao.selectVehicleinfoById(id);
    }
    @Override
    public int insertVehicle(VehicleInfo value){
        return vehicleinfoDao.insertVehicleinfo(value);
    }
    @Override
    public int insertNonEmptyVehicle(VehicleInfo value){
        return vehicleinfoDao.insertNonEmptyVehicleinfo(value);
    }
    @Override
    public int insertVehicleByBatch(List<VehicleInfo> value){
        return vehicleinfoDao.insertVehicleinfoByBatch(value);
    }
    @Override
    public int deleteVehicleById(Object id){
        return vehicleinfoDao.deleteVehicleinfoById(id);
    }
    @Override
    public int updateVehicleById(VehicleInfo enti){
        return vehicleinfoDao.updateVehicleinfoById(enti);
    }
    @Override
    public int updateNonEmptyVehicleById(VehicleInfo enti){
        return vehicleinfoDao.updateNonEmptyVehicleinfoById(enti);
    }

    @Override
    public List<MauthDept> getOneChildrenLevelById(Long id) {

        return null;
    }

    @Override
    public List<Integer> getDeviceIdsByDepartId(Long id) {
        return null;
    }

    public VehicleinfoDao getVehicleinfoDao() {
        return this.vehicleinfoDao;
    }

    public void setVehicleinfoDao(VehicleinfoDao vehicleinfoDao) {
        this.vehicleinfoDao = vehicleinfoDao;
    }

}