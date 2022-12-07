package com.example.tools;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

public class KeyBoardTools {

    private static final String TAG = "KeyBoardTools";
    private static volatile KeyBoardTools instance = null;


    private KeyBoardTools() {

    }

    public static KeyBoardTools getInstance() {
        if (instance == null) {
            synchronized (KeyBoardTools.class) {
                if (instance == null) {
                    instance = new KeyBoardTools();
                }
            }
        }
        return instance;
    }

    public void hideKeyboard(Activity activity, EditText editText) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void showKeyboard(Activity activity, EditText editText) {

        // 获取焦点并弹出软键盘
        editText.postDelayed(() -> {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            // 移动光标到最后
            editText.setSelection(editText.getText().toString().length());
        }, 300);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (activity != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

                }

            }
        }, 200);
    }
}
