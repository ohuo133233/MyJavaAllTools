package com.example.tools;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;

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


    public static int getScreenWidth(Application application) {
        WindowManager wm = (WindowManager) application.getSystemService(Context.WINDOW_SERVICE);
        if (wm == null) return -1;
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            wm.getDefaultDisplay().getRealSize(point);
        } else {
            wm.getDefaultDisplay().getSize(point);
        }
        return point.x;
    }

    /**
     * Return the height of screen, in pixel.
     *
     * @return the height of screen, in pixel
     */
    public static int getScreenHeight(Application application) {
        WindowManager wm = (WindowManager) application.getSystemService(Context.WINDOW_SERVICE);
        if (wm == null) return -1;
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            wm.getDefaultDisplay().getRealSize(point);
        } else {
            wm.getDefaultDisplay().getSize(point);
        }
        return point.y;
    }
}
