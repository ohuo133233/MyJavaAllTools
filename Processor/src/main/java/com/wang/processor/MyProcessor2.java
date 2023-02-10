package com.wang.processor;


import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;
import com.wang.annotation.WorkInBackground;
import com.wang.annotation.WorkInMainThread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;


//@AutoService(Processor.class)
public class MyProcessor2 extends AbstractProcessor {
    private static final String TAG = "MyProcessor";
    /**
     * Element操作类
     */
    private Elements mElementUtils;
    /**
     * 类信息工具类
     */
    private Types mTypeUtils;
    /**
     * 日志工具类
     */
    private Messager mMessager;
    /**
     * 文件创建工具类
     */
    private Filer mFiler;
    /**
     * 节点信息缓存
     */
    private Map<String, List<NodeInfo>> mCache = new HashMap<>();


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mElementUtils = processingEnv.getElementUtils();
        mTypeUtils = processingEnv.getTypeUtils();
        mMessager = processingEnv.getMessager();
        mFiler = processingEnv.getFiler();

        println("Hello APT");
        mMessager.printMessage(Diagnostic.Kind.NOTE, "Hello APT");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        getWorkInMainThread(roundEnv);

        return false;
    }


    private void getWorkInMainThread(RoundEnvironment roundEnv) {
        // 获取所有 @WorkInMainThread 节点
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(WorkInMainThread.class);
        if (elements == null || elements.isEmpty()) {
            return;
        }
        // 遍历节点
        for (Element element : elements) {
            // 获取节点包信息
            String packageName = mElementUtils.getPackageOf(element).getQualifiedName().toString();
            // 获取节点类信息，由于 @BindView 作用于成员属性上，所以这里使用 getEnclosingElement() 获取父节点信息
            String className = element.getEnclosingElement().getSimpleName().toString();
            // 获取节点类型
            String typeName = element.asType().toString();
            // 获取节点标记的属性名称
            String nodeName = element.getSimpleName().toString();


            // 打印
            mMessager.printMessage(Diagnostic.Kind.NOTE, "packageName：" + packageName);
            mMessager.printMessage(Diagnostic.Kind.NOTE, "className：" + className);
            mMessager.printMessage(Diagnostic.Kind.NOTE, "typeName：" + typeName);
            mMessager.printMessage(Diagnostic.Kind.NOTE, "nodeName：" + nodeName);

            // 缓存KEY
            String key = packageName + "." + className;
            // 缓存节点信息
            List<NodeInfo> nodeInfos = mCache.get(key);
            if (nodeInfos == null) {
                nodeInfos = new ArrayList<>();
                nodeInfos.add(new NodeInfo(packageName, className, typeName, nodeName));
                // 缓存
                mCache.put(key, nodeInfos);
            } else {
                nodeInfos.add(new NodeInfo(packageName, className, typeName, nodeName));
            }
        }

        // 判断临时缓存是否不为空
        if (!mCache.isEmpty()) {
            // 遍历临时缓存文件
            for (Map.Entry<String, List<NodeInfo>> stringListEntry : mCache.entrySet()) {
                try {
                    // 创建文件
                    createFile(stringListEntry.getValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 创建文件，自动生成代码
     */
    private void createFile(List<NodeInfo> infos) throws IOException {
        NodeInfo info = infos.get(0);

        // 生成的文件名(类名)
        String className = info.getClassName() + "$$ViewBinding";
        mMessager.printMessage(Diagnostic.Kind.NOTE, "创建文件，自动生成代码：" + className);


        // 方法参数
        ParameterSpec parameterSpec = ParameterSpec.builder(
                        ClassName.get(info.getPackageName(), info.getClassName()), "target")
                .build();


        // 方法
        MethodSpec.Builder methodSpecBuilder = MethodSpec.methodBuilder("bind")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addParameter(parameterSpec)
                .returns(void.class);

        // 给方法添加代码块
        for (NodeInfo nodeInfo : infos) {
            // target.textView = (TextView) target.findViewByID(R.id.text_view);
            methodSpecBuilder.addStatement("target.$L = ($L)target.findViewById($L)",
                    nodeInfo.getNodeName(),
                    nodeInfo.getTypeName());
        }

        // 类
        TypeSpec typeSpec = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(methodSpecBuilder.build())
                .build();

        // 生成文件
        JavaFile.builder(info.getPackageName(), typeSpec)
                .build()
                .writeTo(mFiler);
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
        return processingEnv.getSourceVersion();
    }

}