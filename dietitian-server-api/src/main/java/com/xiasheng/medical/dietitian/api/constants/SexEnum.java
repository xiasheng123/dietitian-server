package com.xiasheng.medical.dietitian.api.constants;

/**
 * Created by fu on 2018/3/5.
 */
public enum SexEnum {

    MALE(1, "男"),

    FEMALE(2, "女");

    private int value;

    private String desc;

    SexEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static SexEnum getValue(int value) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getValue() == value) {
                return sexEnum;
            }
        }
        return null;
    }
}
