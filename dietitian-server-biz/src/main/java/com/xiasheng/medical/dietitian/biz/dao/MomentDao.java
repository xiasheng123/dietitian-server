package com.xiasheng.medical.dietitian.biz.dao;

import com.xiasheng.medical.dietitian.biz.entity.MomentCommentEntity;
import com.xiasheng.medical.dietitian.biz.entity.MomentEntity;
import com.xiasheng.medical.dietitian.biz.entity.MomentPicMappingEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fu on 2018/3/5.
 */
public interface MomentDao {

    MomentEntity loadById(@Param("id") int id);

    void insert(@Param("entity") MomentEntity entity);

    void insertPic(@Param("entity")MomentPicMappingEntity entity);

    void insertComment(@Param("entity")MomentCommentEntity entity);

    List<MomentEntity> findByUserId(@Param("userId") int userId);

    List<MomentCommentEntity> findCommentsByMomentId(@Param("momentId") int momentId);

    List<MomentPicMappingEntity> findPicsByMomentId(@Param("momentId") int momentId);
}
