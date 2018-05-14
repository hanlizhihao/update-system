package com.thinking.update.main.service.impl;

import com.thinking.update.main.dao.UsersDao;
import com.thinking.update.main.entity.Users;
import com.thinking.update.main.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int insertNonEmptyUsers(Users value){
        return usersDao.insertNonEmptyUsers(value);
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