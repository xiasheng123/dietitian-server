package com.xiasheng.medical.dietitian.api.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by fu on 2018/3/7.
 */
@Data
public class AskPostDTO {

    private int askId;

    private int userId;

    private int userType;

    private String userName;

    private int rank;

    private String Content;

    /**
     * 1：提问
     * 2：回答
     */
    private int postType;

    private Date addTime;

}
