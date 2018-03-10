package com.xiasheng.medical.dietitian.api.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by fu on 2018/3/6.
 */
@Data
public class PushNewsDTO {

    private int id;

    private String title;

    private int clickCount;

    private String imageUrl;

    private Date newsDate;

    private String contentAbstract;

    private String detailUrl;

    private String content;

    private int editStatus;

}
