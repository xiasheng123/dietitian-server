package com.xiasheng.medical.dietitian.api.constants;

/**
 * Created by fu on 2018/3/5.
 */
public enum MealTypeEnum {

    BREAKFAST(1, "早餐"),

    LUNCH(2, "午餐"),

    DINNER(3, "晚餐"),

    EXTRA(4, "加餐");

    private int value;

    private String desc;

    MealTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static MealTypeEnum getValue(int value) {
        for (MealTypeEnum mealTypeEnum : MealTypeEnum.values()) {
            if (mealTypeEnum.getValue() == value) {
                return mealTypeEnum;
            }
        }
        return null;
    }
}
