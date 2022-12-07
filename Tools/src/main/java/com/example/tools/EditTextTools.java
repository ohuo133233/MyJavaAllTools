package com.example.tools;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.wang.logtools.KLog;

public class EditTextTools {

    private static final String TAG = "EditTextTools";
    private static volatile EditTextTools instance = null;
    // 中文
    private final String CHINESE = "[\u4E00-\u9FA5]+";

    private EditTextTools() {

    }

    public static EditTextTools getInstance() {
        if (instance == null) {
            synchronized (EditTextTools.class) {
                if (instance == null) {
                    instance = new EditTextTools();
                }
            }
        }
        return instance;
    }


    public void addInputCallBack(EditText editText, EditTextCallBack editTextCallBack) {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                KLog.d(TAG, "beforeTextChanged, charSequence: " + charSequence);
                KLog.d(TAG, "beforeTextChanged, start: " + start);
                KLog.d(TAG, "beforeTextChanged, count: " + count);
                KLog.d(TAG, "beforeTextChanged, after: " + after);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                KLog.d(TAG, "onTextChanged, charSequence: " + charSequence);
                KLog.d(TAG, "onTextChanged, start: " + start);
                KLog.d(TAG, "onTextChanged, before: " + before);
                KLog.d(TAG, "onTextChanged, count: " + count);


            }

            @Override
            public void afterTextChanged(Editable editable) {
                KLog.d(TAG, "afterTextChanged, editable: " + editable);
                if (editable.toString().matches(CHINESE)) {
                    editTextCallBack.chinese(editable.toString());
                }
            }
        });
    }

}
