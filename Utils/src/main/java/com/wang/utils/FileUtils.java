package com.wang.utils;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    private static final String TAG = "FileUtils";
    private static volatile FileUtils instance = null;


    public FileUtils() {

    }

    public static FileUtils getInstance() {
        if (instance == null) {
            synchronized (FileUtils.class) {
                if (instance == null) {
                    instance = new FileUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 复制文件夹
     *
     * @param oldDir 原来的目录
     * @param newDir 复制到哪个目录
     */
    public static void copyDir(String oldDir, String newDir, FileCallBack fileCallBack) {
        Log.e(TAG, "oldDir: " + oldDir);
        Log.e(TAG, "newDir: " + newDir);

        File srcDir = new File(oldDir);
        // 判断文件是否不存在或是否不是文件夹
        if (!srcDir.exists() || !srcDir.isDirectory()) {
            Log.e(TAG, "参数错误");
        }
        File destDir = new File(newDir);
        if (!destDir.exists()) {
            // 不存在就创建目录
            Log.e(TAG, "不存在就创建目录");
            if (destDir.mkdirs()) {
                // 列出目录中的文件
                File[] files = srcDir.listFiles();
                Log.e(TAG, "要复制的目录下面的文件: " + files.toString());
                for (File f : files) {
                    // 是文件就调用复制文件方法 是目录就继续调用复制目录方法
                    if (f.isFile()) {
                        Log.d(TAG, "是文件");
                        copyFile(f, new File(newDir, f.getName()), fileCallBack);
                    } else if (f.isDirectory()) {
                        Log.d(TAG, "是文件夹");
                        copyDir(oldDir + File.separator + f.getName(),
                                newDir + File.separator + f.getName(), fileCallBack);
                    }
                }
            }
        } else {
            // 列出目录中的文件
            File[] files = srcDir.listFiles();

            for (File file : files) {
                Log.e(TAG, "要复制的目录下面的文件: " + file.getAbsolutePath());
                // 是文件就调用复制文件方法 是目录就继续调用复制目录方法
                if (file.isFile()) {
                    Log.d(TAG, "是文件");
                    copyFile(file, new File(newDir, file.getName()), fileCallBack);
                } else if (file.isDirectory()) {
                    Log.d(TAG, "是文件夹");
                    copyDir(oldDir + File.separator + file.getName(),
                            newDir + File.separator + file.getName(), fileCallBack);
                }
            }
        }
    }


    /**
     * 复制文件
     *
     * @param oldDir 原来的文件
     * @param newDir 复制到的文件
     */
    public static void copyFile(File oldDir, File newDir, FileCallBack fileCallBack) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                BufferedInputStream bufferedInputStream = null;
                BufferedOutputStream bufferedOutputStream = null;
                byte[] b = new byte[1024];
                try {
                    // 将要复制文件输入到缓冲输入流
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(oldDir));
                    // 将复制的文件定义为缓冲输出流
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newDir));
                    // 定义字节数
                    int len;

                    while ((len = bufferedInputStream.read(b)) > -1) {
                        // 写入文件
                        bufferedOutputStream.write(b, 0, len);
                    }
                    // 刷新此缓冲输出流
                    bufferedOutputStream.flush();
                    if (fileCallBack != null) {
                        fileCallBack.success();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if (fileCallBack != null) {
                        fileCallBack.fail();
                    }
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            // 关闭流
                            bufferedInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }
        }.start();

    }

    public interface FileCallBack {
        void success();

        void fail();
    }

}
