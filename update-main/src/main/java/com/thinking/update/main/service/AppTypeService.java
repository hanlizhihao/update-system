package com.thinking.update.main.service;
import java.util.List;
import com.thinking.update.main.domain.entity.AppType;
import com.thinking.update.main.domain.model.EnumVo;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface AppTypeService{
	/**
	 * 获得AppType数据的总行数
	 * @return
	 */
    long getAppTypeRowCount();
	/**
	 * 获得AppType数据集合
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class, readOnly = true)
    List<AppType> selectAppType();
	/**
	 * 获得一个AppType对象,以参数AppType对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class, readOnly = true)
    AppType selectAppTypeByObj(AppType obj);
	/**
	 * 通过AppType的id获得AppType对象
	 * @param id
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class, readOnly = true)
    AppType selectAppTypeById(Long id);
	/**
	 * 插入AppType到数据库,包括null值
	 * @param value
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
    AppType insertAppType(AppType value);
	/**
	 * 插入AppType中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
    int insertNonEmptyAppType(AppType value);
	/**
	 * 批量插入AppType到数据库
	 * @param value
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
    int insertAppTypeByBatch(List<AppType> value);
	/**
	 * 通过AppType的id删除AppType
	 * @param id
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
    int deleteAppTypeById(Long id);
	/**
	 * 通过AppType的id更新AppType中的数据,包括null值
	 * @param enti
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
    int updateAppTypeById(AppType enti);
	/**
	 * 通过AppType的id更新AppType中属性不为null的数据
	 * @param enti
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
    int updateNonEmptyAppTypeById(AppType enti);

	/**
	 * 分类列表转为枚举值
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class, readOnly = true)
    List<EnumVo> getAppTypeList();
}