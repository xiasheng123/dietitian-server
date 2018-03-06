package com.xiasheng.medical.dietitian.biz.dao;

import com.xiasheng.medical.dietitian.biz.entity.PushNewsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fu on 2018/3/5.
 */
public interface PushNewsDao {

    PushNewsEntity loadById(@Param("id") int id);

    void insert(@Param("entity") PushNewsEntity entity);

    List<PushNewsEntity> findAll();
}
