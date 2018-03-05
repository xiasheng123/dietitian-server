package com.xiasheng.medical.dietitian.biz.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by fu on 2018/3/5.
 */
@Data
public class ReportKidneyEntity {

    private int id;

    private int userId;

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
