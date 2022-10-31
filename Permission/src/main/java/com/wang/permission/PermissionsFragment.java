package com.wang.permission;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class PermissionsFragment extends Fragment {
    public static final String TAG = PermissionsFragment.class.getSimpleName();
    private IPermissionCallBack mIPermissionCallBack;

    public PermissionsFragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);
    }

    public void setIPermissionCallBack(IPermissionCallBack mIPermissionCallBack) {
        this.mIPermissionCallBack = mIPermissionCallBack;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult");
        if (requestCode == PermissionManager.REQUEST_CODE) {

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 获取权限成功
                Log.d(TAG, "获取权限成功");
                if (mIPermissionCallBack != null) {
                    mIPermissionCallBack.success();
                }
            } else {
                // 如果没有获取权限，那么可以提示用户去设置界面--->应用权限开启权限
                Log.d(TAG, "获取权限失败");
                // 判断用户是否 点击了不再提醒。(检测该权限是否还可以申请)
                if (shouldShowRequestPermissionRationale(permissions[0])) {
                    Log.d(TAG, "用户点击了不再提醒");
                    if (mIPermissionCallBack != null) {
                        mIPermissionCallBack.noMoreReminders();
                    }
                } else {
                    Log.d(TAG, "用户没有点击不再提醒");
                    if (mIPermissionCallBack != null) {
                        mIPermissionCallBack.fail();
                    }
                }
            }
        }
    }

}

