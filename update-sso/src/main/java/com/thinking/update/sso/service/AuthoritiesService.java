package com.thinking.update.sso.service;
import java.util.List;
import com.thinking.update.sso.domain.entity.Authorities;
public interface AuthoritiesService{
	/**
	 * 获得Authorities数据的总行数
	 * @return
	 */
    long getAuthoritiesRowCount();
	/**
	 * 获得Authorities数据集合
	 * @return
	 */
    List<Authorities> selectAuthorities();
	/**
	 * 获得一个Authorities对象,以参数Authorities对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Authorities selectAuthoritiesByObj(Authorities obj);
	/**
	 * 通过Authorities的id获得Authorities对象
	 * @param id
	 * @return
	 */
    Authorities selectAuthoritiesById(Long id);
	/**
	 * 插入Authorities到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAuthorities(Authorities value);
	/**
	 * 插入Authorities中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAuthorities(Authorities value);
	/**
	 * 批量插入Authorities到数据库
	 * @param value
	 * @return
	 */
    int insertAuthoritiesByBatch(List<Authorities> value);
	/**
	 * 通过Authorities的id删除Authorities
	 * @param id
	 * @return
	 */
    int deleteAuthoritiesById(Long id);
	/**
	 * 通过Authorities的id更新Authorities中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAuthoritiesById(Authorities enti);
	/**
	 * 通过Authorities的id更新Authorities中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAuthoritiesById(Authorities enti);
}