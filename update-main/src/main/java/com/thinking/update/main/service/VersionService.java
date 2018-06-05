package com.thinking.update.main.service;
import java.util.List;
import com.thinking.update.main.domain.entity.Version;
import com.thinking.update.main.domain.model.EnumVo;
import com.thinking.update.main.domain.model.FileVo;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface VersionService{
	/**
	 * 获得Version数据的总行数
	 * @return
	 */
    long getVersionRowCount();
	/**
	 * 获得Version数据集合
	 * @return
	 */
    List<Version> selectVersion();
	/**
	 * 通过Version的id获得Version对象
	 * @param id
	 * @return
	 */
    Version selectVersionById(Long id);
	/**
	 * 插入Version到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertVersion(Version value);
	/**
	 * 插入Version中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
	Version insertNonEmptyVersion(Version value);
	/**
	 * 批量插入Version到数据库
	 * @param value
	 * @return
	 */
    int insertVersionByBatch(List<Version> value);
	/**
	 * 通过Version的id删除Version
	 * @param id
	 * @return
	 */
    int deleteVersionById(Long id);
	/**
	 * 通过Version的id更新Version中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateVersionById(Version enti);
	/**
	 * 通过Version的id更新Version中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyVersionById(Version enti);

	/**
	 * 查询安装程序分页枚举列表
	 * @return
	 */
	List<EnumVo> getPackageList();

	/**
	 * 查询协议枚举列表
	 * @return
	 */
    List<EnumVo> getProtocolList();

	/**
	 * 分页查询安装程序
	 * @param pageable
	 * @return
	 */
	List<Version> selectPackageByPage(Pageable pageable);

	FileVo uploadFile(FileVo fileVo, MultipartFile file);
}