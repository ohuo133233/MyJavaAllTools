package com.wang.myjavaalltools;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("日志");
        strings.add("自定义View");
        strings.add("网络状态");
        strings.add("测试");
        strings.add("树形结构列表");

        RecyclerView recyclerView = findViewById(R.id.list);
//
//        CommonRecyclerViewAdapter<String> commonRecyclerViewAdapter = new CommonRecyclerViewAdapter.Build<String>().setContext(this).setDataList(strings).setLayoutId(R.layout.item).build();
//
//        commonRecyclerViewAdapter.setCommonRecyclerViewAdapterBackCall((holder, position) -> {
//            Button button = holder.getView(R.id.item_name);
//            button.setText(strings.get(position));
//            button.setOnClickListener(v -> {
//                switch (position) {
//                    case 0:
//                        startActivity(new Intent(MainActivity.this, LogToolsActivity.class));
//                        break;
//                    case 1:
//                        startActivity(new Intent(MainActivity.this, CustomViewActivity.class));
//                        break;
//                    case 2:
//                        startActivity(new Intent(MainActivity.this, NetWorkStateTextActivity.class));
//                        break;
//                    case 3:
//                        startActivity(new Intent(MainActivity.this, TestActivity.class));
//                        break;
//                    case 4:
//                        startActivity(new Intent(MainActivity.this, TreeListActivity.class));
//                        break;
//                }
//            });
//        });
//
//        recyclerView.setAdapter(commonRecyclerViewAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}