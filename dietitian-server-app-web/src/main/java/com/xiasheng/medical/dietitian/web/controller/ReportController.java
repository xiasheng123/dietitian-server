package com.xiasheng.medical.dietitian.web.controller;

import com.xiasheng.medical.dietitian.api.dto.ReportKidneyDTO;
import com.xiasheng.medical.dietitian.api.dto.UserDTO;
import com.xiasheng.medical.dietitian.api.service.ReportService;
import com.xiasheng.medical.dietitian.api.utils.IResponse;
import com.xiasheng.medical.dietitian.web.controller.base.BaseController;
import com.xiasheng.medical.dietitian.web.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by fu on 2018/3/7.
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController extends BaseController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/myReport")
    @ResponseBody
    public WebResult myReport(@RequestParam(value = "appKey") String appKey) {
        UserDTO userDTO = getUserDTO(appKey);
        if (userDTO == null) {
            return WebResult.fail("请重新登录");
        }
        List<ReportKidneyDTO> reportKidneyDTOList = reportService.getKidneyReportByUserId(userDTO.getId());
        return WebResult.success(reportKidneyDTOList);
    }

    @RequestMapping(value = "/addKidneyReport")
    @ResponseBody
    public WebResult addKidneyReport(@RequestParam(value = "appKey") String appKey,
                                     @RequestParam(value = "bloodProtein") int bloodProtein,
                                     @RequestParam(value = "creatinine") int creatinine) {

        UserDTO userDTO = getUserDTO(appKey);
        if (userDTO == null) {
            return WebResult.fail("请重新登录");
        }
        ReportKidneyDTO reportKidneyDTO = new ReportKidneyDTO();
        reportKidneyDTO.setBloodProtein(bloodProtein);
        reportKidneyDTO.setCreatinine(creatinine);
        reportKidneyDTO.setUserId(userDTO.getId());
        reportKidneyDTO.setReportTime(new Date());
        IResponse response = reportService.addKidneyReport(reportKidneyDTO);
        if (response.isSuccess()) {
            return WebResult.success("添加成功");
        } else {
            return WebResult.fail("添加失败");
        }
    }

}
