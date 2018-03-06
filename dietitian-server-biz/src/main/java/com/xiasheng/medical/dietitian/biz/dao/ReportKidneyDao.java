package com.xiasheng.medical.dietitian.biz.dao;

import com.xiasheng.medical.dietitian.biz.entity.ReportKidneyEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fu on 2018/3/5.
 */
public interface ReportKidneyDao {

    ReportKidneyEntity loadById(@Param("id") int id);

    void insert(@Param("entity") ReportKidneyEntity entity);

    List<ReportKidneyEntity> findByUserId(@Param("userId") int userId);

    ReportKidneyEntity findLatestReportByUserId(@Param("userId") int userId);
}
