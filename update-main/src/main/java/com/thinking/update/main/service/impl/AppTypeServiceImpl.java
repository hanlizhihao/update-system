package com.thinking.update.main.service.impl;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.dao.AppTypeDao;
import com.thinking.update.main.domain.entity.AppType;
import com.thinking.update.main.domain.model.EnumVo;
import com.thinking.update.main.service.AppTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class AppTypeServiceImpl implements AppTypeService{
    @Resource
    private AppTypeDao appTypeDao;
    @Override
    public long getAppTypeRowCount(){
        return appTypeDao.getAppTypeRowCount();
    }
    @Override
    public List<AppType> selectAppType(){
        return appTypeDao.selectAppType();
    }
    @Override
    public AppType selectAppTypeByObj(AppType obj){
        return appTypeDao.selectAppTypeByObj(obj);
    }
    @Override
    public AppType selectAppTypeById(Long id){
        return appTypeDao.selectAppTypeById(id);
    }
    @Override
    public AppType insertAppType(AppType value){
        int result = appTypeDao.insertAppType(value);
        if (result == 1) {
            return value;
        }
        throw new BDException("Service添加App分类失败");
    }
    @Override
    public int insertNonEmptyAppType(AppType value){
        return appTypeDao.insertNonEmptyAppType(value);
    }
    @Override
    public int insertAppTypeByBatch(List<AppType> value){
        return appTypeDao.insertAppTypeByBatch(value);
    }
    @Override
    public int deleteAppTypeById(Long id){
        return appTypeDao.deleteAppTypeById(id);
    }
    @Override
    public int updateAppTypeById(AppType enti){
        return appTypeDao.updateAppTypeById(enti);
    }
    @Override
    public int updateNonEmptyAppTypeById(AppType enti){
        return appTypeDao.updateNonEmptyAppTypeById(enti);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<EnumVo> getAppTypeList() {
        List<EnumVo> enumVoList = new LinkedList<>();
        List<AppType> appTypes = appTypeDao.selectAppType();
        if (!CollectionUtils.isEmpty(appTypes)) {
            appTypes.forEach(appType -> {
                EnumVo enumVo = EnumVo.builder()
                        .title(appType.getTypeName())
                        .value(appType.getId().toString())
                        .build();
                enumVoList.add(enumVo);
            });
            return enumVoList;
        }
        return null;
    }

    public AppTypeDao getAppTypeDao() {
        return this.appTypeDao;
    }

    public void setAppTypeDao(AppTypeDao appTypeDao) {
        this.appTypeDao = appTypeDao;
    }

}