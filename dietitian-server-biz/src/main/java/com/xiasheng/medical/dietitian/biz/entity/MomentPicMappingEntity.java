package com.xiasheng.medical.dietitian.biz.entity;

import lombok.Data;

/**
 * Created by fu on 2018/3/5.
 */
@Data
public class MomentPicMappingEntity {

    private int id;

    private int momentId;

    private String imageUrl;

    private String thumbnailUrl;

    private int sort;

}
