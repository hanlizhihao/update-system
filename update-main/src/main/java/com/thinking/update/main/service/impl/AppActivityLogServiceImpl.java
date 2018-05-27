package com.thinking.update.main.service.impl;
import java.util.List;
import com.thinking.update.main.dao.AppActivityLogDao;
import com.thinking.update.main.entity.AppActivityLog;
import com.thinking.update.main.service.AppActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AppActivityLogServiceImpl implements AppActivityLogService{
    @Autowired
    private AppActivityLogDao appActivityLogDao;
    @Override
    public long getAppActivityLogRowCount(){
        return appActivityLogDao.getAppActivityLogRowCount();
    }
    @Override
    public List<AppActivityLog> selectAppActivityLog(){
        return appActivityLogDao.selectAppActivityLog();
    }
    @Override
    public AppActivityLog selectAppActivityLogByObj(AppActivityLog obj){
        return appActivityLogDao.selectAppActivityLogByObj(obj);
    }
    @Override
    public AppActivityLog selectAppActivityLogById(Long id){
        return appActivityLogDao.selectAppActivityLogById(id);
    }
    @Override
    public int insertAppActivityLog(AppActivityLog value){
        return appActivityLogDao.insertAppActivityLog(value);
    }
    @Override
    public int insertNonEmptyAppActivityLog(AppActivityLog value){
        return appActivityLogDao.insertNonEmptyAppActivityLog(value);
    }
    @Override
    public int insertAppActivityLogByBatch(List<AppActivityLog> value){
        return appActivityLogDao.insertAppActivityLogByBatch(value);
    }
    @Override
    public int deleteAppActivityLogById(Long id){
        return appActivityLogDao.deleteAppActivityLogById(id);
    }
    @Override
    public int updateAppActivityLogById(AppActivityLog enti){
        return appActivityLogDao.updateAppActivityLogById(enti);
    }
    @Override
    public int updateNonEmptyAppActivityLogById(AppActivityLog enti){
        return appActivityLogDao.updateNonEmptyAppActivityLogById(enti);
    }

    public AppActivityLogDao getAppActivityLogDao() {
        return this.appActivityLogDao;
    }

    public void setAppActivityLogDao(AppActivityLogDao appActivityLogDao) {
        this.appActivityLogDao = appActivityLogDao;
    }

}