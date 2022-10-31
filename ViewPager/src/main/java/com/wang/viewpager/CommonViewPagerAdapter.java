package com.wang.viewpager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommonViewPagerAdapter<T> extends RecyclerView.Adapter<CommonViewPagerViewHolder> {
    private static final String TAG = "CommonViewPagerAdapter";
    @NonNull
    private Context mContext;
    @LayoutRes
    private int mLayoutId;
    @NonNull
    private List<T> mDataList;

    private RecyclerView.ViewHolder mHolder;
    private CommonViewPagerAdapterBackCall mCommonViewPagerAdapterBackCall;
    private Build<T> mBuild;

    private CommonViewPagerAdapter(@NonNull Build<T> build) {
        mBuild = build;
        build();
    }

    @NonNull
    @Override
    public CommonViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(mContext).inflate(this.mLayoutId, parent, false);
        return new CommonViewPagerViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull CommonViewPagerViewHolder holder, int position) {
        mHolder = holder;
        if (mCommonViewPagerAdapterBackCall != null) {
            mCommonViewPagerAdapterBackCall.onBindViewHolder(holder, position);
        }
    }


    @Override
    public int getItemCount() {
        Log.d(TAG, "mDataList size: " + mDataList.size());
        return Math.max(mDataList.size(), 1);
    }

    private void build() {
        this.mContext = mBuild.mContext;
        this.mLayoutId = mBuild.mLayoutId;
        this.mDataList = mBuild.mDataList;
    }


    public void setCommonViewPagerAdapterBackCall(CommonViewPagerAdapterBackCall mCommonViewPagerAdapterBackCall) {
        this.mCommonViewPagerAdapterBackCall = mCommonViewPagerAdapterBackCall;
    }

    public static class Build<T> {
        @NonNull
        private Context mContext;
        @LayoutRes
        private int mLayoutId;
        @NonNull
        private List<T> mDataList;


        public Build<T> setContext(@NonNull Context mContext) {
            this.mContext = mContext;
            return this;
        }

        public Build<T> setLayoutId(@LayoutRes int mLayoutId) {
            this.mLayoutId = mLayoutId;
            return this;
        }

        public Build<T> setDataList(@NonNull List<T> mDataList) {
            this.mDataList = mDataList;
            return this;
        }

        public CommonViewPagerAdapter<T> build() {
            return new CommonViewPagerAdapter<>(this);
        }
    }
}