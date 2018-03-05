package com.xiasheng.medical.dietitian.web.controller;

import com.xiasheng.medical.dietitian.web.controller.base.BaseController;
import com.xiasheng.medical.dietitian.web.utils.WebResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fu on 2018/3/5.
 */

@Slf4j
@Controller
@RequestMapping(value = "/recipe")
public class RecipeController extends BaseController {

    @RequestMapping(value = "/getrecipe")
    @ResponseBody
    public WebResult getRecipe(@RequestParam(value = "appKey") String appKey) {

        return WebResult.success("heheh");
    }
}
