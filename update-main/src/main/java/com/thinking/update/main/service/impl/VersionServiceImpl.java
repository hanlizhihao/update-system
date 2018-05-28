package com.thinking.update.main.service.impl;
import java.util.LinkedList;
import java.util.List;

import com.thinking.update.main.common.enums.VersionTypeEnum;
import com.thinking.update.main.dao.VersionDao;
import com.thinking.update.main.domain.entity.Version;
import com.thinking.update.main.domain.model.EnumVo;
import com.thinking.update.main.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class VersionServiceImpl implements VersionService{
    @Resource
    private VersionDao versionDao;
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
    public int insertNonEmptyVersion(Version value){
        return versionDao.insertNonEmptyVersion(value);
    }
    @Override
    public int insertVersionByBatch(List<Version> value){
        return versionDao.insertVersionByBatch(value);
    }
    @Override
    public int deleteVersionById(Long id){
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