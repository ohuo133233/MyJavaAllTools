package com.wang.myjavaalltools;

import java.util.ArrayList;
import java.util.List;
/*
* {
  "id": 40,
  "name": "和平区教师进修学校",
  "school_id": 1,
  "order": 40,
  "parent_id": 0,
  "path": ",40,",
  "type": 2,
  "isLeaf": true,
  "children": [
    {
      "id": 111,
      "name": "电信学院",
      "school_id": 1,
      "order": 48,
      "parent_id": 40,
      "path": ",40,111,",
      "type": 2,
      "isLeaf": false,
      "children": [
        {
          "id": 157,
          "name": "小A",
          "school_id": 1,
          "order": 157,
          "parent_id": 111,
          "path": ",40,111,157,",
          "type": 2,
          "isLeaf": false,
          "children": null
        }
      ]
    },
    {
      "id": 64,
      "name": "小学教学楼",
      "school_id": 1,
      "order": 64,
      "parent_id": 40,
      "path": ",40,64,",
      "type": 2,
      "isLeaf": false,
      "children": [
        {
          "id": 65,
          "name": "F1",
          "school_id": 1,
          "order": 65,
          "parent_id": 64,
          "path": ",40,64,65,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 66,
          "name": "F2",
          "school_id": 1,
          "order": 66,
          "parent_id": 64,
          "path": ",40,64,66,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 67,
          "name": "F3",
          "school_id": 1,
          "order": 67,
          "parent_id": 64,
          "path": ",40,64,67,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 68,
          "name": "F4",
          "school_id": 1,
          "order": 68,
          "parent_id": 64,
          "path": ",40,64,68,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 69,
          "name": "F5",
          "school_id": 1,
          "order": 69,
          "parent_id": 64,
          "path": ",40,64,69,",
          "type": 2,
          "isLeaf": false,
          "children": null
        }
      ]
    },
    {
      "id": 123,
      "name": "体育与文学学院",
      "school_id": 1,
      "order": 80,
      "parent_id": 40,
      "path": ",40,123,",
      "type": 2,
      "isLeaf": false,
      "children": null
    },
    {
      "id": 80,
      "name": "初中教学楼",
      "school_id": 1,
      "order": 85,
      "parent_id": 40,
      "path": ",40,80,",
      "type": 2,
      "isLeaf": false,
      "children": [
        {
          "id": 81,
          "name": "一楼",
          "school_id": 1,
          "order": 81,
          "parent_id": 80,
          "path": ",40,80,81,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 82,
          "name": "二楼",
          "school_id": 1,
          "order": 82,
          "parent_id": 80,
          "path": ",40,80,82,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 83,
          "name": "三楼",
          "school_id": 1,
          "order": 83,
          "parent_id": 80,
          "path": ",40,80,83,",
          "type": 2,
          "isLeaf": false,
          "children": null
        }
      ]
    },
    {
      "id": 85,
      "name": "测试教学楼",
      "school_id": 1,
      "order": 96,
      "parent_id": 40,
      "path": ",40,85,",
      "type": 2,
      "isLeaf": false,
      "children": [
        {
          "id": 86,
          "name": "F1",
          "school_id": 1,
          "order": 86,
          "parent_id": 85,
          "path": ",40,85,86,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 87,
          "name": "F2",
          "school_id": 1,
          "order": 87,
          "parent_id": 85,
          "path": ",40,85,87,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 88,
          "name": "F3",
          "school_id": 1,
          "order": 88,
          "parent_id": 85,
          "path": ",40,85,88,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 89,
          "name": "F4",
          "school_id": 1,
          "order": 89,
          "parent_id": 85,
          "path": ",40,85,89,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 90,
          "name": "F5",
          "school_id": 1,
          "order": 90,
          "parent_id": 85,
          "path": ",40,85,90,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 91,
          "name": "F6",
          "school_id": 1,
          "order": 91,
          "parent_id": 85,
          "path": ",40,85,91,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 92,
          "name": "F7",
          "school_id": 1,
          "order": 92,
          "parent_id": 85,
          "path": ",40,85,92,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 93,
          "name": "F8",
          "school_id": 1,
          "order": 93,
          "parent_id": 85,
          "path": ",40,85,93,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 94,
          "name": "F9",
          "school_id": 1,
          "order": 94,
          "parent_id": 85,
          "path": ",40,85,94,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 95,
          "name": "F10",
          "school_id": 1,
          "order": 95,
          "parent_id": 85,
          "path": ",40,85,95,",
          "type": 2,
          "isLeaf": false,
          "children": null
        }
      ]
    },
    {
      "id": 112,
      "name": "机械学院",
      "school_id": 1,
      "order": 109,
      "parent_id": 40,
      "path": ",40,112,",
      "type": 2,
      "isLeaf": false,
      "children": [
        {
          "id": 183,
          "name": "小分组",
          "school_id": 1,
          "order": 183,
          "parent_id": 112,
          "path": ",40,112,183,",
          "type": 2,
          "isLeaf": false,
          "children": null
        }
      ]
    },
    {
      "id": 113,
      "name": "信息管理",
      "school_id": 1,
      "order": 110,
      "parent_id": 40,
      "path": ",40,113,",
      "type": 2,
      "isLeaf": false,
      "children": [
        {
          "id": 184,
          "name": "添加一个子分组",
          "school_id": 1,
          "order": 184,
          "parent_id": 113,
          "path": ",40,113,184,",
          "type": 2,
          "isLeaf": false,
          "children": null
        }
      ]
    },
    {
      "id": 49,
      "name": "信息楼",
      "school_id": 1,
      "order": 112,
      "parent_id": 40,
      "path": ",40,49,",
      "type": 2,
      "isLeaf": false,
      "children": [
        {
          "id": 52,
          "name": "F3",
          "school_id": 1,
          "order": 50,
          "parent_id": 49,
          "path": ",40,49,52,",
          "type": 2,
          "isLeaf": false,
          "children": [
            {
              "id": 84,
              "name": "第四层",
              "school_id": 1,
              "order": 84,
              "parent_id": 52,
              "path": ",40,49,52,84,",
              "type": 2,
              "isLeaf": false,
              "children": null
            }
          ]
        },
        {
          "id": 51,
          "name": "F2",
          "school_id": 1,
          "order": 51,
          "parent_id": 4,
          "path": ",40,49,51,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 50,
          "name": "F1",
          "school_id": 1,
          "order": 52,
          "parent_id": 49,
          "path": ",40,49,50,",
          "type": 2,
          "isLeaf": false,
          "children": null
        }
      ]
    },
    {
      "id": 129,
      "name": "计算机科学与技术",
      "school_id": 1,
      "order": 113,
      "parent_id": 40,
      "path": ",40,129,",
      "type": 2,
      "isLeaf": false,
      "children": null
    },
    {
      "id": 115,
      "name": "测试分组",
      "school_id": 1,
      "order": 119,
      "parent_id": 40,
      "path": ",40,115,",
      "type": 2,
      "isLeaf": false,
      "children": [
        {
          "id": 135,
          "name": "1",
          "school_id": 1,
          "order": 135,
          "parent_id": 115,
          "path": ",40,115,135,",
          "type": 2,
          "isLeaf": false,
          "children": [
            {
              "id": 140,
              "name": "33333333333333333333",
              "school_id": 1,
              "order": 140,
              "parent_id": 135,
              "path": ",40,115,135,140,",
              "type": 2,
              "isLeaf": false,
              "children": null
            }
          ]
        },
        {
          "id": 136,
          "name": "2",
          "school_id": 1,
          "order": 136,
          "parent_id": 115,
          "path": ",40,115,136,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 137,
          "name": "3",
          "school_id": 1,
          "order": 137,
          "parent_id": 115,
          "path": ",40,115,137,",
          "type": 2,
          "isLeaf": false,
          "children": null
        },
        {
          "id": 138,
          "name": "4",
          "school_id": 1,
          "order": 138,
          "parent_id": 115,
          "path": ",40,115,138,",
          "type": 2,
          "isLeaf": false,
          "children": null
        }
      ]
    },
    {
      "id": 126,
      "name": "这是一个很长名字的分组哦你晓得吗我不晓得",
      "school_id": 1,
      "order": 123,
      "parent_id": 40,
      "path": ",40,126,",
      "type": 2,
      "isLeaf": false,
      "children": null
    },
    {
      "id": 127,
      "name": "研发中心",
      "school_id": 1,
      "order": 126,
      "parent_id": 40,
      "path": ",40,127,",
      "type": 2,
      "isLeaf": false,
      "children": null
    },
    {
      "id": 153,
      "name": "高中教学楼",
      "school_id": 1,
      "order": 127,
      "parent_id": 40,
      "path": ",40,153,",
      "type": 2,
      "isLeaf": false,
      "children": null
    },
    {
      "id": 142,
      "name": "测试专用",
      "school_id": 1,
      "order": 129,
      "parent_id": 40,
      "path": ",40,142,",
      "type": 2,
      "isLeaf": false,
      "children": null
    },
    {
      "id": 155,
      "name": "Test",
      "school_id": 1,
      "order": 142,
      "parent_id": 40,
      "path": ",40,155,",
      "type": 2,
      "isLeaf": false,
      "children": null
    },
    {
      "id": 110,
      "name": "经管学院",
      "school_id": 1,
      "order": 153,
      "parent_id": 40,
      "path": ",40,110,",
      "type": 2,
      "isLeaf": false,
      "children": null
    },
    {
      "id": 109,
      "name": "纺织学院学习加油",
      "school_id": 1,
      "order": 155,
      "parent_id": 40,
      "path": ",40,109,",
      "type": 2,
      "isLeaf": false,
      "children": null
    },
    {
      "id": 185,
      "name": "测试数据组",
      "school_id": 1,
      "order": 185,
      "parent_id": 40,
      "path": ",40,185,",
      "type": 2,
      "isLeaf": false,
      "children": null
    }
  ]
}
*
* */

public class Node {

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


    public Node(Node bean, long id, long pId, int level, int icon) {
        this.id = id;
        this.pId = pId;
        this.level = level;
        this.icon = icon;

    }


    public Node(long id, long pid, String name) {
        this.id = id;
        this.pId = pid;
        this.name = name;
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

//    @Override
//    public String toString() {
//        return "{" +
//                " id=" + id +
//                ", pId=" + pId +
//                ", name='" + name + '\'' +
//                ", level=" + level +
//                ", children=" + children +
//                ", parent=" + parent +
//                '}';
//    }
}
