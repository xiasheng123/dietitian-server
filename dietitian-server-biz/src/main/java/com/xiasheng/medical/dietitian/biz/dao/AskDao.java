package com.xiasheng.medical.dietitian.biz.dao;

import com.xiasheng.medical.dietitian.biz.entity.AskEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fu on 2018/3/5.
 */
public interface AskDao {

    AskEntity loadById(@Param("id") int id);

    void insert(@Param("entity") AskEntity entity);

    List<AskEntity> findByUserId(@Param("userId") int userId);

    List<AskEntity> findByFuzzyTitle(@Param("keyword") String keyword);

    void updateSolvedStatus(@Param("id") int id, @Param("solvedStatus") int solvedStatus);

    void updateLikeCount(@Param("id") int id, @Param("likeCount") int likeCount);

 }
