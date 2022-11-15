package com.wang.myjavaalltools;

import com.wang.utils.StringUtils;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class Test {
    @org.junit.Test
    public void addition_isCorrect() {
        String s = "";
        log(StringUtils.isEmpty(s) + "");

    }

    public void log(String message) {
        System.out.println(message);
    }
}