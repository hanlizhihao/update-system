package com.thinking.update.main.service.impl;
import com.github.pagehelper.PageHelper;
import com.thinking.update.main.dao.LogDao;
import com.thinking.update.main.domain.entity.SysLog;
import com.thinking.update.main.service.SysLogService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<SysLog> selectSysLog(Pageable pageable, SysLog sysLog) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        return sysLogDao.list(sysLog, map);
    }


}