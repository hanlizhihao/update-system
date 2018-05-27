package com.thinking.update.main.dao;
import com.thinking.update.main.entity.SysLog;
import java.util.List;
public interface SysLogDao{
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
	/**
	 * 获得一个SysLog对象,以参数SysLog对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    SysLog selectSysLogByObj(SysLog obj);
	/**
	 * 通过SysLog的id获得SysLog对象
	 * @param id
	 * @return
	 */
    SysLog selectSysLogById(Long id);
	/**
	 * 插入SysLog到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertSysLog(SysLog value);
	/**
	 * 插入SysLog中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptySysLog(SysLog value);
	/**
	 * 批量插入SysLog到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertSysLogByBatch(List<SysLog> value);
	/**
	 * 通过SysLog的id删除SysLog
	 * @param id
	 * @return
	 */
    int deleteSysLogById(Long id);
	/**
	 * 通过SysLog的id更新SysLog中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateSysLogById(SysLog enti);
	/**
	 * 通过SysLog的id更新SysLog中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptySysLogById(SysLog enti);
}