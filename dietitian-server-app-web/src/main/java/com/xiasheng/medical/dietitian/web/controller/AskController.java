package com.xiasheng.medical.dietitian.web.controller;

import com.xiasheng.medical.dietitian.web.controller.base.BaseController;
import com.xiasheng.medical.dietitian.web.utils.WebResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fu on 2018/3/7.
 */
@Controller
@RequestMapping(value = "/ask")
public class AskController extends BaseController {

    @RequestMapping(value = "/myAsk")
    @ResponseBody
    public WebResult myAsk(@RequestParam(value = "appKey") String appKey) {
        return null;
    }

    @RequestMapping(value = "/addAsk")
    @ResponseBody
    public WebResult addAsk(@RequestParam(value = "appKey") String appKey) {
        return null;
    }
}
