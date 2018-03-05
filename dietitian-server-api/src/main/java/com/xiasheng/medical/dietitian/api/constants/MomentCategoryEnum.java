package com.xiasheng.medical.dietitian.api.constants;

/**
 * Created by fu on 2018/3/5.
 */
public enum MomentCategoryEnum {

    REPORT(1, "体检报告"),

    COOK(2, "膳食记录");

    private int value;

    private String desc;

    MomentCategoryEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static MomentCategoryEnum getValue(int value) {
        for (MomentCategoryEnum momentCategoryEnum : MomentCategoryEnum.values()) {
            if (momentCategoryEnum.getValue() == value) {
                return momentCategoryEnum;
            }
        }
        return null;
    }
}
