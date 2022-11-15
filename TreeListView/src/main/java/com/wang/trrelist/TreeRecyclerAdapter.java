package com.wang.trrelist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wang.treelistview.R;

import java.util.List;

public class TreeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Node> mData;
    private String TAG = "TreeRecyclerAdapter";

    public TreeRecyclerAdapter(Context context, List<Node> data) {
        this.mContext = context;
        this.mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tree_list, null, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final MyHolder viewHolder = (MyHolder) holder;

        Node<Addrs> node = mData.get(position);

        Log.d(TAG, "node: " + node.toString());
        // 设置内边距

        viewHolder.itemView.setPadding(node.getLevel() * 30, 3, 3, 3);
        viewHolder.name.setText(node.getBean().getName());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        public TextView name;
//        public ImageView icon;

        public MyHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
//            icon = itemView.findViewById(R.id.arrow_iv);
        }
    }
}
