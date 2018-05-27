package com.thinking.update.main.service.impl;
import java.util.List;

import com.thinking.update.main.common.enums.AppRunningStateEnum;
import com.thinking.update.main.common.enums.AppUpdateStateEnum;
import com.thinking.update.main.common.enums.VersionManageStateEnum;
import com.thinking.update.main.common.enums.VersionTypeEnum;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.common.handler.ApiResult;
import com.thinking.update.main.dao.AppDao;
import com.thinking.update.main.dao.AppTypeDao;
import com.thinking.update.main.dao.VersionDao;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.entity.AppType;
import com.thinking.update.main.domain.entity.Version;
import com.thinking.update.main.service.AppService;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AppServiceImpl implements AppService{
    @Resource
    private AppDao appDao;
    @Resource
    private AppTypeDao appTypeDao;
    @Resource
    private VersionDao versionDao;

    public void setAppDefaultField(App value) {
        value.setRunningState(AppRunningStateEnum.NORMAL.getValue());
        value.setRunningStateName(AppRunningStateEnum.NORMAL.getName());
        value.setUpdateState(AppUpdateStateEnum.DOWNLOADING.getValue());
        value.setVersionState(VersionManageStateEnum.UNSET_TARGET_VERSION.getValue());
    }
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
    @Transactional(rollbackFor = Exception.class)
    public App insertApp(App value){
        value.setAppName(appTypeDao.selectAppTypeById(value.getAppTypeId()).getTypeName());
        value.setProtocolName(versionDao.selectVersionById(value.getProtocolId()).getVersionName());
        value.setTargetVersionName(versionDao.selectVersionById(value.getVersionId()).getVersionName());
        setAppDefaultField(value);
        if (appDao.insertNonEmptyApp(value) == 1) {
            return value;
        }
        throw new BDException("添加App记录失败");
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