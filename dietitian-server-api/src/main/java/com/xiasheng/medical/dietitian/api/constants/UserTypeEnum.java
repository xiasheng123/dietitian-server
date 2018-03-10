package com.xiasheng.medical.dietitian.api.constants;

/**
 * Created by fu on 2018/3/7.
 */
public enum UserTypeEnum {

    USER(1, "普通用户"),

    DIETITIAN(2, "营养师");

    private int value;

    private String desc;

    UserTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static UserTypeEnum getValue(int value, String desc) {
        for (UserTypeEnum userTypeEnum : UserTypeEnum.values()) {
            if (userTypeEnum.getValue() == value) {
                return userTypeEnum;
            }
        }
        return null;
    }
}
