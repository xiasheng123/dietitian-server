package com.xiasheng.medical.dietitian.api.dto;

import lombok.Data;

/**
 * Created by fu on 2018/3/6.
 */
@Data
public class MomentCommentDTO {

    private int dietitianId;

    private String dietitianName;

    private String dietitianTitle;

    private String content;
}
