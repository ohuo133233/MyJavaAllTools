package com.wang.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class DragScaleView extends ConstraintLayout {
    private final String TAG = "DragScaleView";
    private ImageView mImageView;

    public DragScaleView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public DragScaleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DragScaleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dragscale_view, this, true);
        mImageView = inflate.findViewById(R.id.image);

    }


    private float rawDownX;
    private float rawDownY;
    private float rawUpX;
    private float rawUpY;
    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                rawDownX = event.getRawX();
                rawDownY = event.getRawY();
                Log.e(TAG, "ACTION_DOWN rawDownX: " + rawDownX);
                Log.e(TAG, "ACTION_DOWN rawDownY: " + rawDownY);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "ACTION_MOVE");
//                long currentTime = Calendar.getInstance().getTimeInMillis();
//                if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
//                    lastClickTime = currentTime;
//                    setRotation(getRotation() + 90.0f);
//                }else {
//                    Log.w(TAG,"点击过快");
//                }


//                rawUpX = event.getRawX();
//                if (rawDownX > rawUpX) {
//                    setRotation(getRotation() + 1);
//                } else {
//                    setRotation(getRotation() - 1);
//                }
                rawUpX = event.getRawX();

                if (rawDownX > rawUpX) {
                    mImageView.setRotation(mImageView.getRotation() + 1);
                } else {
                    mImageView.setRotation(mImageView.getRotation() - 1);
                }


                break;
            case MotionEvent.ACTION_UP:
//                rawUpX = event.getRawX();
//                rawUpY = event.getRawY();
//                Log.e(TAG, "ACTION_DOWN rawUpX: " + rawUpX);
//                Log.e(TAG, "ACTION_DOWN rawUpY: " + rawUpY);
                Log.e(TAG, "Rotation" + mImageView.getRotation());
                if (rawDownX > rawUpX) {

                    if (mImageView.getRotation() >= 0 && mImageView.getRotation() <= 90) {
                        mImageView.setRotation(90);
                        return true;
                    }
                    if (mImageView.getRotation() >= 91 && mImageView.getRotation() <= 180) {
                        mImageView.setRotation(180);
                        return true;
                    }
                    if (mImageView.getRotation() >= 181 && mImageView.getRotation() <= 270) {
                        mImageView.setRotation(270);
                        return true;
                    }
                    if (mImageView.getRotation() > 270) {
                        mImageView.setRotation(0);
                        return true;
                    }
                } else {
                    if (mImageView.getRotation() <= 0 && mImageView.getRotation() >= -90) {
                        mImageView.setRotation(-90);
                        return true;
                    }
                    if (mImageView.getRotation() <= -91 && mImageView.getRotation() >= -180) {
                        mImageView.setRotation(-180);
                        return true;
                    }
                    if (mImageView.getRotation() <= -181 && mImageView.getRotation() >= -270) {
                        mImageView.setRotation(-270);
                        return true;
                    }
                    if (mImageView.getRotation() < -270) {
                        mImageView.setRotation(0);
                        return true;
                    }
                }


                break;
        }
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}