package com.xiasheng.medical.dietitian.biz.dao;

import com.xiasheng.medical.dietitian.biz.entity.DietitianEntity;
import com.xiasheng.medical.dietitian.biz.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fu on 2018/3/5.
 */
public interface DietitianDao {

    DietitianEntity loadById(@Param("id") int id);

    void insert(@Param("entity") DietitianEntity entity);

    DietitianEntity findByPhone(@Param("phone") String phone);

    DietitianEntity findByAppKey(@Param("appKey") String appKey);

    void updateDietitian(@Param("entity") DietitianEntity entity);
}
