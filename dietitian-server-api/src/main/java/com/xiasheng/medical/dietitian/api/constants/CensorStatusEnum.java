package com.xiasheng.medical.dietitian.api.constants;

/**
 * Created by fu on 2018/3/5.
 */
public enum CensorStatusEnum {

    APPROVED(1, "审核通过"),

    UNAPPROVED(0, "审核未通过");

    private int value;

    private String desc;

    CensorStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static CensorStatusEnum getValue(int value) {
        for (CensorStatusEnum censorStatusEnum : CensorStatusEnum.values()) {
            if (censorStatusEnum.getValue() == value) {
                return censorStatusEnum;
            }
        }
        return null;
    }
}
