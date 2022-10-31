package com.wang.permission;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class PermissionManager {
    public static final String TAG = PermissionManager.class.getSimpleName();
    public static final int REQUEST_CODE = 0x01;
    private Context mApplicationContext;
    private PermissionsFragment mPermissionsFragment;
    private FragmentActivity mFragmentActivity;


    public PermissionManager(@NonNull FragmentActivity activity) {
        mFragmentActivity = activity;
        mApplicationContext = activity.getApplicationContext();

        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        mPermissionsFragment = (PermissionsFragment) fragmentManager.findFragmentByTag(TAG);

        if (mPermissionsFragment == null) {
            mPermissionsFragment = new PermissionsFragment();
            fragmentTransaction.add(mPermissionsFragment, TAG)
                    .commitNow();
        }
    }


    public void requestPermission(@NonNull String permissions, IPermissionCallBack iPermissionCallBack) {
        Log.d(TAG, "获取单个权限");
        // 遍历权限，判断没有的去获取
        if (!isPermissionGranted(mApplicationContext, permissions)) {
            Log.d(TAG, "没有权限，去请求");
            String[] permission = new String[]{permissions};
            mPermissionsFragment.requestPermissions(permission, REQUEST_CODE);
            if (mPermissionsFragment != null && iPermissionCallBack != null) {
                mPermissionsFragment.setIPermissionCallBack(iPermissionCallBack);
            }
        } else {
            Log.d(TAG, "已经有权限，不需要获取");
            if (mPermissionsFragment != null && iPermissionCallBack != null) {
                iPermissionCallBack.alreadyObtainedPermission();
            }
        }
    }


    public void requestPermissions(IPermissionCallBack iPermissionCallBack, @NonNull String... permissions) {
        Log.d(TAG, "获取多个权限： " + permissions.length);

        for (int i = 0; i < permissions.length - 1; i++) {
            if (!isPermissionGranted(mApplicationContext, permissions[i])) {
                permissions[i] = permissions[i];
            } else {
                Log.d(TAG, "已经有权限，不需要获取");
                if (mPermissionsFragment != null && iPermissionCallBack != null) {
                    iPermissionCallBack.alreadyObtainedPermission();
                }
            }
        }

        if (mPermissionsFragment != null) {
            mPermissionsFragment.requestPermissions(permissions, REQUEST_CODE);
            if (iPermissionCallBack != null) {
                mPermissionsFragment.setIPermissionCallBack(iPermissionCallBack);
            }
        }

    }

    // 判断权限是否批准
    public boolean isPermissionGranted(@NonNull Context context, @NonNull String permission) {
        return ContextCompat.checkSelfPermission(context.getApplicationContext(), permission) == PackageManager.PERMISSION_GRANTED;
    }

    // TODO 只能支持华为的权限跳转
    public void startSystemSetting(Context context) {
        Intent intent = new Intent(context.getPackageName());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        intent.setComponent(comp);
        context.startActivity(intent);
    }

    public void onDestroy() {
        mFragmentActivity = null;
    }
}
