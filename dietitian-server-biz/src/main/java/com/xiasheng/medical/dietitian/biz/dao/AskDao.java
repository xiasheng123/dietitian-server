package com.xiasheng.medical.dietitian.biz.dao;

import com.xiasheng.medical.dietitian.biz.entity.AskEntity;
import com.xiasheng.medical.dietitian.biz.entity.AskPostEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fu on 2018/3/5.
 */
public interface AskDao {

    AskEntity loadById(@Param("id") int id);

    void insert(@Param("entity") AskEntity entity);

    void insertAskPost(@Param("entity") AskPostEntity entity);

    List<AskEntity> findByUserId(@Param("userId") int userId);

    List<AskEntity> findByIds(@Param("ids") List<Integer> ids);

    List<AskEntity> findByFuzzyTitle(@Param("keyword") String keyword);

    void updateSolvedStatus(@Param("id") int id, @Param("solvedStatus") int solvedStatus);

    void updateLikeCount(@Param("id") int id, @Param("likeCount") int likeCount);

    Integer getRankCount(@Param("askId") int askId);

    List<AskPostEntity> getAskPost(@Param("askId") int askId, @Param("start") int start, @Param("size") int size, @Param("censorStatusList") List<Integer> censorStatusList);

    List<AskPostEntity> findByUserIdAndType(@Param("userId") int userId, @Param("userType") int userType);
}
