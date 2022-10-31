package com.wang.recyclerview;

import androidx.annotation.NonNull;

public interface CommonRecyclerViewAdapterBackCall {
    void onBindViewHolder(@NonNull CommonRecyclerViewHolder holder, int position);
}
