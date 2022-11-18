package com.wang.myjavaalltools;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;




public class LogToolsActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "LogToolsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_tools);
//        KLog.d("测试");

        initView();
    }

    private void initView() {
        Button startLineNumber = findViewById(R.id.start_line_number);
        Button close_line_number = findViewById(R.id.close_line_number);
        Button long_log = findViewById(R.id.long_log);


        startLineNumber.setOnClickListener(this);
        close_line_number.setOnClickListener(this);
        long_log.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.start_line_number:
//                KLog.init(true);
//                KLog.e("测试");
//                break;
//            case R.id.close_line_number:
//                KLog.init(false);
//                KLog.e("测试");
//                break;
//            case R.id.long_log:
//                String ten = "0123456789";
//                for (int i = 1; i <= 10; i++) {
//                    Log.d(TAG, "i" + i);
//                    ten += ten;
//                }
//                KLog.e(TAG, ten + "-end");
//                break;
//        }
    }
}