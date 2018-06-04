package com.thinking.update.main.common.enums;

/**
 * @author Administrator
 * @create 2018/6/4
 */
public enum AppLockEnum {
    /**
     * 这个App应用是否处于一个升级任务中，0-没有，1-有
     */
    NO_LOCK(0),
    LOCKED(1);

    private int value;
    AppLockEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
