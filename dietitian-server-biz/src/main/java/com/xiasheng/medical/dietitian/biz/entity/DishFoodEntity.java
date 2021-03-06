package com.xiasheng.medical.dietitian.biz.entity;

import lombok.Data;

/**
 * Created by fu on 2018/3/5.
 */
@Data
public class DishFoodEntity {

    private int id;

    private int foodId;

    private String foodName;

    private String amountDesc;

    private int recipeId;

    /**
     * 1：早餐
     * 2：午餐
     * 3：晚餐
     * 4：加餐
     */
    private int mealType;
}
