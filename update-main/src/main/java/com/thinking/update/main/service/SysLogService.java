package com.thinking.update.main.service;
import java.util.List;
import com.thinking.update.main.domain.entity.SysLog;
import org.springframework.data.domain.Pageable;

/**
 * @author Administrator
 */
public interface SysLogService{
	/**
	 * 获得SysLog数据的总行数
	 * @return
	 */
    long getSysLogRowCount();

	/**
	 * 分页查询历史记录
	 * @param pageable
	 * @param sysLog
	 * @return
	 */
    List<SysLog> selectSysLog(Pageable pageable, SysLog sysLog);
}