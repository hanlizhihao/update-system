package com.thinking.update.main.common.enums;

/**
 * @author Administrator
 * @create 2018/6/6
 */
public enum VersionLogStateEnum {

    /**
     * 版本变更状态0-升级中，1-升级完成，2-升级失败
     */
    UPDATING(0, "升级中"),
    UPDATE_FINISHED(1, "升级完成"),
    UPDATE_FAILED(2, "升级失败");

    private int value;

    private String name;

    VersionLogStateEnum(int value, String name) {
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
