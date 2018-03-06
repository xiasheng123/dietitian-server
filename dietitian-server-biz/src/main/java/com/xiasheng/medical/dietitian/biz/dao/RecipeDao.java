package com.xiasheng.medical.dietitian.biz.dao;

import com.xiasheng.medical.dietitian.biz.entity.DishFoodEntity;
import com.xiasheng.medical.dietitian.biz.entity.RecipeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fu on 2018/3/5.
 */
public interface RecipeDao {

    RecipeEntity loadById(@Param("id") int id);

    void insertRecipe(@Param("entity") RecipeEntity entity);

    List<RecipeEntity> findRecipeInRange(@Param("pStart") int pStart, @Param("pEnd") int pEnd,
                                             @Param("cStart") int cStart, @Param("cEnd") int cEnd);

    List<DishFoodEntity> findDishFoodByRecipeId(@Param("recipeId") int recipeId);

    void insertDishFood(@Param("entity") DishFoodEntity entity);

    void delDishFood(@Param("id") int id);

}
