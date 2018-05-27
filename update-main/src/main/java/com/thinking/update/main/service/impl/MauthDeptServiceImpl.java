package com.thinking.update.main.service.impl;
import java.util.List;
import com.thinking.update.main.dao.MauthDeptDao;
import com.thinking.update.main.entity.MauthDept;
import com.thinking.update.main.service.MauthDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MauthDeptServiceImpl implements MauthDeptService{
    @Autowired
    private MauthDeptDao mauthDeptDao;
    @Override
    public long getMauthDeptRowCount(){
        return mauthDeptDao.getMauthDeptRowCount();
    }
    @Override
    public List<MauthDept> selectMauthDept(){
        return mauthDeptDao.selectMauthDept();
    }
    @Override
    public MauthDept selectMauthDeptByObj(MauthDept obj){
        return mauthDeptDao.selectMauthDeptByObj(obj);
    }
    @Override
    public MauthDept selectMauthDeptById(Integer id){
        return mauthDeptDao.selectMauthDeptById(id);
    }
    @Override
    public int insertMauthDept(MauthDept value){
        return mauthDeptDao.insertMauthDept(value);
    }
    @Override
    public int insertNonEmptyMauthDept(MauthDept value){
        return mauthDeptDao.insertNonEmptyMauthDept(value);
    }
    @Override
    public int insertMauthDeptByBatch(List<MauthDept> value){
        return mauthDeptDao.insertMauthDeptByBatch(value);
    }
    @Override
    public int deleteMauthDeptById(Integer id){
        return mauthDeptDao.deleteMauthDeptById(id);
    }
    @Override
    public int updateMauthDeptById(MauthDept enti){
        return mauthDeptDao.updateMauthDeptById(enti);
    }
    @Override
    public int updateNonEmptyMauthDeptById(MauthDept enti){
        return mauthDeptDao.updateNonEmptyMauthDeptById(enti);
    }

    public MauthDeptDao getMauthDeptDao() {
        return this.mauthDeptDao;
    }

    public void setMauthDeptDao(MauthDeptDao mauthDeptDao) {
        this.mauthDeptDao = mauthDeptDao;
    }

}