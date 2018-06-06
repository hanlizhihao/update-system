package com.thinking.update.main.service;
import java.util.List;
import com.thinking.update.main.domain.entity.SysLog;
public interface SysLogService{
	/**
	 * 获得SysLog数据的总行数
	 * @return
	 */
    long getSysLogRowCount();
	/**
	 * 获得SysLog数据集合
	 * @return
	 */
    List<SysLog> selectSysLog();
}