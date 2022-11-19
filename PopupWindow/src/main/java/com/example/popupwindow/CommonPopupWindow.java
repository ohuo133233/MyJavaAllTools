package com.example.popupwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;

public class CommonPopupWindow extends PopupWindow {
    private View mRoot;

    public CommonPopupWindow(Build build) {
        super(build.mContext);
        mRoot = build.mRoot;
        setHeight(build.height);
        setWidth(build.width);

        setOutsideTouchable(build.touchable);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(build.mRoot);

    }

    public View findViewById(@IdRes int id) {
        return mRoot.findViewById(id);
    }


    public static class Build {
        private View mRoot;
        private Context mContext;
        private int width;
        private int height;
        private boolean touchable;

        public CommonPopupWindow.Build setContext(Context mContext) {
            this.mContext = mContext;
            return this;
        }

        public CommonPopupWindow.Build setLayout(@LayoutRes int mLayout) {
            this.mRoot = LayoutInflater.from(mContext).inflate(mLayout, null, false);
            return this;
        }

        public CommonPopupWindow.Build setWidth(int width) {
            this.width = width;
            return this;
        }

        public CommonPopupWindow.Build setHeight(int height) {
            this.height = height;
            return this;
        }

        public CommonPopupWindow.Build setOutsideTouchable(boolean touchable) {
            this.touchable = touchable;
            return this;
        }

//        public CommonPopupWindow.Build setRecyclerView(@IdRes int recyclerViewId, CommonRecyclerViewAdapter commonRecyclerViewAdapter, @Nullable RecyclerView.LayoutManager layout) {
//            RecyclerView recyclerView = mRoot.findViewById(recyclerViewId);
//            recyclerView.setAdapter(commonRecyclerViewAdapter);
//            recyclerView.setLayoutManager(layout);
//            return this;
//        }


        public CommonPopupWindow Build() {
            return new CommonPopupWindow(this);
        }
    }
}