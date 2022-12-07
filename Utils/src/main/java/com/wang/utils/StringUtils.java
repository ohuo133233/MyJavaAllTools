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


    /**
     * 去掉所有空格
     *
     * @param string 需要去掉空格的字符串
     * @return 去掉空格后的字符串
     */
    public static String removeAllSpace(String string) {
        return string.replaceAll(" +", "");
    }

    /**
     * 判断是否是HTTP格式
     *
     * @param string 需要判断的字符串
     * @return 返回是否是HTTP格式
     */
    public static boolean isHttp(String string) {
        // 判断是否是空的
        if (isEmpty(string)) {
            return false;
        }

        // 去首尾空格
        string = string.trim();

        // 把字符串转化为小写，后续判断就可以忽略大小写问题
        string = string.toLowerCase();

        // 判断是否包含http
        if (!string.contains("http")) {
            return false;
        }

        // 按http的分割
        String[] https = string.split("http");

        // 必须是第一个是http才是http
        if (https[0].equals("http")) {
            return true;
        }

        return false;
    }

}
