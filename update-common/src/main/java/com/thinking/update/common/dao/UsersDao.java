package com.thinking.update.common.dao;
import com.thinking.update.common.entity.Users;
import java.util.List;
/**
 * @author Administrator
 */
public interface UsersDao{
	/**
	 * 获得Users数据的总行数
	 * @return
	 */
    long getUsersRowCount();
	/**
	 * 获得Users数据集合
	 * @return
	 */
    List<Users> selectUsers();
	/**
	 * 获得一个Users对象,以参数Users对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Users selectUsersByObj(Users obj);
	/**
	 * 带过滤条件的分页查询
	 * @param user
	 * @return
	 */
	List<Users> filterUsersByUser(Users user);
	/**
	 * 通过Users的id获得Users对象
	 * @param id
	 * @return
	 */
    Users selectUsersById(Long id);
	/**
	 * 插入Users到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertUsers(Users value);
	/**
	 * 插入Users中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyUsers(Users value);
	/**
	 * 批量插入Users到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertUsersByBatch(List<Users> value);
	/**
	 * 通过Users的id删除Users
	 * @param id
	 * @return
	 */
    int deleteUsersById(Long id);
	/**
	 * 通过Users的id更新Users中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateUsersById(Users enti);
	/**
	 * 通过Users的id更新Users中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyUsersById(Users enti);
}