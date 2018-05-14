package com.thinking.update.main.dao;


import com.thinking.update.main.entity.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface LogDao {

	Log get(Long id);
	
	List<Log> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(Log log);
	
	int update(Log log);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
