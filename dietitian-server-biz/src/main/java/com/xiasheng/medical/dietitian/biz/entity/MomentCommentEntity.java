package com.xiasheng.medical.dietitian.biz.entity;

import lombok.Data;

/**
 * Created by fu on 2018/3/5.
 */
@Data
public class MomentCommentEntity {

    private int id;

    private int dietitianId;

    private String content;

    private int momentId;

}
