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

    void insertContent(@Param("pushNewsId") int pushNewsId, @Param("content") String content);

    List<PushNewsEntity> findAll();

    List<PushNewsEntity> findNews(@Param("editStatusList") List<Integer> editStatusList, @Param("start") int start, @Param("size") int size);

    String loadContent(@Param("pushNewsId") int pushNewsId);

    void updateNews(@Param("entity") PushNewsEntity entity);
}
