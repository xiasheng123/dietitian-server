package com.xiasheng.medical.dietitian.web.controller;

import com.xiasheng.medical.dietitian.api.dto.RecipeDTO;
import com.xiasheng.medical.dietitian.api.dto.ReportKidneyDTO;
import com.xiasheng.medical.dietitian.api.dto.UserDTO;
import com.xiasheng.medical.dietitian.api.service.RecipeService;
import com.xiasheng.medical.dietitian.api.service.ReportService;
import com.xiasheng.medical.dietitian.api.service.UserService;
import com.xiasheng.medical.dietitian.web.controller.base.BaseController;
import com.xiasheng.medical.dietitian.web.utils.WebResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fu on 2018/3/5.
 */

@Controller
@RequestMapping(value = "/recipe")
public class RecipeController extends BaseController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/getrecipe")
    @ResponseBody
    public WebResult getRecipe(@RequestParam(value = "appKey") String appKey) {
        //TODO
        UserDTO userDTO = getUserDTO(appKey);
        if (userDTO == null) {
            WebResult.fail("请重新登录！");
        }
        ReportKidneyDTO reportKidneyDTO = reportService.getLatestKidneyReport(userDTO.getId());
        if (reportKidneyDTO == null) {
            WebResult.fail("无体检记录！");
        }
        RecipeDTO recipeDTO = recipeService.getRandomRecipe(reportKidneyDTO.getCreatinine(), reportKidneyDTO.getBloodProtein());
        if (recipeDTO == null) {
            WebResult.fail("无合适食谱！");
        }
        return WebResult.success(recipeDTO);
    }
}
