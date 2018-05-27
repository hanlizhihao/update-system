package com.thinking.update.main.common.enums;

/**
 * @author Administrator
 */

public enum AppUpdateStateEnum {

    /**
     * 升级状态-0-下载中，5-下载完成，10-正在进行MD5校验，20-MD5校验失败，30-MD5校验成功，40-准备安装，
     * 50-开始安装，60-安装中，70-安装失败，80-安装完成，90-尝试启动主程序，100-程序启动中，
     * 110-启动失败，120-启动成功，130-正在验证主程序状态，140-验证成功，150-验证失败，
     * 160-监测程序是否可以上传数据，170-通过上传数据监测，180-未通过上传数据监测，190-通过所有验证升级完成，
     * 200-尝试重新安装，210-尝试回滚版本
     */
    DOWNLOADING(0, "下载中"),
    DOWNLOADED(5, "下载完成"),
    MD5_CHECKING(10, "正在进行MD5校验"),
    MD5_CHECK_FAILED(20, "MD5校验失败"),
    MD5_CHECK_SUCCESS(30, "MD5校验成功"),
    READY_INSTALL(40, "准备安装"),
    START_INSTALL(50, "开始安装"),
    INSTALLING(60, "安装中"),
    INSTALL_FAILED(70, "安装失败"),
    INSTALL_SUCCESS(80, "安装完成"),
    START_RUN(90, "尝试启动主程序"),
    STARTING_PROGRAM(100, "程序启动中"),
    START_fAILED(110, "启动失败"),
    START_SUCCESS(120, "启动成功"),
    CHECKING_PROGRAM(130, "正在验证主程序状态"),
    CHECK_SUCCESS(140, "验证成功"),
    CHECK_FAILED(150, "验证失败"),
    CHECK_UPLOAD(160, "监测程序是否可以上传数据"),
    CHECK_UPLOAD_SUCCESS(170, "通过上传数据监测"),
    CHECK_UPLOAD_FAIL(180, "未通过上传数据监测"),
    FINISHED(190, "通过所有验证升级完成"),
    REINSTALL(200, "尝试重新安装"),
    ROLLBACK_VERSION(210, "尝试回滚版本");

    private int value;

    private String name;
    AppUpdateStateEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
