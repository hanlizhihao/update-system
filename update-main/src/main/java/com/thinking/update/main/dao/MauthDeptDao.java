package com.thinking.update.main.dao;
import com.thinking.update.main.entity.MauthDept;
import java.util.List;
public interface MauthDeptDao{
	/**
	 * 获得MauthDept数据的总行数
	 * @return
	 */
    long getMauthDeptRowCount();
	/**
	 * 获得MauthDept数据集合
	 * @return
	 */
    List<MauthDept> selectMauthDept();
	/**
	 * 获得一个MauthDept对象,以参数MauthDept对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    MauthDept selectMauthDeptByObj(MauthDept obj);
	/**
	 * 通过MauthDept的id获得MauthDept对象
	 * @param id
	 * @return
	 */
    MauthDept selectMauthDeptById(Integer id);
	/**
	 * 插入MauthDept到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertMauthDept(MauthDept value);
	/**
	 * 插入MauthDept中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyMauthDept(MauthDept value);
	/**
	 * 批量插入MauthDept到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertMauthDeptByBatch(List<MauthDept> value);
	/**
	 * 通过MauthDept的id删除MauthDept
	 * @param id
	 * @return
	 */
    int deleteMauthDeptById(Integer id);
	/**
	 * 通过MauthDept的id更新MauthDept中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateMauthDeptById(MauthDept enti);
	/**
	 * 通过MauthDept的id更新MauthDept中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyMauthDeptById(MauthDept enti);
}