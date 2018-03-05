package com.xiasheng.medical.dietitian.api.constants;

/**
 * Created by fu on 2018/3/5.
 */
public enum AskPostTypeEnum {

    ASK(1, "提问"),

    ANSWER(2, "回答");

    private int value;

    private String desc;

    AskPostTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static AskPostTypeEnum getValue(int value) {
        for (AskPostTypeEnum askPostTypeEnum : AskPostTypeEnum.values()) {
            if (askPostTypeEnum.getValue() == value) {
                return askPostTypeEnum;
            }
        }
        return null;
    }
}
