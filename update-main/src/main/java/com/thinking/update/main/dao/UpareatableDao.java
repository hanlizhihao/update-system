package com.thinking.update.main.dao;
import com.thinking.update.main.entity.Upareatable;
import java.util.List;
public interface UpareatableDao{
	/**
	 * 获得Upareatable数据的总行数
	 * @return
	 */
    long getUpareatableRowCount();
	/**
	 * 获得Upareatable数据集合
	 * @return
	 */
    List<Upareatable> selectUpareatable();
	/**
	 * 获得一个Upareatable对象,以参数Upareatable对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Upareatable selectUpareatableByObj(Upareatable obj);
	/**
	 * 通过Upareatable的id获得Upareatable对象
	 * @param id
	 * @return
	 */
    Upareatable selectUpareatableById(Object id);
	/**
	 * 插入Upareatable到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertUpareatable(Upareatable value);
	/**
	 * 插入Upareatable中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyUpareatable(Upareatable value);
	/**
	 * 批量插入Upareatable到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertUpareatableByBatch(List<Upareatable> value);
	/**
	 * 通过Upareatable的id删除Upareatable
	 * @param id
	 * @return
	 */
    int deleteUpareatableById(Object id);
	/**
	 * 通过Upareatable的id更新Upareatable中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateUpareatableById(Upareatable enti);
	/**
	 * 通过Upareatable的id更新Upareatable中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyUpareatableById(Upareatable enti);
}