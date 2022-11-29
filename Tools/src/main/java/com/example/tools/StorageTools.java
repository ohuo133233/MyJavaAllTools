package com.example.tools;

import android.os.Environment;

public class StorageTools {

    private static final String TAG = "StorageTools";
    private static volatile StorageTools instance = null;


    private StorageTools() {

    }

    public static StorageTools getInstance() {
        if (instance == null) {
            synchronized (StorageTools.class) {
                if (instance == null) {
                    instance = new StorageTools();
                }
            }
        }
        return instance;
    }

    // 获取外部储存空间的根目录
    public void getRootExternalStorageDirectory() {
        Environment.getExternalStorageDirectory().getAbsolutePath();
    }



}
