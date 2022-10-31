package com.wang.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CommonRecyclerViewAdapter<T> extends RecyclerView.Adapter<CommonRecyclerViewHolder> {
    private static final String TAG = "BaseRecyclerViewAdapter";
    @NonNull
    private final Context mContext;
    @LayoutRes
    private final int mLayoutId;
    @NonNull
    private ArrayList<T> mDataList;

    private RecyclerView.ViewHolder mHolder;
    private CommonRecyclerViewAdapterBackCall mCommonRecyclerViewAdapterBackCall;
    private final Build<T> mBuild;

    private CommonRecyclerViewAdapter(@NonNull Build<T> build) {
        mBuild = build;
        this.mContext = mBuild.mContext;
        this.mLayoutId = mBuild.mLayoutId;
        this.mDataList = mBuild.mDataList;
    }

    @NonNull
    @Override
    public CommonRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(mContext).inflate(this.mLayoutId, parent, false);
        return new CommonRecyclerViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull CommonRecyclerViewHolder holder, int position) {
        mHolder = holder;
        if (mCommonRecyclerViewAdapterBackCall != null) {
            mCommonRecyclerViewAdapterBackCall.onBindViewHolder(holder, position);
        }
    }

    public void setDataList(@NonNull ArrayList<T> dataList) {
        this.mDataList = dataList;
        Log.e(TAG, "mDataList: " + mDataList);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "mDataList size: " + mDataList.size());
        return Math.max(mDataList.size(), 0);
    }


    public void setCommonRecyclerViewAdapterBackCall(CommonRecyclerViewAdapterBackCall mCommonRecyclerViewAdapterBackCall) {
        this.mCommonRecyclerViewAdapterBackCall = mCommonRecyclerViewAdapterBackCall;
    }


    public static class Build<T> {
        @NonNull
        private Context mContext;
        @LayoutRes
        private int mLayoutId;
        @NonNull
        private ArrayList<T> mDataList;


        public Build<T> setContext(@NonNull Context mContext) {
            this.mContext = mContext;
            return this;
        }

        public Build<T> setLayoutId(@LayoutRes int mLayoutId) {
            this.mLayoutId = mLayoutId;
            return this;
        }

        public Build<T> setDataList(@NonNull ArrayList<T> mDataList) {
            this.mDataList = mDataList;
            return this;
        }

        public CommonRecyclerViewAdapter<T> build() {
            return new CommonRecyclerViewAdapter<>(this);
        }
    }
}