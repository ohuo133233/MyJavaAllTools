package com.wang.myjavaalltools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestActivity extends AppCompatActivity {

    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();


        try {
            jsonObject.put("顶级", "object");
            jsonObject.put("object", "object");
            jsonArray.put("数组1");
//            jsonObject.putL
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonString = jsonObject.toString();
        Log.e(TAG, "jsonString: " + jsonString);
    }
}