package com.xiasheng.medical.dietitian.api.dto;

import lombok.Data;

/**
 * Created by fu on 2018/3/6.
 */
@Data
public class DishFoodDTO {

    private String foodName;

    private String amountDesc;

    /**
     * 1：早餐
     * 2：午餐
     * 3：晚餐
     * 4：加餐
     */
    private int mealType;

    private String mealName;

}
