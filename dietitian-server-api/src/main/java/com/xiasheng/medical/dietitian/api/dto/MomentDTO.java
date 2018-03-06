package com.xiasheng.medical.dietitian.api.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by fu on 2018/3/6.
 */
@Data
public class MomentDTO {

    private int userId;

    private int categoryId;

    private String content;

    private List<String> thumbnailUrls;

    private List<String> imageUrls;

    private List<MomentCommentDTO> comments;

}
