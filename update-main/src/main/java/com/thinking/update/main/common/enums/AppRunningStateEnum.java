package com.thinking.update.main.common.enums;

import com.thinking.update.main.common.exception.BDException;

/**
 * @author Administrator
 */

public enum AppRunningStateEnum {

    /**
     * 终端运行状态0-正常，1-异常
     */
    NORMAL(0, "正常"),
    ABNORMAL(1, "异常");

    private int value;

    private String name;
    AppRunningStateEnum(int value, String name) {
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

    public static String getNameByValue(int value) {
        for (AppRunningStateEnum stateEnum: AppRunningStateEnum.values()) {
            if (stateEnum.getValue() == value) {
                return stateEnum.getName();
            }
        }
        throw new BDException("没有与Value相匹配的终端运行状态枚举");
    }
}
