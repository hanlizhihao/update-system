package com.thinking.update.main.service.impl;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.thinking.update.main.common.enums.AppRunningStateEnum;
import com.thinking.update.main.common.enums.AppUpdateStateEnum;
import com.thinking.update.main.common.enums.VersionManageStateEnum;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.dao.AppDao;
import com.thinking.update.main.dao.AppTypeDao;
import com.thinking.update.main.dao.VersionDao;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.service.AppService;
import org.springframework.data.domain.Pageable;
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

    public void setAppForUpdate(App app) {
        app.setRunningStateName(AppRunningStateEnum.getNameByValue(app.getRunningState()));
        app.setAppName(appTypeDao.selectAppTypeById(app.getAppTypeId()).getTypeName());
        app.setProtocolName(versionDao.selectVersionById(app.getProtocolId()).getVersionName());
        app.setTargetVersionName(versionDao.selectVersionById(app.getVersionId()).getVersionName());
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
    public List<App> selectAppByPageAndFilter(Pageable pageable, App obj){
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        return appDao.filterAppByObj(obj);
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
    @Transactional(rollbackFor = Exception.class)
    public int updateNonEmptyAppById(App enti){
        setAppForUpdate(enti);
        int result = appDao.updateNonEmptyAppById(enti);
        if (result == 0) {
            throw new BDException("更新终端应用异常");
        }
        return result;
    }

    public AppDao getAppDao() {
        return this.appDao;
    }

    public void setAppDao(AppDao appDao) {
        this.appDao = appDao;
    }

}