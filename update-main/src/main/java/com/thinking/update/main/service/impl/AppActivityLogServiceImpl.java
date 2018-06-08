package com.thinking.update.main.service.impl;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.common.utils.FileUtil;
import com.thinking.update.main.dao.AppActivityLogDao;
import com.thinking.update.main.domain.entity.AppActivityLog;
import com.thinking.update.main.domain.model.FileVo;
import com.thinking.update.main.service.AppActivityLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 */
@Service
@Slf4j
@ConfigurationProperties(prefix = "app")
public class AppActivityLogServiceImpl implements AppActivityLogService{
    @Resource
    private AppActivityLogDao appActivityLogDao;
    @lombok.Setter
    private String logDirectory;

    @Override
    public long getAppActivityLogRowCount(){
        return appActivityLogDao.getAppActivityLogRowCount();
    }
    @Override
    public List<AppActivityLog> selectAppActivityLog(){
        return appActivityLogDao.selectAppActivityLog();
    }
    @Override
    public List<AppActivityLog> selectAppActivityLogByObj(AppActivityLog obj){
        return appActivityLogDao.selectAppActivityLogByObj(obj);
    }
    @Override
    public AppActivityLog selectAppActivityLogById(Long id){
        return appActivityLogDao.selectAppActivityLogById(id);
    }
    @Override
    public int insertAppActivityLog(AppActivityLog value){
        return appActivityLogDao.insertAppActivityLog(value);
    }
    @Override
    public int insertNonEmptyAppActivityLog(AppActivityLog value){
        return appActivityLogDao.insertNonEmptyAppActivityLog(value);
    }
    @Override
    public int insertAppActivityLogByBatch(List<AppActivityLog> value){
        return appActivityLogDao.insertAppActivityLogByBatch(value);
    }
    @Override
    public int deleteAppActivityLogById(Long id){
        return appActivityLogDao.deleteAppActivityLogById(id);
    }
    @Override
    public int updateAppActivityLogById(AppActivityLog enti){
        return appActivityLogDao.updateAppActivityLogById(enti);
    }
    @Override
    public int updateNonEmptyAppActivityLogById(AppActivityLog enti){
        return appActivityLogDao.updateNonEmptyAppActivityLogById(enti);
    }

    @Override
    public FileVo uploadLogFile(FileVo fileVo, MultipartFile file) {
        return FileUtil.getFileVo(fileVo, file, logDirectory);
    }


    public AppActivityLogDao getAppActivityLogDao() {
        return this.appActivityLogDao;
    }

    public void setAppActivityLogDao(AppActivityLogDao appActivityLogDao) {
        this.appActivityLogDao = appActivityLogDao;
    }

}