package com.wang.viewpager;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommonViewPagerViewHolder extends RecyclerView.ViewHolder {

    public CommonViewPagerViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public <T extends View> T getView(@IdRes int viewId) {
        return itemView.findViewById(viewId);
    }


}