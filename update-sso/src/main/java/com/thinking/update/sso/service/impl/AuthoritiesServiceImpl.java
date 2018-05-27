package com.thinking.update.sso.service.impl;
import java.util.List;
import com.thinking.update.sso.dao.AuthoritiesDao;
import com.thinking.update.sso.domain.entity.Authorities;
import com.thinking.update.sso.service.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author Administrator
 */
@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{
    @Autowired
    private AuthoritiesDao authoritiesDao;
    @Override
    public long getAuthoritiesRowCount(){
        return authoritiesDao.getAuthoritiesRowCount();
    }
    @Override
    public List<Authorities> selectAuthorities(){
        return authoritiesDao.selectAuthorities();
    }
    @Override
    public Authorities selectAuthoritiesByObj(Authorities obj){
        return authoritiesDao.selectAuthoritiesByObj(obj);
    }
    @Override
    public Authorities selectAuthoritiesById(Long id){
        return authoritiesDao.selectAuthoritiesById(id);
    }
    @Override
    public int insertAuthorities(Authorities value){
        return authoritiesDao.insertAuthorities(value);
    }
    @Override
    public int insertNonEmptyAuthorities(Authorities value){
        return authoritiesDao.insertNonEmptyAuthorities(value);
    }
    @Override
    public int insertAuthoritiesByBatch(List<Authorities> value){
        return authoritiesDao.insertAuthoritiesByBatch(value);
    }
    @Override
    public int deleteAuthoritiesById(Long id){
        return authoritiesDao.deleteAuthoritiesById(id);
    }
    @Override
    public int updateAuthoritiesById(Authorities enti){
        return authoritiesDao.updateAuthoritiesById(enti);
    }
    @Override
    public int updateNonEmptyAuthoritiesById(Authorities enti){
        return authoritiesDao.updateNonEmptyAuthoritiesById(enti);
    }

    public AuthoritiesDao getAuthoritiesDao() {
        return this.authoritiesDao;
    }

    public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
        this.authoritiesDao = authoritiesDao;
    }

}