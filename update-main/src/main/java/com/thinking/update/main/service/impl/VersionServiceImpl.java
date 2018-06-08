package com.thinking.update.main.service.impl;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.github.pagehelper.PageHelper;
import com.thinking.update.main.common.enums.*;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.common.utils.FileUtil;
import com.thinking.update.main.dao.AppDao;
import com.thinking.update.main.dao.TaskDao;
import com.thinking.update.main.dao.TaskDetailDao;
import com.thinking.update.main.dao.VersionDao;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.entity.Task;
import com.thinking.update.main.domain.entity.TaskDetail;
import com.thinking.update.main.domain.entity.Version;
import com.thinking.update.main.domain.model.EnumVo;
import com.thinking.update.main.domain.model.FileVo;
import com.thinking.update.main.service.VersionService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
@Slf4j
@ConfigurationProperties(prefix = "app")
public class VersionServiceImpl implements VersionService{

    @Setter
    private String uploadDirectory;
    @Resource
    private VersionDao versionDao;
    @Resource
    private AppDao appDao;
    @Resource
    private TaskDao taskDao;
    @Resource
    private TaskDetailDao taskDetailDao;

    @Override
    public long getVersionRowCount(){
        return versionDao.getVersionRowCount();
    }
    @Override
    public List<Version> selectVersion(){
        return versionDao.selectVersion();
    }
    @Override
    public Version selectVersionById(Long id){
        return versionDao.selectVersionById(id);
    }
    @Override
    public int insertVersion(Version value){
        return versionDao.insertVersion(value);
    }
    @Override
    public Version insertNonEmptyVersion(Version value){
        if (versionDao.insertNonEmptyVersion(value) == 1) {
            return value;
        }
        throw new BDException("添加版本失败");
    }
    @Override
    public int insertVersionByBatch(List<Version> value){
        return versionDao.insertVersionByBatch(value);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteVersionById(Long id){
        Version version = versionDao.selectVersionById(id);
        if (version.getType().equals(VersionTypeEnum.INSTALL_PACKAGE.getValue())) {
            List<App> appTargetVersionNeedDelete = appDao.selectAppByObj(App.builder().targetVersionId(id).build());
            List<App> updateApps = appTargetVersionNeedDelete.parallelStream().filter(app1 ->
                    !app1.getVersionId().equals(app1.getTargetVersionId())).peek(app1 -> {
                app1.setTargetVersionName(app1.getVersionName());
                app1.setTargetVersionId(app1.getVersionId());
                app1.setVersionState(VersionManageStateEnum.IDENTICAL.getValue());
                app1.setUpdateState(AppUpdateStateEnum.FINISHED.getValue());
            }).collect(Collectors.toList());
            appDao.batchUpdate(updateApps);
        } else if (version.getType().equals(VersionTypeEnum.PROTOCOL.getValue())){
            List<App> appProtocolSame = appDao.selectAppByObj(App.builder().protocolId(id).build());
            appProtocolSame.parallelStream().forEach(app -> {
                app.setProtocolId(null);
                app.setProtocolName(null);
            });
            appDao.batchUpdate(appProtocolSame);
        }
        return versionDao.deleteVersionById(id);
    }
    @Override
    public int updateVersionById(Version enti){
        return versionDao.updateVersionById(enti);
    }
    @Override
    public int updateNonEmptyVersionById(Version enti){
        return versionDao.updateNonEmptyVersionById(enti);
    }

    @Override
    public List<EnumVo> getPackageList() {
        return getVersionList(VersionTypeEnum.INSTALL_PACKAGE.getValue());
    }

    @Override
    public List<EnumVo> getProtocolList() {
        return getVersionList(VersionTypeEnum.PROTOCOL.getValue());
    }

    @Override
    public List<Version> selectPackageByPage(Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        Version version = new Version();
        version.setType(VersionTypeEnum.INSTALL_PACKAGE.getValue());
        return versionDao.selectVersionByObj(version);
    }

    @Override
    public FileVo uploadFile(FileVo fileVo, MultipartFile file) {
        return FileUtil.getFileVo(fileVo, file, uploadDirectory);
    }

    private List<EnumVo> getVersionList(int versionType) {
        List<EnumVo> enumVoList = new LinkedList<>();
        Version version = new Version();
        version.setType(versionType);
        List<Version> versions = versionDao.selectVersionByObj(version);
        if (!CollectionUtils.isEmpty(versions)) {
            versions.forEach(version1 -> {
                EnumVo enumVo = new EnumVo();
                enumVo.setValue(version1.getId().toString());
                enumVo.setTitle(version1.getVersionName());
                enumVoList.add(enumVo);
            });
        }
        return enumVoList;
    }

    public VersionDao getVersionDao() {
        return this.versionDao;
    }

    public void setVersionDao(VersionDao versionDao) {
        this.versionDao = versionDao;
    }

}