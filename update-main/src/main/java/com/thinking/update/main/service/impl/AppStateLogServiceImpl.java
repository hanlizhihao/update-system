package com.thinking.update.main.service.impl;
import java.util.List;
import com.thinking.update.main.dao.AppStateLogDao;
import com.thinking.update.main.domain.entity.AppStateLog;
import com.thinking.update.main.service.AppStateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AppStateLogServiceImpl implements AppStateLogService{
    @Autowired
    private AppStateLogDao appStateLogDao;
    @Override
    public long getAppStateLogRowCount(){
        return appStateLogDao.getAppStateLogRowCount();
    }
    @Override
    public List<AppStateLog> selectAppStateLog(){
        return appStateLogDao.selectAppStateLog();
    }
    @Override
    public AppStateLog selectAppStateLogByObj(AppStateLog obj){
        return appStateLogDao.selectAppStateLogByObj(obj);
    }
    @Override
    public AppStateLog selectAppStateLogById(Long id){
        return appStateLogDao.selectAppStateLogById(id);
    }
    @Override
    public int insertAppStateLog(AppStateLog value){
        return appStateLogDao.insertAppStateLog(value);
    }
    @Override
    public int insertNonEmptyAppStateLog(AppStateLog value){
        return appStateLogDao.insertNonEmptyAppStateLog(value);
    }
    @Override
    public int insertAppStateLogByBatch(List<AppStateLog> value){
        return appStateLogDao.insertAppStateLogByBatch(value);
    }
    @Override
    public int deleteAppStateLogById(Long id){
        return appStateLogDao.deleteAppStateLogById(id);
    }
    @Override
    public int updateAppStateLogById(AppStateLog enti){
        return appStateLogDao.updateAppStateLogById(enti);
    }
    @Override
    public int updateNonEmptyAppStateLogById(AppStateLog enti){
        return appStateLogDao.updateNonEmptyAppStateLogById(enti);
    }

    public AppStateLogDao getAppStateLogDao() {
        return this.appStateLogDao;
    }

    public void setAppStateLogDao(AppStateLogDao appStateLogDao) {
        this.appStateLogDao = appStateLogDao;
    }

}