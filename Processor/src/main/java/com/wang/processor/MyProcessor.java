package com.wang.processor;


import com.google.auto.service.AutoService;
import com.wang.annotation.WorkInBackground;
import com.wang.annotation.WorkInMainThread;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;


@AutoService(Processor.class)
public class MyProcessor extends AbstractProcessor {
    private static final String TAG = "MyProcessor";

    /**
     * 日志工具类
     */
    private Messager mMessager;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mMessager = processingEnv.getMessager();
        println("Hello APT");
        mMessager.printMessage(Diagnostic.Kind.NOTE, "Hello APT");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //   getWorkInMainThread(roundEnv);
        mMessager.printMessage(Diagnostic.Kind.NOTE, "=======> process处理ing");
        return false;
    }


    private void println(String message) {
        System.out.println(message);
    }


    /**
     * 要扫描扫描的注解，可以添加多个
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add(WorkInMainThread.class.getCanonicalName());
        hashSet.add(WorkInBackground.class.getCanonicalName());

        return hashSet;
    }

    /**
     * 编译版本，固定写法就可以
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

}