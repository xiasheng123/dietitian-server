package com.xiasheng.medical.dietitian.api.service;

import com.xiasheng.medical.dietitian.api.dto.ReportKidneyDTO;
import com.xiasheng.medical.dietitian.api.utils.IResponse;

import java.util.List;

/**
 * Created by fu on 2018/3/7.
 */
public interface ReportService {

    ReportKidneyDTO getLatestKidneyReport(int userId);

    IResponse addKidneyReport(ReportKidneyDTO reportKidneyDTO);

    List<ReportKidneyDTO> getKidneyReportByUserId(int userId);

}
