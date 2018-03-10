package com.xiasheng.medical.dietitian.web.controller.base;

import com.xiasheng.medical.dietitian.api.dto.UserDTO;
import com.xiasheng.medical.dietitian.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fu on 2018/3/5.
 */

public abstract class BaseController {

    @Autowired
    private UserService userService;

    //TODO 后期改成在HttpRequest拿appKey 或者从cookie中
    public UserDTO getUserDTO(String appKey) {
        UserDTO userDTO = userService.getUserByAppKey(appKey);
        return userDTO;
    }
}
