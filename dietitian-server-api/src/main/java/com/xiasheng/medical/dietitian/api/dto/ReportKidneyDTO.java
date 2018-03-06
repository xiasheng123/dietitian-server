package com.xiasheng.medical.dietitian.api.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by fu on 2018/3/7.
 */
@Data
public class ReportKidneyDTO {

    /**
     * 肌酐含量
     */
    private int creatinine;

    /**
     * 血蛋白含量
     */
    private int bloodProtein;

    private Date reportTime;
}
