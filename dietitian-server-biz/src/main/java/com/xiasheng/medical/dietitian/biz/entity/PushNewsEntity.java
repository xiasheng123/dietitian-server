package com.xiasheng.medical.dietitian.biz.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by fu on 2018/3/5.
 */
@Data
public class PushNewsEntity {

    private int id;

    private String title;

    private int clickCount;

    private String imageUrl;

    private Date newsDate;

    /**
     * 0：未发布
     * 1：已发布
     */
    private int editStatus;

    private String contentAbstract;

    private String detailUrl;

}
