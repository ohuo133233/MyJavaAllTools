package com.wang.demo.surface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.wang.demo.R;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder holder;
    private RenderThread renderThread;
    private Paint mPaint;
    // 控制绘制的开关
    private boolean isDraw = false;
    private Bitmap mMapBitmap;
    private String TAG = "GameView";

    public GameView(Context context) {
        super(context);
        init();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        holder = this.getHolder();
        holder.addCallback(this);
        renderThread = new RenderThread();
        initPaint();
        initMap();


    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
    }

    private void initMap() {
        mMapBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.root);
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDraw = true;
        renderThread.start();

        int mWidth = getMeasuredWidth();
        int mHeight = getMeasuredHeight();
        Log.d(TAG, "mWidth: " + mWidth);
        Log.d(TAG, "mHeight: " + mHeight);

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDraw = false;

    }

    /**
     * 绘制界面的线程
     *
     * @author Administrator
     */
    private class RenderThread extends Thread {
        @Override
        public void run() {
            super.run();
            // 不停绘制界面
            while (isDraw) {
                drawUI();
            }

        }
    }

    /**
     * 界面绘制
     */
    public void drawUI() {
        Canvas canvas = holder.lockCanvas();
        try {
            drawCanvas(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            holder.unlockCanvasAndPost(canvas);
        }
    }

    private void drawCanvas(Canvas canvas) {
        // 在 canvas 上绘制需要的图形
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(mMapBitmap, X, Y, mPaint);
    }

    private float X;
    private float Y;
    private float RawX;
    private float RawY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_MOVE:
                X = event.getX();
                Y = event.getY();
                RawX = event.getRawX();
                RawY = event.getRawY();
                Log.d(TAG, "x: " + X);
                Log.d(TAG, "y: " + Y);
                Log.d(TAG, "rawX: " + RawX);
                Log.d(TAG, "rawY: " + RawY);


                break;

        }
        return true;
    }
}
