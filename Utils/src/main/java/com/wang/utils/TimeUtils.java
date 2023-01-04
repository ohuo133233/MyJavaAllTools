package com.wang.utils;

import java.text.SimpleDateFormat;

public class TimeUtils {

    /**
     * 快速的获取当前时间
     *
     * @return 当前时间
     */
    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(System.currentTimeMillis());
    }


}
