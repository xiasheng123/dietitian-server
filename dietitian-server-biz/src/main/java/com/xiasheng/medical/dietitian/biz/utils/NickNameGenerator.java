package com.xiasheng.medical.dietitian.biz.utils;

/**
 * Created by fu on 2018/3/6.
 */
public class NickNameGenerator {

    public static String generate(String phone) {
        //TODO 使用MD5作用于phone
        String name = "yys" + phone;
        return name;
    }
}
