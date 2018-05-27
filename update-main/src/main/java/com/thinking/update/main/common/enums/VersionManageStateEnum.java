package com.thinking.update.main.common.enums;

/**
 * @author Administrator
 * @create 2018/5/27
 */
public enum VersionManageStateEnum {
    /**
     * 版本管理状态 0-未设置目标版本未确认，10-未设置目标已收到确认，20-已设置未确认，30-一致，40-不一致
     */
    UNSET_TARGET_VERSION(0, "未设置版本终端未确认"),
    UNSET_HAVE_CONFIRM(10, "未设置终端已确认"),
    SET_UNCONFIRMED(20, "已设置未确认"),
    IDENTICAL(30, "设置版本与终端一致"),
    DISAGREE(40, "设置版本与终端不一致");

    private int value;

    private String name;
    VersionManageStateEnum(int value, String name) {
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
