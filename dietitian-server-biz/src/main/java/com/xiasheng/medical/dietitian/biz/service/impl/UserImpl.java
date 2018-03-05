package com.xiasheng.medical.dietitian.biz.service.impl;

import com.xiasheng.medical.dietitian.api.dto.UserDTO;
import com.xiasheng.medical.dietitian.api.service.UserService;
import com.xiasheng.medical.dietitian.api.utils.IResponse;
import com.xiasheng.medical.dietitian.biz.dao.UserDao;
import com.xiasheng.medical.dietitian.biz.entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by fu on 2018/3/5.
 */
@Service
public class UserImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public IResponse addUser(String phone, String password) {
        return null;
    }

    @Override
    public IResponse updateUserInfo(UserDTO userInfoDTO) {
        return null;
    }

    @Override
    public UserDTO getUserByUserId(int userId) {
        return null;
    }

    @Override
    public String getAppKey(int userId) {
        return null;
    }

    @Override
    public UserDTO getUserAppKey(String appKey) {
        return null;
    }

    @Override
    public IResponse login(String phone, String password) {
        UserEntity userEntity = userDao.findByPhone(phone);
        if (userEntity == null) {
            return IResponse.fail("用户不存在","用户不存在");
        }
        //TODO 加入MD5
        if (userEntity.getPassword() != password) {
            return IResponse.fail("密码错误","密码错误");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setAppKey(userEntity.getAppKey());
        userDTO.setNickName(userEntity.getNickName());
        userDTO.setPhone(userEntity.getPhone());
        userDTO.setRealName(userEntity.getRealName());
        userDTO.setBirthday(userEntity.getBirthday());
        userDTO.setSex(userEntity.getSex());
        //TODO 加入计算level的逻辑
        userDTO.setLevel(1);
        return IResponse.success(userDTO);
    }
}
