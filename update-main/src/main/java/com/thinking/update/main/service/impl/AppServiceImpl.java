package com.thinking.update.main.service.impl;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.thinking.update.main.common.enums.*;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.common.utils.AppTaskUtil;
import com.thinking.update.main.dao.*;
import com.thinking.update.main.domain.entity.*;
import com.thinking.update.main.domain.model.*;
import com.thinking.update.main.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
@Slf4j
public class AppServiceImpl implements AppService {
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
    @Resource
    private AppVersionLogDao versionLogDao;

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
    public long getAppRowCount() {
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
                abnormalNumber.add(abnormalNumberIndex, ++number);
            }
        }
        return AbnormalNumberVo.builder()
                .abnormalNumber(abnormalNumber)
                .companyNames(companyNames)
                .build();
    }

    @Override
    public List<App> selectApp() {
        return appDao.selectApp();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<App> selectAppByPageAndFilter(Pageable pageable, App obj, List<Long> deviceIds) {
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
        long seconds = duration.toMillis() / 1000;
        return RunningStateDetailVo.builder()
                .deviceId(String.valueOf(app.getDeviceId()))
                .appName(app.getAppName())
                .beginTime(abnormalStateLog.getTs())
                .currentVersion(app.getVersionName())
                .department(vehicleInfoData.getCompanyName() + vehicleInfoData.getSubCompanyName() + vehicleInfoData
                        .getGroupName() + vehicleInfoData.getLineName() + vehicleInfoData.getVehicleNo())
                .protocol(app.getProtocolName())
                .stableVersion(lastNormalStateLog.getVersionName())
                .stableProtocol(lastNormalStateLog.getProtocolName())
                .duration(getFormatTime(seconds))
                .log(abnormalStateLog.getLog())
                .build();
    }

    private String getFormatTime(long millis) {
        String result;
        if (millis < 60) {
            result = Long.toString(millis);
            result = result + "秒";
        } else {
            if (millis >= 3600) {
                long hour = millis / 3600;
                long minute = millis % 3600 / 60;
                long second = millis % 3600 % 60;
                result = Long.toString(hour) + "小时" + Long.toString(minute) + "分钟" +
                        Long.toString(second) + "秒";
            } else {
                long minute = millis / 60;
                long second = millis % 60;
                result = Long.toString(minute) + "分钟" + Long.toString(second) + "秒";
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
    public App selectAppById(Long id) {
        return appDao.selectAppById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public App insertApp(App value) {
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
    public int insertNonEmptyApp(App value) {
        return appDao.insertNonEmptyApp(value);
    }

    @Override
    public int insertAppByBatch(List<App> value) {
        return appDao.insertAppByBatch(value);
    }

    @Override
    public int deleteAppById(Long id) {
        return appDao.deleteAppById(id);
    }

    @Override
    public int updateAppById(App enti) {
        return appDao.updateAppById(enti);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateNonEmptyAppById(App enti) {
        setAppForUpdate(enti);
        App app = appDao.selectAppById(enti.getId());
        AppVersionLog versionLog = insertAppVersionLog(app, enti);
        if (versionLog != null) {
            enti.setVersionLogId(versionLog.getId());
        }
        AppActivityLog activityLog = insertActivityLog(app, enti, versionLog);
        if (activityLog != null) {
            enti.setActivityLogId(activityLog.getId());
        }
        if (!app.getRunningState().equals(enti.getRunningState())) {
            insertAppRunningStateLog(app, DeviceModel.builder()
                    .runningState(enti.getRunningState())
                    .currentVersionId(enti.getVersionId())
                    .currentProtocolId(app.getProtocolId())
                    .build()
            );
        }
        int result = appDao.updateNonEmptyAppById(enti);
        if (result == 0) {
            throw new BDException("更新终端应用异常");
        }
        return result;
    }

    private AppActivityLog insertActivityLog(App app, App targetApp, AppVersionLog createAppLog) {
        if (!app.getUpdateState().equals(targetApp.getUpdateState())) {
            AppVersionLog versionLog = new AppVersionLog();
            versionLog.setAppId(app.getId());
            versionLog.setVersionId(targetApp.getVersionId());
            versionLog.setTargetVersionId(targetApp.getTargetVersionId());
            AppVersionLog appVersionLog = versionLogDao.selectOneByObj(versionLog);
            AppActivityLog activityLog = new AppActivityLog();
            setCommonActiveLog(app, targetApp, activityLog);
            if (appVersionLog != null) {
                activityLog.setVersionLogId(appVersionLog.getId());
            } else {
                activityLog.setVersionLogId(createAppLog.getId());
            }
            appActivityLogDao.insertNonEmptyAppActivityLog(activityLog);
            return activityLog;
        }
        return null;
    }

    private void setCommonActiveLog(App app, App targetApp, AppActivityLog activityLog) {
        activityLog.setVersionId(targetApp.getVersionId());
        activityLog.setVersion(versionDao.selectVersionById(targetApp.getVersionId()).getVersionName());
        activityLog.setAppId(app.getId());
        activityLog.setAppName(app.getAppName());
        activityLog.setLastUpdateState(AppUpdateStateEnum.getNameByValue(app.getUpdateState()));
        activityLog.setTargetVersion(versionDao.selectVersionById(targetApp.getTargetVersionId()).getVersionName());
        activityLog.setTargetVersionId(targetApp.getTargetVersionId());
        activityLog.setTs(new Date(System.currentTimeMillis()));
        activityLog.setUpdateState(AppUpdateStateEnum.getNameByValue(targetApp.getUpdateState()));
    }

    /**
     * 当前版本发生变化时，添加新的日志记录
     *
     * @param targetApp
     * @return
     */
    private AppVersionLog insertAppVersionLog(App app, App targetApp) {
        if (app.getTargetVersionId() == 0 || !app.getVersionId().equals(targetApp.getVersionId())) {
            AppVersionLog appVersionLog = new AppVersionLog();
            appVersionLog.setTs(new Date(System.currentTimeMillis()));
            if (targetApp.getVersionId().equals(targetApp.getTargetVersionId())) {
                appVersionLog.setState(VersionLogStateEnum.UPDATE_FINISHED.getValue());
                appVersionLog.setStateName(VersionLogStateEnum.UPDATE_FINISHED.getName());
            } else {
                appVersionLog.setState(VersionLogStateEnum.UPDATING.getValue());
                appVersionLog.setStateName(VersionLogStateEnum.UPDATING.getName());
            }
            appVersionLog.setTargetVersionId(targetApp.getTargetVersionId());
            appVersionLog.setTargetVersion(versionDao.selectVersionById(targetApp.getTargetVersionId()).getVersionName());
            appVersionLog.setVersionId(targetApp.getVersionId());
            appVersionLog.setVersion(versionDao.selectVersionById(targetApp.getVersionId()).getVersionName());
            appVersionLog.setAppName(app.getAppName());
            appVersionLog.setAppId(app.getId());
            versionLogDao.insertNonEmptyAppVersionLog(appVersionLog);
            return appVersionLog;
        }
        if (!targetApp.getVersionId().equals(targetApp.getTargetVersionId())) {
            AppVersionLog appVersionLog = new AppVersionLog();
            appVersionLog.setTs(new Date(System.currentTimeMillis()));
            appVersionLog.setState(VersionLogStateEnum.UPDATING.getValue());
            appVersionLog.setStateName(VersionLogStateEnum.UPDATING.getName());
            appVersionLog.setTargetVersionId(targetApp.getTargetVersionId());
            appVersionLog.setTargetVersion(versionDao.selectVersionById(targetApp.getTargetVersionId()).getVersionName());
            appVersionLog.setVersionId(targetApp.getVersionId());
            appVersionLog.setVersion(versionDao.selectVersionById(targetApp.getVersionId()).getVersionName());
            appVersionLog.setAppName(app.getAppName());
            appVersionLog.setAppId(app.getId());
            versionLogDao.insertNonEmptyAppVersionLog(appVersionLog);
            return appVersionLog;
        }
        return null;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public VersionVo getVersionInfo(DeviceModel deviceModel) {
        VersionVo versionVo = new VersionVo();
        List<App> apps = appDao.selectAppByObj(App.builder()
                .deviceId(deviceModel.getDeviceId())
                .appTypeId(deviceModel.getAppTypeId())
                .id(deviceModel.getAppId())
                .build());
        if (CollectionUtils.isEmpty(apps)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("异常参数:设备Id").append(deviceModel.getDeviceId()).append("应用类型:")
                    .append(deviceModel.getAppTypeId()).append("应用Id:").append(deviceModel.getAppId());
            throw new BDException("通过远程设备传递的参数没有找到对应的终端应用，需要在管理端添加指定的应用" + stringBuilder.toString());
        }
        App app = apps.get(0);
        processState(app, deviceModel);
        if (deviceModel.getCurrentProtocolId() != null) {
            Version targetPackage = versionDao.selectVersionById(deviceModel.getCurrentVersionId());
            setAppVersion(app, targetPackage, versionVo);
        }
        if (deviceModel.getCurrentProtocolId() != null) {
            Version targetProtocol = versionDao.selectVersionById(deviceModel.getCurrentProtocolId());
            setAppVersion(app, targetProtocol, versionVo);
        }
        appDao.updateNonEmptyAppById(app);
        return versionVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ActivityVo versionActive(VersionActivityModel activityModel) {
        App app = appDao.selectAppById(activityModel.getAppId());
        if (!app.getRunningState().equals(activityModel.getRunningState())) {
            insertAppRunningStateLog(app, DeviceModel.builder()
                    .currentProtocolId(activityModel.getProtocolId())
                    .currentVersionId(activityModel.getCurrentVersionId())
                    .runningState(activityModel.getRunningState())
                    .log(activityModel.getLog())
                    .build()
            );
        }
        if (!app.getUpdateState().equals(activityModel.getVersionActivityState())) {
            processUpdateState(app,activityModel);
        }
        processUpdateTaskAndVersionLog(app, activityModel);
        appDao.updateNonEmptyAppById(app);
        return ActivityVo.builder().updateChange(false).build();
    }

    private void processUpdateTaskAndVersionLog(App app, VersionActivityModel activityModel) {
        if (activityModel.getVersionActivityState().equals(AppUpdateStateEnum.FINISHED.getValue())) {
            app.setVersionLogId(activityModel.getTargetVersionId());
            app.setVersionName(versionDao.selectVersionById(activityModel.getTargetVersionId()).getVersionName());
            AppVersionLog appVersionLog = getVersionLog(app, activityModel.getTargetVersionId(),
                    VersionLogStateEnum.UPDATE_FINISHED);
            versionLogDao.insertNonEmptyAppVersionLog(appVersionLog);
            app.setVersionLogId(appVersionLog.getId());
            AppTaskUtil.checkAppInTask(app);
        }
    }

    private void processUpdateState(App app, VersionActivityModel model) {
        if (app.getUpdateState().equals(AppUpdateStateEnum.FINISHED.getValue())) {
            throw new BDException("这个应用的升级已经完成，升级状态不能再更改");
        }
        AppVersionLog logParam = new AppVersionLog();
        logParam.setTargetVersionId(model.getTargetVersionId());
        logParam.setVersionId(model.getCurrentVersionId());
        logParam.setAppId(app.getId());
        AppVersionLog appVersionLog = versionLogDao.selectOneByObj(logParam);
        AppActivityLog activityLog = new AppActivityLog();
        setCommonActiveLog(app, app, activityLog);
        activityLog.setVersionLogId(appVersionLog.getId());
        appActivityLogDao.insertNonEmptyAppActivityLog(activityLog);
        app.setActivityLogId(activityLog.getId());
    }

    private void processState(App app, DeviceModel deviceModel) {
        if (deviceModel.getRunningState() == null || deviceModel.getRunningState().equals(app.getRunningState())) {
            return;
        }
        app.setRunningState(deviceModel.getRunningState());
        app.setRunningStateName(AppRunningStateEnum.getNameByValue(deviceModel.getRunningState()));
        insertAppRunningStateLog(app, deviceModel);
    }

    private void insertAppRunningStateLog(App app, DeviceModel deviceModel) {
        AppStateLog appStateLog = new AppStateLog();
        appStateLog.setAppId(app.getId());
        appStateLog.setAppName(app.getAppName());
        appStateLog.setCurrentState(deviceModel.getRunningState());
        appStateLog.setLastState(app.getRunningState());
        appStateLog.setTs(new Date(System.currentTimeMillis()));
        appStateLog.setLog(deviceModel.getLog());
        appStateLog.setProtocolId(deviceModel.getCurrentProtocolId() == null ? app.getProtocolId() :
                deviceModel.getCurrentProtocolId());
        if (appStateLog.getProtocolId() != null) {
            appStateLog.setProtocolName(versionDao.selectVersionById(appStateLog.getProtocolId()).getVersionName());
        }
        appStateLog.setVersionId(deviceModel.getCurrentVersionId() == null ? app.getVersionId() : deviceModel.getCurrentVersionId());
        if (appStateLog.getVersionId() != null) {
            appStateLog.setVersionName(versionDao.selectVersionById(appStateLog.getVersionId()).getVersionName());
        }
        appStateLogDao.insertNonEmptyAppStateLog(appStateLog);
    }

    private void setAppVersion(App app, Version version, VersionVo versionVo) {
        if (version == null) {
            log.error("远程设备传递的版本id未知");
        } else {
            if (VersionTypeEnum.INSTALL_PACKAGE.getValue() == version.getType()) {
                app.setVersionId(version.getId());
                app.setVersionName(version.getVersionName());
                processVersion(version, app, versionVo);
            } else if (VersionTypeEnum.PROTOCOL.getValue() == version.getType()) {
                if (app.getProtocolId() == null) {
                    app.setProtocolId(version.getId());
                    app.setProtocolName(version.getVersionName());
                } else {
                    versionVo.setAppId(app.getId());
                    versionVo.setNeedUpdate(true);
                    List<Version> versions = versionVo.getVersion();
                    if (CollectionUtils.isEmpty(versions)) {
                        versions = new ArrayList<>();
                    }
                    versions.add(versionDao.selectVersionById(app.getProtocolId()));
                }
            }
        }
    }

    private void processVersion(Version version, App app, VersionVo versionVo) {
        AppVersionLog appVersionLog;
        if (app.getTargetVersionId() == null || app.getTargetVersionId().equals(version.getId())) {
            if (app.getTargetVersionId() == null) {
                app.setVersionState(VersionManageStateEnum.UNSET_HAVE_CONFIRM.getValue());
            } else {
                app.setVersionState(VersionManageStateEnum.IDENTICAL.getValue());
            }
            appVersionLog = getVersionLog(app, version.getId(), VersionLogStateEnum.UPDATE_FINISHED);
            AppTaskUtil.checkAppInTask(app);
            versionVo = VersionVo.builder()
                    .needUpdate(false)
                    .appId(app.getId())
                    .build();
        } else {
            app.setVersionState(VersionManageStateEnum.DISAGREE.getValue());
            Version targetVersion = versionDao.selectVersionById(app.getTargetVersionId());
            List<Version> targetVersions = new ArrayList<>();
            targetVersions.add(targetVersion);
            versionVo = VersionVo.builder()
                    .appId(app.getId())
                    .needUpdate(true)
                    .version(targetVersions)
                    .build();
            appVersionLog = getVersionLog(app, version.getId(), VersionLogStateEnum.UPDATING);
        }
        versionLogDao.insertNonEmptyAppVersionLog(appVersionLog);
    }

    private AppVersionLog getVersionLog(App app, Long id, VersionLogStateEnum logStateEnum) {
        AppVersionLog appVersionLog = new AppVersionLog();
        appVersionLog.setAppId(app.getId());
        appVersionLog.setAppName(app.getAppName());
        appVersionLog.setVersion(app.getVersionName());
        appVersionLog.setVersionId(app.getVersionId());
        Version version = versionDao.selectVersionById(id);
        if (version == null) {
            throw new BDException("未知的VersionId" + id.toString());
        }
        appVersionLog.setTargetVersion(version.getVersionName());
        appVersionLog.setTargetVersionId(id);
        appVersionLog.setState(logStateEnum.getValue());
        appVersionLog.setStateName(logStateEnum.getName());
        appVersionLog.setTs(new Date(System.currentTimeMillis()));
        return appVersionLog;
    }

    public AppDao getAppDao() {
        return this.appDao;
    }

    public void setAppDao(AppDao appDao) {
        this.appDao = appDao;
    }

}