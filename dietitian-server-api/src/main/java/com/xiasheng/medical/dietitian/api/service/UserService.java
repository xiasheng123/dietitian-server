package com.xiasheng.medical.dietitian.api.service;

import com.xiasheng.medical.dietitian.api.dto.UserDTO;
import com.xiasheng.medical.dietitian.api.utils.IResponse;

/**
 * Created by fu on 2018/3/5.
 */
public interface UserService {

    IResponse addUser(String phone, String password);

    IResponse updateUserInfo(UserDTO userInfoDTO);

    UserDTO getUserByUserId(int userId);

    String getAppKey(int userId);

    UserDTO getUserAppKey(String appKey);

    IResponse login(String phone, String password);
}
