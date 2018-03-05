package com.xiasheng.medical.dietitian.biz.entity;

import lombok.Data;

/**
 * Created by fu on 2018/3/5.
 */
@Data
public class MomentEntity {

    private int id;

    private int userId;

    private int categoryId;

    private String content;

    /**
     * 0：审核未通过
     * 1：审核通过（默认）
     */
    private int censorStatus;

}
