package com.wang.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class CommonFragmentAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> mFragmentArrayList;

    public CommonFragmentAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Fragment> fragmentArrayList) {
        super(fragmentActivity);
        this.mFragmentArrayList = fragmentArrayList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragmentArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return mFragmentArrayList.size();
    }
}
