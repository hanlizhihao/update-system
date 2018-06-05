package com.thinking.update.main.service.impl;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.github.pagehelper.PageHelper;
import com.thinking.update.main.common.enums.AppRunningStateEnum;
import com.thinking.update.main.common.enums.AppUpdateStateEnum;
import com.thinking.update.main.common.enums.VersionManageStateEnum;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.common.utils.DateUtils;
import com.thinking.update.main.dao.*;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.entity.AppActivityLog;
import com.thinking.update.main.domain.entity.AppStateLog;
import com.thinking.update.main.domain.entity.VehicleInfo;
import com.thinking.update.main.domain.model.AbnormalDetailVo;
import com.thinking.update.main.domain.model.AbnormalNumberVo;
import com.thinking.update.main.domain.model.EnumVo;
import com.thinking.update.main.domain.model.RunningStateDetailVo;
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
    @Resource
    private AppStateLogDao appStateLogDao;

    private void setAppDefaultField(App value) {
        value.setRunningState(AppRunningStateEnum.NORMAL.getValue());
        value.setRunningStateName(AppRunningStateEnum.NORMAL.getName());
        value.setUpdateState(AppUpdateStateEnum.DOWNLOADING.getValue());
        value.setVersionState(VersionManageStateEnum.UNSET_TARGET_VERSION.getValue());
    }

    private void setAppForUpdate(App app) {
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
    public List<EnumVo> getAppStateStatistics() {
        List<EnumVo> result = new ArrayList<>();
        result.add(EnumVo.builder()
                .title(AppRunningStateEnum.NORMAL.getName())
                .value(String.valueOf(appDao.getAppRowCountByRunningState(AppRunningStateEnum.NORMAL.getValue())))
                .build());
        result.add(EnumVo.builder()
                .title(AppRunningStateEnum.ABNORMAL.getName())
                .value(String.valueOf(appDao.getAppRowCountByRunningState(AppRunningStateEnum.ABNORMAL.getValue())))
                .build());
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public AbnormalNumberVo getAbnormalAppNumber() {
        List<App> abnormalApps = appDao.selectAppByObj(App.builder()
                .runningState(AppRunningStateEnum.ABNORMAL.getValue())
                .build());
        List<VehicleInfo> vehicleInfoList = vehicleDao.selectByApps(abnormalApps);
        List<String> companyNames = new LinkedList<>();
        List<Long> abnormalNumber = new LinkedList<>();
        for (VehicleInfo vehicleInfo : vehicleInfoList) {
            if (!companyNames.contains(vehicleInfo.getCompanyName())) {
                companyNames.add(vehicleInfo.getCompanyName());
                abnormalNumber.add(1L);
            } else {
                int abnormalNumberIndex = companyNames.indexOf(vehicleInfo.getCompanyName());
                long number = abnormalNumber.get(abnormalNumberIndex);
                abnormalNumber.add(abnormalNumberIndex ,++number);
            }
        }
        return AbnormalNumberVo.builder()
                .abnormalNumber(abnormalNumber)
                .companyNames(companyNames)
                .build();
    }

    @Override
    public List<App> selectApp(){
        return appDao.selectApp();
    }
    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<App> selectAppByPageAndFilter(Pageable pageable, App obj, List<Long> deviceIds){
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        if (CollectionUtils.isEmpty(deviceIds)) {
            return appDao.filterAppByObj(obj);
        } else {
            return appDao.getAppForPageByObjAndDeviceIds(obj, deviceIds);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<App> selectAppByPageAndRunningState(Pageable pageable, Integer state) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        return appDao.selectAppByObj(App.builder().runningState(state).build());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public RunningStateDetailVo getStateDetail(Long appId) {
        App app = appDao.selectAppById(appId);
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setDeviceId(String.valueOf(app.getDeviceId()));
        VehicleInfo vehicleInfoData = vehicleDao.selectVehicleinfoByObj(vehicleInfo);
        AppStateLog abnormalStateLog = appStateLogDao.selectLatestLastStateIsNormalLogByAppId(appId);
        AppStateLog lastNormalStateLog = appStateLogDao.selectNormalStateLogByAppId(appId);
        Duration duration = Duration.between(abnormalStateLog.getTs().toInstant(), Instant.now());
        long millis = duration.toMillis();
        return RunningStateDetailVo.builder()
                .deviceId(String.valueOf(app.getDeviceId()))
                .appName(app.getAppName())
                .beginTime(abnormalStateLog.getTs())
                .currentVersion(app.getVersionName())
                .department(vehicleInfoData.getCompanyName()+vehicleInfoData.getSubCompanyName()+vehicleInfoData
                        .getGroupName()+ vehicleInfoData.getLineName()+vehicleInfoData.getVehicleNo())
                .protocol(app.getProtocolName())
                .stableVersion(lastNormalStateLog.getVersionName())
                .stableProtocol(lastNormalStateLog.getProtocolName())
                .duration(getFormatTime(millis))
                .log(abnormalStateLog.getLog())
                .build();
    }

    private String getFormatTime(long millis) {
        String result = "";
        if (millis<60){
            result = Long.toString(millis);
            result = result+"秒";
        } else {
            if (millis>=3600)
            {
                long hour=millis/3600;
                long minute=millis%3600/60;
                long second=millis%3600%60;
                result=Long.toString(hour)+"小时"+Long.toString(minute)+"分钟"+
                        Long.toString(second)+"秒";
            }else
            {
                long minute=millis/60;
                long second=millis%60;
                result=Long.toString(minute)+"分钟"+Long.toString(second)+"秒";
            }
        }
        return result;
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