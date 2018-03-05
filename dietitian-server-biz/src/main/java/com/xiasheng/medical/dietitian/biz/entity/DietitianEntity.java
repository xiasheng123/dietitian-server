package com.xiasheng.medical.dietitian.biz.entity;

import lombok.Data;

/**
 * Created by fu on 2018/3/5.
 */
@Data
public class DietitianEntity {

    private int id;

    private String realName;

    private String phone;

    private String password;

    private String title;

    private int hospitalId;

}
