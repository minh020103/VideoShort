package com.example.videoshort.view.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class HomeViewPage2Adapter extends FragmentStateAdapter {

    public static final int FRIEND = 0;
    public static final int FOLLOWED = 1;
    public static final int MY_VIDEO = 2;
    private List<Fragment> fragments;
    public HomeViewPage2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
