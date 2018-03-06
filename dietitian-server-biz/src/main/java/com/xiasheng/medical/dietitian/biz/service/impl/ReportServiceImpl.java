package com.xiasheng.medical.dietitian.biz.service.impl;

import com.xiasheng.medical.dietitian.api.dto.ReportKidneyDTO;
import com.xiasheng.medical.dietitian.api.service.ReportService;
import com.xiasheng.medical.dietitian.biz.dao.ReportKidneyDao;
import com.xiasheng.medical.dietitian.biz.entity.ReportKidneyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fu on 2018/3/7.
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportKidneyDao reportKidneyDao;

    @Override
    public ReportKidneyDTO getLatestKidneyReport(int userId) {
        ReportKidneyEntity reportKidneyEntity = reportKidneyDao.findLatestReportByUserId(userId);
        if (reportKidneyEntity == null) {
            return null;
        }
        ReportKidneyDTO reportKidneyDTO = new ReportKidneyDTO();
        reportKidneyDTO.setBloodProtein(reportKidneyEntity.getBloodProtein());
        reportKidneyDTO.setCreatinine(reportKidneyEntity.getCreatinine());
        reportKidneyDTO.setReportTime(reportKidneyEntity.getReportTime());
        return reportKidneyDTO;
    }
}
