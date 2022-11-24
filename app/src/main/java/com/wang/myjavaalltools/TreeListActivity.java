package com.wang.myjavaalltools;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TreeListActivity extends AppCompatActivity {

    private String TAG = "TreeListActivity";
    private static ArrayList<Node> nodeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_list);

        initView();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.tree_list);


        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(getFileData());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray data = jsonObject.optJSONArray("data");

        decode(data);

        nodeList = contrast(nodeList);

        Log.d(TAG, "nodeList: " + nodeList.toString());
        Log.d(TAG, "nodeList size: " + nodeList.size());

        ArrayList<Node> rootNodes = getRootNodes(nodeList);
        ArrayList<Node> result = new ArrayList<>();
        int defaultExpandLevel = 1;
        // 排序以及设置Node间关系
        for (Node node : rootNodes) {
            addNode(result, node, defaultExpandLevel, 1);
        }

        Log.d(TAG, "result: " + result.toString());
        TreeRecyclerAdapter treeRecyclerAdapter = new TreeRecyclerAdapter(this, result);
        recyclerView.setAdapter(treeRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * 把一个节点上的所有的内容都挂上去
     */
    private static void addNode(@NonNull ArrayList<Node> nodes, Node node,
                                int defaultExpandLeval, int currentLevel) {
        nodes.add(node);

        if (node.isNewAdd && defaultExpandLeval >= currentLevel) {
            node.setExpand(true);
        }

        if (node.isLeaf()) {
            return;
        }

        for (int i = 0; i < node.getChildren().size(); i++) {
            addNode(nodes, node.getChildren().get(i), defaultExpandLeval,
                    currentLevel + 1);
        }
    }

    private void decode(JSONArray jsonString) {

        JSONArray children;
        try {
            for (int i = 0; i < jsonString.length(); i++) {
                JSONObject node = jsonString.optJSONObject(i);

                int id = node.optInt("id");
                int parent_id = node.optInt("parent_id");
                String name = node.optString("name");
//                Log.d(TAG, "id: " + id);
//                Log.d(TAG, "parent_id: " + parent_id);
//                Log.d(TAG, "name: " + name);

                nodeList.add(new Node(id, parent_id, name));

                children = node.optJSONArray("children");
                if (children != null && !children.equals("null")) {
                    decode(children);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取文件的String
    private String getFileData() {
        String jsonString = "";
        try {
            jsonString = readFromInputStream(getApplicationContext().getAssets().open("data.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    // 读取InputStream转为String
    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }


    private ArrayList<Node> contrast(ArrayList<Node> nodes) {

        for (int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            for (int j = i + 1; j < nodes.size(); j++) {
                Node m = nodes.get(j);
                if (m.getpId() == n.getId()) {
                    n.getChildren().add(m);
                    m.setParent(n);
                } else if (m.getId() == n.getpId()) {
                    m.getChildren().add(n);
                    n.setParent(m);
                }
            }
        }
        return nodes;

    }

    @NonNull
    private static ArrayList<Node> getRootNodes(@NonNull ArrayList<Node> nodes) {
        ArrayList<Node> root = new ArrayList<>();
        for (Node node : nodes) {
            if (node.isRoot()) {
                root.add(node);
            }
        }
        return root;
    }


}