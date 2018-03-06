package com.xiasheng.medical.dietitian.api.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by fu on 2018/3/6.
 */
@Data
public class UserDTO {

    private int id;

    private String phone;

    private String nickName;
    /**
     * 1:男
     * 2：女
     */
    private int sex;

    private String sexStr;

    private String realName;

    private Date birthday;

    /**
     * 用户等级，根据登陆次数（活跃数）计算得出
     */
    private int level;

    private String appKey;
}
