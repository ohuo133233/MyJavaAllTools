package com.wang.trrelist;

import java.util.ArrayList;
import java.util.List;


public class Node<B> {

    /**
     * 传入的实体对象
     */
    public B bean;
    /**
     * 设置开启 关闭的图片
     */
    public int iconExpand = -1, iconNoExpand = -1;

    private long id;
    /**
     * 根节点pId为0
     */
    private long pId;

    private int school_id;

    private String name;

    /**
     * 当前的级别
     */
    private int level;

    /**
     * 是否展开
     */
    private boolean isExpand = false;

    private int icon = -1;

    /**
     * 下一级的子Node
     */
    private List<Node> children = new ArrayList<>();

    /**
     * 父Node
     */
    private Node parent;
    /**
     * 是否被checked选中
     */
    private boolean isChecked;
    /**
     * 是否为新添加的
     */
    public boolean isNewAdd = true;


    public Node(B bean, long id, long pId, int level, int icon) {
        this.bean = bean;
        this.id = id;
        this.pId = pId;
        this.level = level;
        this.icon = icon;

    }


    public B getBean() {
        return bean;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }


    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * 是否为跟节点
     *
     * @return
     */
    public boolean isRoot() {
        return parent == null;
    }

    /**
     * 判断父节点是否展开
     *
     * @return
     */
    public boolean isParentExpand() {
        if (parent == null)
            return false;
        return parent.isExpand();
    }

    /**
     * 是否是叶子界点
     *
     * @return
     */
    public boolean isLeaf() {
        return children.size() == 0;
    }

    /**
     * 获取level
     */
//    public int getLevel() {
//        return parent == null ? 0 : parent.getLevel() + 1;
//    }
    public int getLevel() {
        return level;
    }

    /**
     * 设置展开
     *
     * @param isExpand
     */
    public void setExpand(boolean isExpand) {
        this.isExpand = isExpand;
        if (!isExpand) {
            for (Node node : children) {
                node.setExpand(isExpand);
            }
        }
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public int getSchool_id() {
        return school_id;
    }


    @Override
    public String toString() {
        return "Node{" +
                "bean=" + bean +
                ", id=" + id +
                ", pId=" + pId +
                ", school_id=" + school_id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", isExpand=" + isExpand +
                ", icon=" + icon +
                ", children=" + children +
                ", parent=" + parent +
                ", isChecked=" + isChecked +
                ", isNewAdd=" + isNewAdd +
                '}';
    }
}
