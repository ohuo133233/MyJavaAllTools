package com.wang.myjavaalltools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.wang.trrelist.Addrs;
import com.wang.trrelist.Node;
import com.wang.trrelist.TreeRecyclerAdapter;

import java.util.ArrayList;

public class TreeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_list);

        initView();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.trre_list);
        ArrayList<Node> nodes = new ArrayList<>();
        Addrs addrs = new Addrs(1, "北京");
        Addrs addrs1 = new Addrs(2, "河北省");
        Addrs addrs2 = new Addrs(3, "河南省");
        Addrs addrs3 = new Addrs(3, "湖北省");
        Addrs addrs4 = new Addrs(3, "湖南省");

        Node node1 = new Node(addrs,-1, -1, 1,1);
        Node node2 = new Node(addrs1,-1, -1, 2,1);
        Node node3 = new Node(addrs2,-1, -1, 3,1);
        Node node4 = new Node(addrs3,-1, -1, 4,1);
        Node node5 = new Node(addrs4,-1, -1, 5,1);


        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);

        TreeRecyclerAdapter treeRecyclerAdapter = new TreeRecyclerAdapter(this, nodes);

        recyclerView.setAdapter(treeRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}