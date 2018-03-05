package com.xiasheng.medical.dietitian.api.service;

import com.xiasheng.medical.dietitian.api.dto.RecipeDTO;

import java.util.List;

/**
 * Created by fu on 2018/3/5.
 */

public interface RecipeService {

    /**
     *
     * @param creatinine 肌酐
     * @param bloodProtein 血蛋白
     * @return
     */
    RecipeDTO getRandomRecipe(int creatinine, int bloodProtein);

    /**
     * 获取符合条件的所有食谱
     * @param creatinine 肌酐
     * @param bloodProtein 血蛋白
     * @return
     */
    List<RecipeDTO> getRecipeList(int creatinine, int bloodProtein);
}
