package com.xiasheng.medical.dietitian.biz;

import com.xiasheng.medical.dietitian.GenericTest;
import com.xiasheng.medical.dietitian.biz.dao.AdGalleryDao;
import com.xiasheng.medical.dietitian.biz.dao.RecipeDao;
import com.xiasheng.medical.dietitian.biz.entity.DishFoodEntity;
import com.xiasheng.medical.dietitian.biz.entity.RecipeEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fu on 2018/3/27.
 */
public class RecipeDaoTest extends GenericTest {
//TODO
    @Autowired
    private RecipeDao dao;

    @Test
    public void testInsert() {
        RecipeEntity entity = new RecipeEntity();
        dao.insertRecipe(entity);
        System.out.println(entity);
    }

    @Test
    public void testLoadById() {
        System.out.println(dao.loadById(1));
    }

    @Test
    public void testInsertDishFood() {
        DishFoodEntity entity = new DishFoodEntity();
        dao.insertDishFood(entity);
        System.out.println(entity);
    }

    @Test
    public void testFindDishFoodByRecipeId() {
        System.out.println(dao.findDishFoodByRecipeId(1));
    }

    @Test
    public void testFindRecipeInRange() {
        System.out.println(dao.findRecipeInRange(1,200,1,200));
    }

    @Test
    public void testDelDishFood() {
        dao.delDishFood(2);
    }
}
