package com.thinking.update.main.service.impl;
import com.thinking.update.main.dao.LogDao;
import com.thinking.update.main.domain.entity.SysLog;
import com.thinking.update.main.service.SysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class SysLogServiceImpl implements SysLogService{
    @Resource
    private LogDao sysLogDao;
    @Override
    public long getSysLogRowCount(){
        return sysLogDao.count(null);
    }
    @Override
    public List<SysLog> selectSysLog(){
        return sysLogDao.list(null);
    }


}