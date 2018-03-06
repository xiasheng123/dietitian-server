package com.xiasheng.medical.dietitian.biz.dao;

import com.xiasheng.medical.dietitian.biz.entity.AdGalleryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fu on 2018/3/5.
 */
public interface AdGalleryDao {

    AdGalleryEntity loadById(@Param("id") int id);

    void insert(@Param("entity") AdGalleryEntity entity);

    List<AdGalleryEntity> findAll();

}
