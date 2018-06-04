package com.thinking.update.main.service.impl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.thinking.update.main.common.enums.AppRunningStateEnum;
import com.thinking.update.main.common.enums.AppUpdateStateEnum;
import com.thinking.update.main.common.enums.VersionManageStateEnum;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.dao.*;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.entity.AppActivityLog;
import com.thinking.update.main.domain.entity.VehicleInfo;
import com.thinking.update.main.domain.model.AbnormalDetailVo;
import com.thinking.update.main.domain.model.EnumVo;
import com.thinking.update.main.service.AppService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class AppServiceImpl implements AppService{
    @Resource
    private AppDao appDao;
    @Resource
    private AppTypeDao appTypeDao;
    @Resource
    private VersionDao versionDao;
    @Resource
    private VehicleDao vehicleDao;
    @Resource
    private AppActivityLogDao appActivityLogDao;

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
    public List<App> selectAppByPageAndFilter(Pageable pageable, App obj, List<Long> deviceIds){
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        if (CollectionUtils.isEmpty(deviceIds)) {
            return appDao.filterAppByObj(obj);
        } else {
            return appDao.getAppForPageByObjAndDeviceIds(obj, deviceIds);
        }
    }

    @Override
    public List<App> selectAbnormalPageBydeviceIds(Pageable pageable, List<Long> deviceIds) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        return appDao.getAppForPageByDeviceIdsAndStateList(AppUpdateStateEnum.getAbnormalStateList(), deviceIds);
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

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<EnumVo> getDeviceList() {
        List<EnumVo> enumVoList = new LinkedList<>();
        List<VehicleInfo> vehicleInfoList = vehicleDao.selectVehicle();
        if (!CollectionUtils.isEmpty(vehicleInfoList)) {
            vehicleInfoList.forEach(vehicleInfo -> {
                EnumVo enumVo = new EnumVo();
                enumVo.setValue(vehicleInfo.getDeviceId());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(vehicleInfo.getCompanyName())
                        .append(vehicleInfo.getSubCompanyName())
                        .append(vehicleInfo.getGroupName())
                        .append(vehicleInfo.getLineName())
                        .append(vehicleInfo.getVehicleNo());
                enumVo.setTitle(stringBuilder.toString());
                enumVoList.add(enumVo);
            });
        }
        return enumVoList;
    }

    @Override
    public List<AbnormalDetailVo> getAbnormalDetails(Long id) {
        Long appVersionLogId = appDao.selectAppById(id).getVersionLogId();
        AppActivityLog activityLog = new AppActivityLog();
        activityLog.setAppId(id);
        activityLog.setVersionId(appVersionLogId);
        List<AppActivityLog> activityLogs = appActivityLogDao.selectAppActivityLogByObj(activityLog);
        List<AbnormalDetailVo> result = new ArrayList<>();
        activityLogs.forEach(logItem -> {
            AbnormalDetailVo detailVo = AbnormalDetailVo.builder()
                    .currentState(logItem.getUpdateState())
                    .lastState(logItem.getLastUpdateState())
                    .logType(logItem.getLogType())
                    .activeTime(logItem.getTs())
                    .logDigest(logItem.getLog())
                    .build();
            result.add(detailVo);
        });
        return result;
    }

    public AppDao getAppDao() {
        return this.appDao;
    }

    public void setAppDao(AppDao appDao) {
        this.appDao = appDao;
    }

}