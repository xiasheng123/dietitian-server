package com.xiasheng.medical.dietitian.biz.dao;

import com.xiasheng.medical.dietitian.biz.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fu on 2018/3/5.
 */
public interface UserDao {

    void insert(@Param("entity") UserEntity entity);

    UserEntity loadById(@Param("id") int id);

    UserEntity findByPhone(@Param("phone") String phone);
}
