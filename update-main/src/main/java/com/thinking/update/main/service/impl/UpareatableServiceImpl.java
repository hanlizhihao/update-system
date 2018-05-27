package com.thinking.update.main.service.impl;
import java.util.List;
import com.thinking.update.main.dao.UpareatableDao;
import com.thinking.update.main.entity.Upareatable;
import com.thinking.update.main.service.UpareatableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UpareatableServiceImpl implements UpareatableService{
    @Autowired
    private UpareatableDao upareatableDao;
    @Override
    public long getUpareatableRowCount(){
        return upareatableDao.getUpareatableRowCount();
    }
    @Override
    public List<Upareatable> selectUpareatable(){
        return upareatableDao.selectUpareatable();
    }
    @Override
    public Upareatable selectUpareatableByObj(Upareatable obj){
        return upareatableDao.selectUpareatableByObj(obj);
    }
    @Override
    public Upareatable selectUpareatableById(Object id){
        return upareatableDao.selectUpareatableById(id);
    }
    @Override
    public int insertUpareatable(Upareatable value){
        return upareatableDao.insertUpareatable(value);
    }
    @Override
    public int insertNonEmptyUpareatable(Upareatable value){
        return upareatableDao.insertNonEmptyUpareatable(value);
    }
    @Override
    public int insertUpareatableByBatch(List<Upareatable> value){
        return upareatableDao.insertUpareatableByBatch(value);
    }
    @Override
    public int deleteUpareatableById(Object id){
        return upareatableDao.deleteUpareatableById(id);
    }
    @Override
    public int updateUpareatableById(Upareatable enti){
        return upareatableDao.updateUpareatableById(enti);
    }
    @Override
    public int updateNonEmptyUpareatableById(Upareatable enti){
        return upareatableDao.updateNonEmptyUpareatableById(enti);
    }

    public UpareatableDao getUpareatableDao() {
        return this.upareatableDao;
    }

    public void setUpareatableDao(UpareatableDao upareatableDao) {
        this.upareatableDao = upareatableDao;
    }

}