package com.wang.networkstate;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.annotation.NonNull;

public class NetWorkUtils {
    private static final String TAG = "NetUtils";
    private static volatile NetWorkUtils instance = null;
    private NetworkReceiver mNetworkReceiver;

    public static NetWorkUtils getInstance() {
        if (instance == null) {
            synchronized (NetWorkUtils.class) {
                if (instance == null) {
                    instance = new NetWorkUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 如果有不稳定的移动网络、飞行模式和后台数据受限等情况，该方法会返回不可用的状态
     *
     * @param context 上下文
     * @return 返回网络是否可用
     */
    public boolean getNetWorkIsEnabled(@NonNull Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    /**
     * 获取当前网络的连接状态，切换网络状态的时候会有一点延迟。
     * 需要注意当多个网络连接状态时建议分别使用
     * {@link NetWorkUtils#getWifiIsConnected(Context)}
     * {@link NetWorkUtils#getMobileIsConnected(Context)}
     * {@link NetWorkUtils#getEthernetIsConnected(Context)}
     * 进行单一判断
     *
     * @param context 上下文
     * @return 返回的是一个字符串格式
     */
    public String getNetWorkState(@NonNull Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        int netWorkState = NetWorkConstant.UNKNOWN;
        boolean isWifiConn = false;
        boolean isMobileConn = false;
        boolean isEthernet = false;

        for (Network network : connMgr.getAllNetworks()) {
            NetworkInfo networkInfo = connMgr.getNetworkInfo(network);
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                isWifiConn |= networkInfo.isConnected();
                netWorkState = NetWorkConstant.WIFI;

            }
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                isMobileConn |= networkInfo.isConnected();
                netWorkState = NetWorkConstant.MOBILE;

            }
            if (networkInfo.getType() == ConnectivityManager.TYPE_ETHERNET) {
                isEthernet |= networkInfo.isConnected();
                netWorkState = NetWorkConstant.ETHERNET;
            }
        }


        Log.d(TAG, "Wifi connected: " + isWifiConn);
        Log.d(TAG, "Mobile connected: " + isMobileConn);
        Log.d(TAG, "Ethernet connected: " + isEthernet);
        Log.d(TAG, "netWorkState : " + netWorkState);

        return "netWorkState" + netWorkState + " ," + "Wifi connected: " + isWifiConn + " ," + "Mobile connected: " + isMobileConn + " ," + "Ethernet connected: " + isEthernet;
    }

    /**
     * @param context 上下文
     * @return 返回wifi是否连接
     */
    public boolean getWifiIsConnected(@NonNull Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return networkInfo.isConnected();
            }
        }
        return false;
    }

    /**
     * @param context 上下文
     * @return 返回移动网络是否连接
     */
    public boolean getMobileIsConnected(@NonNull Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                return networkInfo.isConnected();
            }
        }
        return false;
    }

    /**
     * @param context 上下文
     * @return 返以太网是否连接
     */
    public boolean getEthernetIsConnected(@NonNull Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
            if (networkInfo.getType() == ConnectivityManager.TYPE_ETHERNET) {
                return networkInfo.isConnected();
            }
        }
        return false;
    }


    public void receiverNetWorkStateListener(@NonNull Context context,INetWorkCallback iNetWorkCallback) {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        mNetworkReceiver = new NetworkReceiver();
        mNetworkReceiver.setINetWorkCallback(iNetWorkCallback);
        context.registerReceiver(mNetworkReceiver, filter);
    }


    public void unregisterReceiver(@NonNull Context context) {
        context.unregisterReceiver(mNetworkReceiver);
    }



}
