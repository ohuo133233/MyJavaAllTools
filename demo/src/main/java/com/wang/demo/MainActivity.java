package com.wang.demo;

import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private float i = 0.1f;
    private String TAG = "MainActivity";
    private LottieAnimationView mLottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLottieAnimationView = findViewById(R.id.lottie_view);

        playStartLottieView();
    }

    private ValueAnimator valueAnimator;
    private ValueAnimator.AnimatorUpdateListener animatorUpdateListener;

    private void playStartLottieView() {
        releaseAnimatorUpdateListener();
        valueAnimator = ValueAnimator.ofFloat(0f, 1.0f);
        animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mLottieAnimationView.setProgress((float) animation.getAnimatedValue());
            }
        };
        valueAnimator.addUpdateListener(animatorUpdateListener);
        valueAnimator.start();
    }

    private void playStopLottieView() {
        releaseAnimatorUpdateListener();
        valueAnimator = ValueAnimator.ofFloat(1f, 0f);
        animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mLottieAnimationView.setProgress((float) animation.getAnimatedValue());
            }
        };
        valueAnimator.addUpdateListener(animatorUpdateListener);
        valueAnimator.start();
    }


    private void releaseAnimatorUpdateListener() {
        if (valueAnimator != null && animatorUpdateListener != null) {
            valueAnimator.removeUpdateListener(animatorUpdateListener);
        }
    }
}