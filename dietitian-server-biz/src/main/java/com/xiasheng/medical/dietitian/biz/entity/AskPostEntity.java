package com.xiasheng.medical.dietitian.biz.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by fu on 2018/3/5.
 */
@Data
public class AskPostEntity {

    private int id;

    private int askId;

    private int userId;

    private int userType;

    private int rank;

    private String content;

    /**
     * 1：提问
     * 2：回答
     */
    private int postType;

    /**
     * 0：审核未通过
     * 1：审核通过（默认）
     */
    private int censorStatus;

    private Date addTime;
}
