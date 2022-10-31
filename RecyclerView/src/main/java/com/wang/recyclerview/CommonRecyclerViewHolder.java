package com.wang.recyclerview;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommonRecyclerViewHolder extends RecyclerView.ViewHolder {

    public CommonRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public <T extends View> T getView(@IdRes int viewId) {
        return itemView.findViewById(viewId);
    }

    public View getItemView() {
        return itemView;
    }
}