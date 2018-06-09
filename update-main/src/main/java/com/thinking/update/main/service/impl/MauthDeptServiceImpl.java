package com.thinking.update.main.service.impl;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.thinking.update.main.common.utils.SerializeUtil;
import com.thinking.update.main.config.RedisConfig;
import com.thinking.update.main.dao.MauthDeptDao;
import com.thinking.update.main.dao.VehicleDao;
import com.thinking.update.main.domain.entity.MauthDept;
import com.thinking.update.main.domain.entity.VehicleInfo;
import com.thinking.update.main.domain.model.TreeVo;
import com.thinking.update.main.service.MauthDeptService;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
@Slf4j
public class MauthDeptServiceImpl implements MauthDeptService, InitializingBean {
    @Resource
    private MauthDeptDao mauthDeptDao;
    @Resource
    private VehicleDao vehicleDao;
    @Resource
    private RedisConfig redisConfig;

    private Jedis redisClient;

    private TreeVo treeVo;

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

    @Override
    public TreeVo getAllTreeVo() {
        MauthDept firstDepart = new MauthDept();
        firstDepart.setLevel(0);
        firstDepart = mauthDeptDao.selectMauthDeptByObj(firstDepart);
        this.treeVo = getTree(firstDepart);
        return this.treeVo;
    }

    private TreeVo getTree(MauthDept dept) {
        TreeVo treeVo = new TreeVo();
        treeVo.setLabel(dept.getName());
        treeVo.setData(dept.getDeptId().toString());
        LinkedList<TreeVo> childes = new LinkedList<>();
        if (dept.getLevel() == 4) {
            List<VehicleInfo> vehicleInfoList = vehicleDao.selectVehicleByDeptId(dept.getDeptId());
            for (VehicleInfo info: vehicleInfoList) {
                TreeVo children = new TreeVo();
                children.setData(info.getDeviceId());
                children.setLabel(info.getVehicleNo());
                childes.add(children);
            }
            treeVo.setChildren(childes);
            return treeVo;
        }
        List<MauthDept> mauthDepts = getMauthUnderById(dept.getDeptId());
        if (!CollectionUtils.isEmpty(mauthDepts)) {
            for (MauthDept mauthDept: mauthDepts) {
                childes.add(getTree(mauthDept));
            }
        }
        treeVo.setChildren(childes);
        return treeVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<MauthDept> getMauthUnderById(Integer id) {
        List<MauthDept> mauthDepts = new ArrayList<>();
        if (id == null) {
            MauthDept mauthDept = new MauthDept();
            mauthDept.setLevel(0);
            mauthDepts.add(mauthDeptDao.selectMauthDeptByObj(mauthDept));
        } else {
            MauthDept mauthDept = mauthDeptDao.selectMauthDeptById(id);
            Integer level = mauthDept.getLevel() + 1;
            mauthDept.setLevel(level);
            mauthDepts = mauthDeptDao.selectBylftAndrgtAndLevel(mauthDept);
        }
        return mauthDepts;
    }

    public MauthDeptDao getMauthDeptDao() {
        return this.mauthDeptDao;
    }

    public void setMauthDeptDao(MauthDeptDao mauthDeptDao) {
        this.mauthDeptDao = mauthDeptDao;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        JedisPool pool = new JedisPool(new JedisPoolConfig(),redisConfig.getRedis().get("host"));
        redisClient = pool.getResource();
    }
}