package com.example.tools;

import android.animation.ObjectAnimator;
import android.view.View;

/**
 * 属性动画Tools
 * 提供放大、平移、透明度、旋转动画
 */
public class AnimationPropertyTools {

    /**
     * 放大动画
     *
     * @param view     要操作的View
     * @param duration 持续时间
     * @param valuesX  放大X的倍率
     * @param valuesY  放大Y的倍率
     * @param duration  放大Y的倍率
     */
    public void scale(View view, float valuesX, float valuesY, long duration) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", valuesX);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", valuesY);
        scaleX.setDuration(duration);
        scaleY.setDuration(duration);
        scaleX.start();
        scaleY.start();
    }

    /***
     * 平移动画
     * @param view  要操作的View
     * @param duration 持续时间
     * @param translation_x 平移到X的坐标
     * @param translation_Y 平移到Y的坐标
     */
    public void translation(View view, long duration, float translation_x, float translation_Y) {
        ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", translation_x);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(view, "translationY", translation_Y);
        translationX.setDuration(duration);
        translationY.setDuration(duration);
        translationX.start();
        translationY.start();
    }

    /**
     * 透明度动画
     *
     * @param view       要操作的View
     * @param duration   持续时间
     * @param alphaValue 透明度的值
     */
    private void alpha(View view, long duration, float... alphaValue) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", alphaValue);
        alpha.setDuration(duration);
        alpha.start();
    }

    /**
     * 旋转动画
     *
     * @param view          要操作的View
     * @param duration      持续时间
     * @param rotationValue 旋转的值
     */
    private void rotation(View view, long duration, float... rotationValue) {
        ObjectAnimator rotation = ObjectAnimator.ofFloat(view, "rotation", rotationValue);
        rotation.setDuration(duration);
        rotation.start();
    }


    public void translationX(View view, long duration, float... translationX) {
        ObjectAnimator translation = ObjectAnimator.ofFloat(view, "translationX", translationX);
        translation.setDuration(duration);
        translation.start();
    }

    public void translationY(View view, long duration, float... translationY) {
        ObjectAnimator translation = ObjectAnimator.ofFloat(view, "translationY", translationY);
        translation.setDuration(duration);
        translation.start();
    }


}
