package com.xiasheng.medical.dietitian.biz.service.impl;

import com.google.common.collect.Lists;
import com.xiasheng.medical.dietitian.api.dto.ReportKidneyDTO;
import com.xiasheng.medical.dietitian.api.service.ReportService;
import com.xiasheng.medical.dietitian.api.utils.IResponse;
import com.xiasheng.medical.dietitian.biz.dao.ReportKidneyDao;
import com.xiasheng.medical.dietitian.biz.dao.UserDao;
import com.xiasheng.medical.dietitian.biz.entity.ReportKidneyEntity;
import com.xiasheng.medical.dietitian.biz.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fu on 2018/3/7.
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportKidneyDao reportKidneyDao;

    @Autowired
    private UserDao userDao;

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

    @Override
    public IResponse addKidneyReport(ReportKidneyDTO reportKidneyDTO) {
        UserEntity userEntity = userDao.loadById(reportKidneyDTO.getUserId());
        if (userEntity == null) {
            return IResponse.fail("用户不存在");
        }
        ReportKidneyEntity reportKidneyEntity = new ReportKidneyEntity();
        reportKidneyEntity.setUserId(reportKidneyDTO.getUserId());
        reportKidneyEntity.setBloodProtein(reportKidneyDTO.getBloodProtein());
        reportKidneyEntity.setCreatinine(reportKidneyDTO.getCreatinine());
        reportKidneyDao.insert(reportKidneyEntity);
        return IResponse.success("done");
    }

    @Override
    public List<ReportKidneyDTO> getKidneyReportByUserId(int userId) {
        List<ReportKidneyDTO> reportKidneyDTOList = Lists.newArrayList();
        List<ReportKidneyEntity> reportKidneyEntityList = reportKidneyDao.findByUserId(userId);
        for (ReportKidneyEntity reportKidneyEntity : reportKidneyEntityList) {
            ReportKidneyDTO reportKidneyDTO = new ReportKidneyDTO();
            reportKidneyDTO.setUserId(reportKidneyEntity.getUserId());
            reportKidneyDTO.setCreatinine(reportKidneyEntity.getCreatinine());
            reportKidneyDTO.setBloodProtein(reportKidneyEntity.getBloodProtein());
            reportKidneyDTO.setReportTime(reportKidneyEntity.getReportTime());
            reportKidneyDTOList.add(reportKidneyDTO);
        }
        return reportKidneyDTOList;
    }
}
