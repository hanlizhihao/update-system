package com.thinking.update.main.controller;

import com.github.pagehelper.PageInfo;
import com.thinking.update.main.common.annotation.PrintLog;
import com.thinking.update.main.common.utils.BeanCopyHelper;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.entity.Version;
import com.thinking.update.main.domain.model.*;
import com.thinking.update.main.service.VersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Administrator
 * @create 2018/5/28
 */
@Api(description = "应用安装程序和协议文件Api")
@RestController
@Slf4j
@ConfigurationProperties(prefix = "app")
public class VersionController extends BaseApplicationController {

    @Resource
    private VersionService versionService;

    @PrintLog("列表查询应用版本")
    @ApiOperation(value = "列表展示应用安装程序", notes = "列表查询应用版本", httpMethod = "GET")
    @GetMapping(value = "/version/list")
    public List<EnumVo> getVersionEnumList() {
        return versionService.getPackageList();
    }

    @PrintLog("列表查询协议")
    @ApiOperation(value = "列表展示协议文件", notes = "列表查询协议", httpMethod = "POST")
    @GetMapping(value = "/protocol/list")
    public List<EnumVo> getProtocolEnumList() {
        return versionService.getProtocolList();
    }

    @ApiOperation(value = "安装程序分页列表查询", notes = "安装程序分页列表查询", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", paramType = "query", value = "查询页号"),
            @ApiImplicitParam(name = "size", paramType = "query", value = "每页显示记录数")
    })
    @PrintLog("安装程序分页列表查询")
    @GetMapping(value = "/package/list")
    public PageInfo<PageVersionVo> getVersionPageList(Pageable pageable) {
        return new PageInfo<>(versionService.selectPackageByPage(pageable));
    }

    @PostMapping(value = "/upload")
    @ApiOperation(value = "上传安装程序或者协议", notes = "上传安装程序或者协议", httpMethod = "POST")
    public FileVo upload(MultipartFile file) throws IOException, NoSuchAlgorithmException {
        FileVo fileVo = new FileVo();
        byte[] fileByte = file.getBytes();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(fileByte);
        fileVo.setMd5(new BigInteger(1, digest).toString(16).toUpperCase());
        fileVo.setFileName(file.getOriginalFilename());
        fileVo.setFileSize(file.getSize());
        return versionService.uploadFile(fileVo, file);
    }

    @PrintLog("创建版本(安装程序或者协议)")
    @ApiOperation(value = "创建安装程序或者协议", notes = "创建安装程序或者协议", httpMethod = "POST")
    @PostMapping(value = "/version/create")
    public Version createVersion(@RequestBody VersionModel versionModel) {
        Version version = getVersion(versionModel);
        setCommonCreateFields(version);
        return versionService.insertNonEmptyVersion(version);
    }

    private Version getVersion(VersionModel versionModel) {
        double fileSizeMb = versionModel.getFileSize()/1024/1024;
        return Version.builder()
                    .fileName(versionModel.getFileName())
                    .versionName(versionModel.getVersionName())
                    .fileSize(fileSizeMb)
                    .md5Code(versionModel.getMd5())
                    .md5Name(versionModel.getRealName())
                    .remark(versionModel.getRemark())
                    .type(versionModel.getType())
                    .url(versionModel.getPath()).build();
    }

    @PrintLog("更新版本(安装程序或者协议)")
    @ApiOperation(value = "更新安装程序或协议", notes = "更新安装程序或协议", httpMethod = "POST")
    @PostMapping(value = "/version/update")
    public int updateVersion(@RequestBody VersionModel versionModel) {
        Version version = getVersion(versionModel);
        setCommonUpdateFields(version);
        return versionService.updateNonEmptyVersionById(version);
    }

    @PrintLog("删除版本 By id")
    @DeleteMapping(value = "/version/{id}")
    @ApiOperation(value = "根据Id删除版本 BY hlz", notes = "根据Id删除版本 BY hlz", httpMethod = "DELETE")
    public int deleteAppById(@PathVariable Long id) {
        return versionService.deleteVersionById(id);
    }

}
