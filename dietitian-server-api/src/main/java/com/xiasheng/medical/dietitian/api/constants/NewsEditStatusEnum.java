package com.xiasheng.medical.dietitian.api.constants;

/**
 * Created by fu on 2018/3/5.
 */
public enum NewsEditStatusEnum {

    APPROVED(1, "已发布"),

    UNAPPROVED(0, "未发布");

    private int value;

    private String desc;

    NewsEditStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static NewsEditStatusEnum getValue(int value) {
        for (NewsEditStatusEnum newsEditStatusEnum : NewsEditStatusEnum.values()) {
            if (newsEditStatusEnum.getValue() == value) {
                return newsEditStatusEnum;
            }
        }
        return null;
    }
}
