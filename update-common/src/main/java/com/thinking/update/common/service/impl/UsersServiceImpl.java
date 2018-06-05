package com.thinking.update.common.service.impl;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.thinking.update.common.dao.UsersDao;
import com.thinking.update.common.entity.Users;
import com.thinking.update.common.service.UsersService;
import com.thinking.update.main.common.exception.BDException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
/**
 * @author Administrator
 */
@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersDao usersDao;
    @Override
    public long getUsersRowCount(){
        return usersDao.getUsersRowCount();
    }
    @Override
    public List<Users> selectUsers(){
        return usersDao.selectUsers();
    }

    @Override
    public List<Users> selectUsersPageAndFilter(Pageable pageable, Users users) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        return usersDao.filterUsersByUser(users);
    }

    @Override
    public Users selectUsersByObj(Users obj){
        return usersDao.selectUsersByObj(obj);
    }
    @Override
    public Users selectUsersById(Long id){
        return usersDao.selectUsersById(id);
    }
    @Override
    public int insertUsers(Users value){
        return usersDao.insertUsers(value);
    }
    @Override
    public Users insertNonEmptyUsers(Users value){
        if (usersDao.insertNonEmptyUsers(value) == 1) {
            return value;
        }
        throw new BDException("添加用户");
    }
    @Override
    public int insertUsersByBatch(List<Users> value){
        return usersDao.insertUsersByBatch(value);
    }
    @Override
    public int deleteUsersById(Long id){
        return usersDao.deleteUsersById(id);
    }
    @Override
    public int updateUsersById(Users enti){
        return usersDao.updateUsersById(enti);
    }
    @Override
    public int updateNonEmptyUsersById(Users enti){
        return usersDao.updateNonEmptyUsersById(enti);
    }

    public UsersDao getUsersDao() {
        return this.usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

}