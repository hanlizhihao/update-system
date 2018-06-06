package com.thinking.update.main.dao;


import com.thinking.update.main.domain.entity.SysLog;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:45:42
 */

public interface LogDao {

	SysLog get(Long id);
	
	List<SysLog> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(SysLog log);
	
	int update(SysLog log);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
