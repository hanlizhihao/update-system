package com.thinking.update.main.service.impl;

import com.thinking.update.main.dao.VersionDao;
import com.thinking.update.main.entity.Version;
import com.thinking.update.main.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionServiceImpl implements VersionService{
    @Autowired
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
    public Version selectVersionByObj(Version obj){
        return versionDao.selectVersionByObj(obj);
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

    public VersionDao getVersionDao() {
        return this.versionDao;
    }

    public void setVersionDao(VersionDao versionDao) {
        this.versionDao = versionDao;
    }

}