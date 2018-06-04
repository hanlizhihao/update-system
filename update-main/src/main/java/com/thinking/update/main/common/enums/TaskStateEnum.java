package com.thinking.update.main.common.enums;

/**
 * @author Administrator
 * @create 2018/6/4
 */
public enum TaskStateEnum {
    /**
     * 任务状态 0-正在进行，1-已经删除，2-已经完成
     */
    NO_FINISHED(0),
    DELETE(1),
    FINISHED(2);

    private int value;
    TaskStateEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
