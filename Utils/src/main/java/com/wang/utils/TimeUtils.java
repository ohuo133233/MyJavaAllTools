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

    /**
     * 把毫秒转为小时、分钟、秒
     * 列如:01:59:20
     *
     * @param milliseconds 传入毫秒
     * @return 转换的字符串
     */
    public String convertMilliseconds(long milliseconds) {
        // 计算小时、分钟和秒
        long hours = milliseconds / (60 * 60 * 1000);
        milliseconds %= (60 * 60 * 1000);
        long minutes = milliseconds / (60 * 1000);
        milliseconds %= (60 * 1000);
        long seconds = milliseconds / 1000;

        // 构建格式化的时间字符串
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        return time;
    }

}
