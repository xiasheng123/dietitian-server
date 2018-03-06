package com.xiasheng.medical.dietitian.biz.service.impl;

import com.xiasheng.medical.dietitian.api.constants.SexEnum;
import com.xiasheng.medical.dietitian.api.dto.UserDTO;
import com.xiasheng.medical.dietitian.api.service.UserService;
import com.xiasheng.medical.dietitian.api.utils.IResponse;
import com.xiasheng.medical.dietitian.biz.dao.UserDao;
import com.xiasheng.medical.dietitian.biz.entity.UserEntity;
import com.xiasheng.medical.dietitian.biz.utils.NickNameGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by fu on 2018/3/5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public IResponse addUser(String phone, String password) {
        UserEntity userEntity = userDao.findByPhone(phone);
        if (userEntity != null) {
            return IResponse.fail("该手机号已被注册","该手机号已被注册");
        }
        UserEntity entity = new UserEntity();
        entity.setPhone(phone);
        //TODO 密码加入MD5
        entity.setPassword(password);
        //TODO 生成appKey
        entity.setAppKey("123456");
        //TODO 随机生成昵称
        entity.setNickName(NickNameGenerator.generate(phone));
        userDao.insert(entity);
        UserDTO userDTO = new UserDTO();
        userDTO.setPhone(entity.getPhone());
        userDTO.setAppKey(entity.getAppKey());
        return IResponse.success(userDTO);
    }

    @Override
    public IResponse updateUserInfo(UserDTO userInfoDTO) {
        String appKey = userInfoDTO.getAppKey();
        UserEntity userEntity = userDao.findByAppKey(appKey);
        if (userEntity == null) {
            return IResponse.fail("请重新登录","请重新登录");
        }
        userEntity.setNickName(userInfoDTO.getNickName());
        userEntity.setRealName(userInfoDTO.getRealName());
        userEntity.setBirthday(userInfoDTO.getBirthday());
        userEntity.setSex(userEntity.getSex());
        userDao.updateUser(userEntity);
        return IResponse.success(userInfoDTO);
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
    public UserDTO getUserByAppKey(String appKey) {
        return null;
    }

    @Override
    public IResponse login(String phone, String password) {
        UserEntity userEntity = userDao.findByPhone(phone);
        if (userEntity == null) {
            return IResponse.fail("用户不存在","用户不存在");
        }
        //TODO 加入MD5
        if (!userEntity.getPassword().equals(password)) {
            return IResponse.fail("密码错误","密码错误");
        }
        //TODO 生成新的appKey
        UserDTO userDTO = new UserDTO();
        userDTO.setAppKey(userEntity.getAppKey());
        userDTO.setNickName(userEntity.getNickName());
        userDTO.setPhone(userEntity.getPhone());
        userDTO.setRealName(userEntity.getRealName());
        userDTO.setBirthday(userEntity.getBirthday());
        userDTO.setSex(userEntity.getSex());
        userDTO.setSexStr(SexEnum.getValue(userEntity.getSex()).getDesc());
        //TODO 加入计算level的逻辑
        userDTO.setLevel(1);
        return IResponse.success(userDTO);
    }
}
