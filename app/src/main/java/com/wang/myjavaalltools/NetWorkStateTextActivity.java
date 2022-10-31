package com.wang.myjavaalltools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wang.networkstate.INetWorkCallback;
import com.wang.networkstate.NetWorkConstant;
import com.wang.networkstate.NetWorkUtils;

public class NetWorkStateTextActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work_state_text_activity);


        Button getNetWorkState = findViewById(R.id.get_network_state);
        Button registerNetworkState = findViewById(R.id.register_network_state);
        Button getNetworkEnabled = findViewById(R.id.get_network_enabled);

        getNetWorkState.setOnClickListener(this);
        registerNetworkState.setOnClickListener(this);
        getNetworkEnabled.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_network_state:
                getNetWorkState();
                break;
            case R.id.register_network_state:
                registerNetworkState();
                break;
            case R.id.get_network_enabled:
                getNetworkEnabled();
                break;
        }
    }

    private void registerNetworkState() {

        NetWorkUtils.getInstance().receiverNetWorkStateListener(this, new INetWorkCallback() {
            @Override
            public void unknown() {
                Toast.makeText(NetWorkStateTextActivity.this, "未知网络", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void mobile() {
                Toast.makeText(NetWorkStateTextActivity.this, "移动数据", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void wifi() {
                Toast.makeText(NetWorkStateTextActivity.this, "WIFI", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void ethernet() {
                Toast.makeText(NetWorkStateTextActivity.this, "以太网", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getNetworkEnabled() {
        boolean netWorkIsEnabled = NetWorkUtils.getInstance().getNetWorkIsEnabled(this);
        if (netWorkIsEnabled) {
            Toast.makeText(this, "网络可用", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "网络不可用", Toast.LENGTH_SHORT).show();
        }

    }

    private void getNetWorkState() {
        String netWorkState = NetWorkUtils.getInstance().getNetWorkState(this);
        Toast.makeText(this, netWorkState, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetWorkUtils.getInstance().unregisterReceiver(this);
    }
}