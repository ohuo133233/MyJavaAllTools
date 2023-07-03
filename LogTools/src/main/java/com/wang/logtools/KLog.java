package com.wang.logtools;

import android.util.Log;

import androidx.annotation.NonNull;

public class KLog implements ILogFunction {

    private static String TAG = "KLog";
    private static boolean DEBUG = BuildConfig.DEBUG;
    private static final String SUFFIX = ".java";

    private static boolean sIsPrintlnLineNumber;

    public static void v(@NonNull String message) {
        v(TAG, message);
    }

    public static void v(@NonNull String tag, @NonNull String message) {
        if (sIsPrintlnLineNumber) {
            message = wrapperContent() + ": " + message;
        }
        Log.v(tag, message);
    }


    public static void d(@NonNull String message) {
        d(TAG, message);
    }

    public static void d(@NonNull String tag, @NonNull String message) {
        if (sIsPrintlnLineNumber) {
            message = wrapperContent() + ": " + message;
        }
        Log.d(tag, message);
    }


    public static void i(@NonNull String message) {
        i(TAG, message);
    }

    public static void i(@NonNull String tag, @NonNull String message) {
        if (sIsPrintlnLineNumber) {
            message = wrapperContent() + ": " + message;
        }
        Log.i(tag, message);
    }


    public static void w(@NonNull String message) {
        w(TAG, message);
    }

    public static void w(@NonNull String tag, @NonNull String message) {
        if (sIsPrintlnLineNumber) {
            message = wrapperContent() + ": " + message;
        }
        Log.w(tag, message);
    }


    public static void e(@NonNull String message) {
        e(TAG, message);
    }

    public static void e(@NonNull String tag, @NonNull String message) {
        if (sIsPrintlnLineNumber) {
            message = wrapperContent() + ": " + message;
        }
        Log.e(tag, message);
    }


    public void debugLog(@NonNull String message) {
        debugLog(TAG, message);
    }

    public static void debugLog(@NonNull String tag, @NonNull String message) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, wrapperContent() + ": " + message);
        }
    }



    public static void init(boolean isPrintlnLineNumber) {
        sIsPrintlnLineNumber = isPrintlnLineNumber;
    }

    @Override
    public void setDebug(boolean isDeBug) {
        DEBUG = isDeBug;
    }

    @Override
    public void setAutoSave(boolean autoSave) {

    }

    /**
     * 获取包装好的信息
     * <p>
     * 通过 {@link Thread#getStackTrace() 获取堆栈信息}然后拼接出来
     *
     * @return 封装好格式的信息字符串 例子：(JavaDemoActivity.java:19)#main @onCreate:
     */

    // TODO 是否有优化内存的操作                                                                 6坦然地说
    private static String wrapperContent() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // 获取线程名
        String threadName = Thread.currentThread().getName();
        /**
         * 因为嵌套了一层本来去3就行，但是嵌套此方法取4，实际可以通过下面方法打印出来查看是第几行
         *  for (int i = 0; i < stackTrace.length; i++) {
         *            Log.e(TAG, stackTrace[i].toString());
         *        }
         */
        StackTraceElement targetElement = stackTrace[4];
        // 获取类名 列：com.example.logcattools.JavaDemoActivity
        String className = targetElement.getClassName();
        // 按.切割
        String[] classNameInfo = className.split("\\.");
        // 只有大于0才有意义
        if (classNameInfo.length > 0) {
            // 获取最后一个字符再拼接上.java 列：JavaDemoActivity.java
            className = classNameInfo[classNameInfo.length - 1] + SUFFIX;
        }
        // 如果类名有$
        if (className.contains("$")) {
            // 直接按$切割取第一个加上.java字符
            className = className.split("\\$")[0] + SUFFIX;
        }

        // 获取方法名
        String methodName = targetElement.getMethodName();
        // 获取行数
        int lineNumber = targetElement.getLineNumber();
        // 行数小于0，没有意义
        if (lineNumber < 0) {
            lineNumber = 0;
        }
        // 返回按（类名+行数）+#线程名+@方法名的格式的字符串 列：(JavaDemoActivity.java:19)#main @onCreate
        return "(" + className + ":" + lineNumber + ")#" + threadName + " @" + methodName;
    }


}
