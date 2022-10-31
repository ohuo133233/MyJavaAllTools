package com.wang.dialog;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public interface MyLifecycleObserver extends DefaultLifecycleObserver {

    String TAG = "LifecycleObserver";

    @Override
    default void onCreate(@NonNull LifecycleOwner owner) {
        Log.v(TAG, "onCreate");
    }

    @Override
    default void onStart(@NonNull LifecycleOwner owner) {
        Log.v(TAG, "onStart");
    }

    @Override
    default void onResume(@NonNull LifecycleOwner owner) {
        Log.v(TAG, "onResume");
    }

    @Override
    default void onPause(@NonNull LifecycleOwner owner) {
        Log.v(TAG, "onPause");
    }

    @Override
    default void onDestroy(@NonNull LifecycleOwner owner) {
        Log.v(TAG, "onDestroy");
    }
}
