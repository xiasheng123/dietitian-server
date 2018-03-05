package com.xiasheng.medical.dietitian.biz.service.impl;

import com.xiasheng.medical.dietitian.api.service.UserService;
import com.xiasheng.medical.dietitian.biz.dao.UserDao;
import com.xiasheng.medical.dietitian.biz.entity.UserEntity;

import javax.annotation.Resource;

/**
 * Created by fu on 2018/3/5.
 */
public class UserImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void addUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPhone("13511112222");
        userDao.insert(userEntity);
    }
}
