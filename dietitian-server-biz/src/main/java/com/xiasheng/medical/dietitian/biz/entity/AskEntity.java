package com.xiasheng.medical.dietitian.biz.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by fu on 2018/3/5.
 */
@Data
public class AskEntity {

    private int id;

    private String title;

    /**
     * 0：未解决
     * 1：已解决
     */
    private int solvedStatus;

    private int likeCount;

    private Date askDate;

    private int userId;

    /**
     * 0：审核未通过
     * 1：审核通过（默认）
     */
    private int censorStatus;

}
