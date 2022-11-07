package com.wang.networkstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkReceiver extends BroadcastReceiver {
    private INetWorkCallback mINetWorkCallback;
    private final String TAG = "NetworkReceiver";


    public void setINetWorkCallback(INetWorkCallback mINetWorkCallback) {
        this.mINetWorkCallback = mINetWorkCallback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conn.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            Log.d(TAG, "wifi");
            if (mINetWorkCallback != null) {
                mINetWorkCallback.wifi();
            }
        } else if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            Log.d(TAG, "移动网络");
            if (mINetWorkCallback != null) {
                mINetWorkCallback.mobile();
            }
        } else if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_ETHERNET) {
            Log.d(TAG, "以太网");
            if (mINetWorkCallback != null) {
                mINetWorkCallback.ethernet();
            }
        } else {
            if (mINetWorkCallback != null) {
                Log.d(TAG, "其他未知网络");
                mINetWorkCallback.unknown();
            }

        }
    }
}
