package com.example.tools;

import android.content.Context;
import android.content.res.Configuration;

public class ScreenTools {
    private static final String TAG = "ScreenTools";
    private static volatile ScreenTools instance = null;


    private ScreenTools() {

    }

    public static ScreenTools getInstance() {
        if (instance == null) {
            synchronized (ScreenTools.class) {
                if (instance == null) {
                    instance = new ScreenTools();
                }
            }
        }
        return instance;
    }

    /**
     * 获取当前屏幕是否是横屏（默认）
     */
    public boolean isCurOriLand(Context context) {
        boolean isLand = true;
        try {
            Configuration mConfiguration = context.getResources().getConfiguration(); //获取设置的配置信息
            int ori = mConfiguration.orientation; //获取屏幕方向
            if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {
                //横屏
                isLand = true;
            } else if (ori == mConfiguration.ORIENTATION_PORTRAIT) {
                //竖屏
                isLand = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isLand;
    }
}
