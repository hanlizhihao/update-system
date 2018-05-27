package com.thinking.update.main.service.impl;
import java.util.List;
import com.thinking.update.main.dao.AppVersionLogDao;
import com.thinking.update.main.domain.entity.AppVersionLog;
import com.thinking.update.main.service.AppVersionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AppVersionLogServiceImpl implements AppVersionLogService{
    @Autowired
    private AppVersionLogDao appVersionLogDao;
    @Override
    public long getAppVersionLogRowCount(){
        return appVersionLogDao.getAppVersionLogRowCount();
    }
    @Override
    public List<AppVersionLog> selectAppVersionLog(){
        return appVersionLogDao.selectAppVersionLog();
    }
    @Override
    public AppVersionLog selectAppVersionLogByObj(AppVersionLog obj){
        return appVersionLogDao.selectAppVersionLogByObj(obj);
    }
    @Override
    public AppVersionLog selectAppVersionLogById(Long id){
        return appVersionLogDao.selectAppVersionLogById(id);
    }
    @Override
    public int insertAppVersionLog(AppVersionLog value){
        return appVersionLogDao.insertAppVersionLog(value);
    }
    @Override
    public int insertNonEmptyAppVersionLog(AppVersionLog value){
        return appVersionLogDao.insertNonEmptyAppVersionLog(value);
    }
    @Override
    public int insertAppVersionLogByBatch(List<AppVersionLog> value){
        return appVersionLogDao.insertAppVersionLogByBatch(value);
    }
    @Override
    public int deleteAppVersionLogById(Long id){
        return appVersionLogDao.deleteAppVersionLogById(id);
    }
    @Override
    public int updateAppVersionLogById(AppVersionLog enti){
        return appVersionLogDao.updateAppVersionLogById(enti);
    }
    @Override
    public int updateNonEmptyAppVersionLogById(AppVersionLog enti){
        return appVersionLogDao.updateNonEmptyAppVersionLogById(enti);
    }

    public AppVersionLogDao getAppVersionLogDao() {
        return this.appVersionLogDao;
    }

    public void setAppVersionLogDao(AppVersionLogDao appVersionLogDao) {
        this.appVersionLogDao = appVersionLogDao;
    }

}