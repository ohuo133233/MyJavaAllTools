package com.wang.utils;

public class StringUtils {

    /**
     * 增强判空
     * 1.当String是null
     * 2.当String是字符串null，并且忽略大小写
     * 3.当String长度为0，并且是去除空格下
     *
     * @param string 需要判空的字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String string) {
        return string != null && string.trim().isEmpty() && !string.equalsIgnoreCase("null");
    }





}
