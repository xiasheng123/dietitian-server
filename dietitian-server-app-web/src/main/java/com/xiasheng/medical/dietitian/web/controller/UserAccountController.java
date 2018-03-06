package com.xiasheng.medical.dietitian.web.controller;

import com.xiasheng.medical.dietitian.api.dto.UserDTO;
import com.xiasheng.medical.dietitian.api.service.UserService;
import com.xiasheng.medical.dietitian.api.utils.IResponse;
import com.xiasheng.medical.dietitian.web.controller.base.BaseController;
import com.xiasheng.medical.dietitian.web.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fu on 2018/3/5.
 */
@Controller
@RequestMapping(value = "/account")
public class UserAccountController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public WebResult login(@RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password) {
        IResponse response = userService.login(phone, password);
        if (response.isSuccess()) {
            return WebResult.success(response.getData());
        }
        return WebResult.fail(response.getErrorMsg());
    }

    /**
     * 新用户注册
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public WebResult register(@RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password) {
        IResponse response = userService.addUser(phone, password);
        if (response.isSuccess()) {
            return WebResult.success(response.getData());
        }
        return WebResult.fail(response.getErrorMsg());
    }

    /**
     * 设置基本信息
     * @param nickName
     * @param realName
     * @param birthday
     * @param sex
     * @return
     */
    @RequestMapping(value = "/updateinfo")
    @ResponseBody
    public WebResult updateUserInfo(@RequestParam(value = "nickName") String nickName, @RequestParam(value = "realName") String realName,
                                    @RequestParam(value = "birthday") String birthday, @RequestParam(value = "sex") int sex) {
        UserDTO userDTO = new UserDTO();
        //userDTO.setAppKey(1234);
        userDTO.setNickName(nickName);
        userDTO.setRealName(realName);
        userDTO.setSex(sex);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(birthday);
            userDTO.setBirthday(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        IResponse response = userService.updateUserInfo(userDTO);
        if (response.isSuccess()) {
            return WebResult.success(response.getData());
        }
        return WebResult.fail(response.getErrorMsg());
    }

}
