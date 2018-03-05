package com.xiasheng.medical.dietitian.biz.service.impl;

import com.xiasheng.medical.dietitian.api.dto.RecipeDTO;
import com.xiasheng.medical.dietitian.api.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fu on 2018/3/5.
 */
@Service
public class RecipeServiceImpl implements RecipeService {
    /**
     * @param creatinine   肌酐
     * @param bloodProtein 血蛋白
     * @return
     */
    @Override
    public RecipeDTO getRandomRecipe(int creatinine, int bloodProtein) {
        return null;
    }

    /**
     * 获取符合条件的所有食谱
     *
     * @param creatinine   肌酐
     * @param bloodProtein 血蛋白
     * @return
     */
    @Override
    public List<RecipeDTO> getRecipeList(int creatinine, int bloodProtein) {
        return null;
    }
}
