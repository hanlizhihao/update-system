package com.thinking.update.main.service.impl;
import java.util.List;
import com.thinking.update.main.dao.AppDao;
import com.thinking.update.main.entity.App;
import com.thinking.update.main.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AppServiceImpl implements AppService{
    @Autowired
    private AppDao appDao;
    @Override
    public long getAppRowCount(){
        return appDao.getAppRowCount();
    }
    @Override
    public List<App> selectApp(){
        return appDao.selectApp();
    }
    @Override
    public App selectAppByObj(App obj){
        return appDao.selectAppByObj(obj);
    }
    @Override
    public App selectAppById(Long id){
        return appDao.selectAppById(id);
    }
    @Override
    public int insertApp(App value){
        return appDao.insertApp(value);
    }
    @Override
    public int insertNonEmptyApp(App value){
        return appDao.insertNonEmptyApp(value);
    }
    @Override
    public int insertAppByBatch(List<App> value){
        return appDao.insertAppByBatch(value);
    }
    @Override
    public int deleteAppById(Long id){
        return appDao.deleteAppById(id);
    }
    @Override
    public int updateAppById(App enti){
        return appDao.updateAppById(enti);
    }
    @Override
    public int updateNonEmptyAppById(App enti){
        return appDao.updateNonEmptyAppById(enti);
    }

    public AppDao getAppDao() {
        return this.appDao;
    }

    public void setAppDao(AppDao appDao) {
        this.appDao = appDao;
    }

}