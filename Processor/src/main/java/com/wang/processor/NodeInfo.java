package com.wang.processor;

public class NodeInfo {
    /**
     * 包路径
     */
    private String packageName;
    /**
     * 节点所在类名称
     */
    private String className;
    /**
     * 节点类型名称
     */
    private String typeName;
    /**
     * 节点名称
     */
    private String nodeName;


    public NodeInfo(String packageName, String className, String typeName,
                    String nodeName) {
        this.packageName = packageName;
        this.className = className;
        this.typeName = typeName;
        this.nodeName = nodeName;

    }

    public String getPackageName() {
        return packageName;
    }

    public String getClassName() {
        return className;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getNodeName() {
        return nodeName;
    }


}