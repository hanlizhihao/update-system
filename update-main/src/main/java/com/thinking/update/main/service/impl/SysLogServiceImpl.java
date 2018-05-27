package com.thinking.update.main.service.impl;
import java.util.List;
import com.thinking.update.main.dao.SysLogDao;
import com.thinking.update.main.domain.entity.SysLog;
import com.thinking.update.main.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysLogServiceImpl implements SysLogService{
    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public long getSysLogRowCount(){
        return sysLogDao.getSysLogRowCount();
    }
    @Override
    public List<SysLog> selectSysLog(){
        return sysLogDao.selectSysLog();
    }
    @Override
    public SysLog selectSysLogByObj(SysLog obj){
        return sysLogDao.selectSysLogByObj(obj);
    }
    @Override
    public SysLog selectSysLogById(Long id){
        return sysLogDao.selectSysLogById(id);
    }
    @Override
    public int insertSysLog(SysLog value){
        return sysLogDao.insertSysLog(value);
    }
    @Override
    public int insertNonEmptySysLog(SysLog value){
        return sysLogDao.insertNonEmptySysLog(value);
    }
    @Override
    public int insertSysLogByBatch(List<SysLog> value){
        return sysLogDao.insertSysLogByBatch(value);
    }
    @Override
    public int deleteSysLogById(Long id){
        return sysLogDao.deleteSysLogById(id);
    }
    @Override
    public int updateSysLogById(SysLog enti){
        return sysLogDao.updateSysLogById(enti);
    }
    @Override
    public int updateNonEmptySysLogById(SysLog enti){
        return sysLogDao.updateNonEmptySysLogById(enti);
    }

    public SysLogDao getSysLogDao() {
        return this.sysLogDao;
    }

    public void setSysLogDao(SysLogDao sysLogDao) {
        this.sysLogDao = sysLogDao;
    }

}