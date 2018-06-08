package com.thinking.update.main.controller;

import com.thinking.update.main.common.annotation.PrintLog;
import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.dao.VersionDao;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.entity.Version;
import com.thinking.update.main.domain.model.*;
import com.thinking.update.main.service.AppActivityLogService;
import com.thinking.update.main.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Api(description = "远程应用Api")
@RestController
@Slf4j
@RequestMapping("/android")
public class MainController {

    @Resource
    private AppService appService;
    @Resource
    private AppActivityLogService activityLogService;
    @Resource
    private VersionDao versionDao;

    @ApiOperation(value = "终端查询设备版本信息", notes = "终端获取自己的版本信息", httpMethod = "POST")
    @PostMapping(value = "/info")
    public VersionVo getAppInfo(@Validated DeviceModel deviceModel, Errors errors) {
        if (errors.hasErrors()) {
            throw new BDException("参数校验失败");
        }
        return appService.getVersionInfo(deviceModel);
    }

    @ApiOperation(value = "终端发送版本变更信息", notes = "终端发送版本变更信息", httpMethod = "POST")
    @PostMapping(value = "/versionActivity")
    public ActivityVo versionActive(@Validated VersionActivityModel activityModel, Errors errors) {
        if (errors.hasErrors()) {
            throw new BDException("参数校验失败");
        }
        ActivityVo activityVo;
        activityVo = validateVersion(activityModel);
        if (activityVo != null) {
            return activityVo;
        }
        return appService.versionActive(activityModel);
    }

    private ActivityVo validateVersion(VersionActivityModel model) {
        App app = appService.selectAppById(model.getAppId());
        ActivityVo activityVo = new ActivityVo();
        List<Version> versions = new ArrayList<>();
        if (!app.getTargetVersionId().equals(model.getTargetVersionId())) {
            activityVo.setUpdateChange(true);
            versions.add(versionDao.selectVersionById(app.getTargetVersionId()));
            activityVo.setVersion(versions);
        }
        if (!app.getProtocolId().equals(model.getProtocolId())) {
            activityVo.setUpdateChange(true);
            versions.add(versionDao.selectVersionById(app.getProtocolId()));
            activityVo.setVersion(versions);
        }
        if (versions.isEmpty()) {
            return null;
        }
        return activityVo;
    }

    @PrintLog("上传日志")
    @PostMapping(value = "/logUpload")
    @ApiOperation(value = "上传日志文件", notes = "上传日志文件", httpMethod = "POST")
    public FileVo upload(MultipartFile file) throws IOException, NoSuchAlgorithmException {
        FileVo fileVo = new FileVo();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(file.getName().getBytes());
        fileVo.setMd5(new BigInteger(1, digest).toString(16).toUpperCase());
        fileVo.setFileName(file.getOriginalFilename());
        fileVo.setFileSize(file.getSize());
        return activityLogService.uploadLogFile(fileVo, file);
    }
}
