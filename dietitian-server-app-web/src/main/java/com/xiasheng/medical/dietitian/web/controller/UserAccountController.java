package com.xiasheng.medical.dietitian.web.controller;

import com.xiasheng.medical.dietitian.api.service.UserService;
import com.xiasheng.medical.dietitian.api.utils.IResponse;
import com.xiasheng.medical.dietitian.web.controller.base.BaseController;
import com.xiasheng.medical.dietitian.web.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fu on 2018/3/5.
 */
@Controller
@RequestMapping(value = "/account")
public class UserAccountController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public WebResult login(@RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password) {
        IResponse response = userService.login(phone, password);
        if (response.isSuccess()) {
            return WebResult.success(response.getData());
        }
        return WebResult.fail(response.getErrorMsg());
    }

    //注册

    //设置基本信息

    //修改密码
}
