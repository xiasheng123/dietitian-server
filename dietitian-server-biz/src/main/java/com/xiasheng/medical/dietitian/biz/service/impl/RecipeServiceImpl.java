package com.xiasheng.medical.dietitian.biz.service.impl;

import com.google.common.collect.Lists;
import com.xiasheng.medical.dietitian.api.constants.MealTypeEnum;
import com.xiasheng.medical.dietitian.api.dto.DishFoodDTO;
import com.xiasheng.medical.dietitian.api.dto.RecipeDTO;
import com.xiasheng.medical.dietitian.api.service.RecipeService;
import com.xiasheng.medical.dietitian.biz.dao.RecipeDao;
import com.xiasheng.medical.dietitian.biz.entity.DishFoodEntity;
import com.xiasheng.medical.dietitian.biz.entity.RecipeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by fu on 2018/3/5.
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeDao recipeDao;

    /**
     * @param creatinine   肌酐
     * @param bloodProtein 血蛋白
     * @return
     */
    @Override
    public RecipeDTO getRandomRecipe(int creatinine, int bloodProtein) {
        List<RecipeDTO> recipeDTOList = getRecipeList(creatinine, bloodProtein);
        Random rand = new Random();
        int index = rand.nextInt(recipeDTOList.size());
        return recipeDTOList.get(index);
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
        //TODO 根据肌酐和血蛋白 确定下列几个参数
        int pStart = 30;
        int pEnd = 40;
        int cStart = 1200;
        int cEnd = 1700;
        List<RecipeEntity> recipeEntityList = recipeDao.findRecipeInRange(pStart, pEnd, cStart, cEnd);
        List<RecipeDTO> recipeDTOList = Lists.newArrayList();
        for (RecipeEntity entity : recipeEntityList) {
            RecipeDTO recipeDTO = new RecipeDTO();
            recipeDTO.setProteinContent(entity.getProteinContent());
            recipeDTO.setCalorieContent(entity.getCalorieContent());
            List<DishFoodEntity> dishFoodEntityList = recipeDao.findDishFoodByRecipeId(entity.getId());
            List<DishFoodDTO> breakfastList = Lists.newArrayList();
            List<DishFoodDTO> lunchList = Lists.newArrayList();
            List<DishFoodDTO> dinnerList = Lists.newArrayList();
            List<DishFoodDTO> extraList = Lists.newArrayList();
            for (DishFoodEntity dishFoodEntity : dishFoodEntityList) {
                if (dishFoodEntity.getMealType() == MealTypeEnum.BREAKFAST.getValue()) {
                    breakfastList.add(populateDishFoodDTO(dishFoodEntity, MealTypeEnum.BREAKFAST));
                }
                if (dishFoodEntity.getMealType() == MealTypeEnum.LUNCH.getValue()) {
                    lunchList.add(populateDishFoodDTO(dishFoodEntity, MealTypeEnum.LUNCH));
                }
                if (dishFoodEntity.getMealType() == MealTypeEnum.DINNER.getValue()) {
                    dinnerList.add(populateDishFoodDTO(dishFoodEntity, MealTypeEnum.DINNER));
                }
                if (dishFoodEntity.getMealType() == MealTypeEnum.EXTRA.getValue()) {
                    extraList.add(populateDishFoodDTO(dishFoodEntity, MealTypeEnum.EXTRA));
                }
            }
            recipeDTO.setBreakfastDishes(breakfastList);
            recipeDTO.setLunchDishes(lunchList);
            recipeDTO.setDinnerDishes(dinnerList);
            recipeDTO.setExtraDishes(extraList);
            recipeDTOList.add(recipeDTO);
        }
        return recipeDTOList;
    }

    private DishFoodDTO populateDishFoodDTO(DishFoodEntity dishFoodEntity, MealTypeEnum mealTypeEnum) {
        DishFoodDTO dishFoodDTO = new DishFoodDTO();
        dishFoodDTO.setMealType(mealTypeEnum.getValue());
        dishFoodDTO.setMealName(mealTypeEnum.getDesc());
        dishFoodDTO.setFoodName(dishFoodEntity.getFoodName());
        dishFoodDTO.setAmountDesc(dishFoodEntity.getAmountDesc());
        return  dishFoodDTO;
    }
}

