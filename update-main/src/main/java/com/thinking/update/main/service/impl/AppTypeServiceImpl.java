package com.thinking.update.main.service.impl;
import java.util.List;
import com.thinking.update.main.dao.AppTypeDao;
import com.thinking.update.main.domain.entity.AppType;
import com.thinking.update.main.service.AppTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AppTypeServiceImpl implements AppTypeService{
    @Autowired
    private AppTypeDao appTypeDao;
    @Override
    public long getAppTypeRowCount(){
        return appTypeDao.getAppTypeRowCount();
    }
    @Override
    public List<AppType> selectAppType(){
        return appTypeDao.selectAppType();
    }
    @Override
    public AppType selectAppTypeByObj(AppType obj){
        return appTypeDao.selectAppTypeByObj(obj);
    }
    @Override
    public AppType selectAppTypeById(Long id){
        return appTypeDao.selectAppTypeById(id);
    }
    @Override
    public int insertAppType(AppType value){
        return appTypeDao.insertAppType(value);
    }
    @Override
    public int insertNonEmptyAppType(AppType value){
        return appTypeDao.insertNonEmptyAppType(value);
    }
    @Override
    public int insertAppTypeByBatch(List<AppType> value){
        return appTypeDao.insertAppTypeByBatch(value);
    }
    @Override
    public int deleteAppTypeById(Long id){
        return appTypeDao.deleteAppTypeById(id);
    }
    @Override
    public int updateAppTypeById(AppType enti){
        return appTypeDao.updateAppTypeById(enti);
    }
    @Override
    public int updateNonEmptyAppTypeById(AppType enti){
        return appTypeDao.updateNonEmptyAppTypeById(enti);
    }

    public AppTypeDao getAppTypeDao() {
        return this.appTypeDao;
    }

    public void setAppTypeDao(AppTypeDao appTypeDao) {
        this.appTypeDao = appTypeDao;
    }

}