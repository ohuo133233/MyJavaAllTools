package com.example.tools;
import android.content.Context;

public class UITools {
    private static final String TAG = "UITools";
    private static volatile UITools instance = null;


    private UITools() {

    }

    public static UITools getInstance() {
        if (instance == null) {
            synchronized (UITools.class) {
                if (instance == null) {
                    instance = new UITools();
                }
            }
        }
        return instance;
    }
    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
