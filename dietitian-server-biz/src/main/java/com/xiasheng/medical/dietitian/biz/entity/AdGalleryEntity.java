package com.xiasheng.medical.dietitian.biz.entity;

import lombok.Data;

/**
 * Created by fu on 2018/3/5.
 */
@Data
public class AdGalleryEntity {

    private int id;

    private String imageUrl;

    private String detailUrl;

    private int sort;

    private int activateStatus;

}
