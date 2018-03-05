package com.xiasheng.medical.dietitian.api.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by fu on 2018/3/5.
 */
@Data
public class RecipeDTO {

    private int proteinContent;

    private int calorieContent;

    private List<DishFoodDTO> dishes;

}
