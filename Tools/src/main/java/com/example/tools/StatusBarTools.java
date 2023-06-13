package com.example.tools;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

public class StatusBarTools {

    private Activity activity;

    //初始化activity
    public StatusBarTools(Activity activity){
        this.activity = activity;
    }

    //将状态栏设置为传入的color
    public void setColor(int color){
        View view = activity.getWindow().getDecorView();
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        activity.getWindow().setStatusBarColor(activity.getResources().getColor(color));
    }


    public void setTransparent(){
        View view = activity.getWindow().getDecorView();
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    //隐藏状态栏
    public void hide(){
//        activity.getSupportActionBar().hide();
    }

    //设置状态栏字体颜色
    public void setTextColor(boolean isDarkBackground){
        View decor = activity.getWindow().getDecorView();
        if (isDarkBackground) {
            //黑暗背景字体浅色
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        } else {
            //高亮背景字体深色
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

}
