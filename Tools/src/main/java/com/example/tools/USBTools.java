package com.example.tools;

import android.content.Context;
import android.os.Build;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.N)
public class USBTools {

    private static final String TAG = "USBUtils";
    private static volatile USBTools instance = null;

    private StorageManager mStorageManager;

    public USBTools() {

    }

    public static USBTools getInstance() {
        if (instance == null) {
            synchronized (USBTools.class) {
                if (instance == null) {
                    instance = new USBTools();
                }
            }
        }
        return instance;
    }


    public void init(Context context) {
        mStorageManager = context.getSystemService(StorageManager.class);
    }

    /**
     * 是否有可移除的外部存储设备
     *
     * @return
     */

    public boolean isUSBStorage() {
        List<StorageVolume> volumeList = mStorageManager.getStorageVolumes();
        for (StorageVolume storageVolume : volumeList) {
            Log.d(TAG, "storageVolume: " + storageVolume);
            if (storageVolume.isRemovable()) {
                Log.d(TAG, "可移除的外部存储设备: " + storageVolume);
                return true;
            }
        }
        return false;
    }


    public ArrayList<String> getUSBStoragePath() {
        ArrayList<String> pathList = new ArrayList<>();
        List<StorageVolume> volumeList = mStorageManager.getStorageVolumes();
        for (StorageVolume storageVolume : volumeList) {
            Log.d(TAG, "storageVolume: " + storageVolume);
            if (storageVolume.isRemovable()) {
                try {
                    Class myclass = Class.forName(storageVolume.getClass().getName());
                    Method getPath = myclass.getDeclaredMethod("getPath");
                    getPath.setAccessible(true);
                    String path = (String) getPath.invoke(storageVolume);
                    pathList.add(path);
                } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return pathList;
    }


}
