package com.thinking.update.main.common.enums;

public enum VersionTypeEnum{
    /**
     * 上传文件分类 0-安装程序，1-协议
     */
    INSTALL_PACKAGE(0),
    PROTOCOL(1);

    private int value;
    VersionTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
