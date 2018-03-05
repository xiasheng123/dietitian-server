package com.xiasheng.medical.dietitian.biz.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by fu on 2018/3/5.
 */
@Data
public class UserEntity {

    private int id;

    private String phone;

    private String password;

    /**
     * 1:男
     * 2：女
     */
    private int sex;

    private String realName;

    private Date birthday;

    private String appKey;

    private String nickName;

}
