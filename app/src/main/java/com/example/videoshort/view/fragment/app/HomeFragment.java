package com.example.videoshort.view.fragment.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.videoshort.R;
import com.example.videoshort.view.adapter.HomeViewPage2Adapter;
import com.example.videoshort.view.fragment.home.FollowFragment;
import com.example.videoshort.view.fragment.home.ForYouFragment;
import com.example.videoshort.view.fragment.home.FriendFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private TabLayout tabHome;
    private ViewPager2 vp2Home;
    private HomeViewPage2Adapter adapter;
    private List<Fragment> fragments;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_layout, container, false);
        anhXa(view);
        tabHome.setTabMode(TabLayout.GRAVITY_FILL);
        adapter = new HomeViewPage2Adapter(getActivity());
        fragments = new ArrayList<>();
        fragments.add(new FollowFragment());
        fragments.add(new FriendFragment());
        fragments.add(new ForYouFragment());
        adapter.setFragments(fragments);
        vp2Home.setAdapter(adapter);
        vp2Home.setCurrentItem(2, false);
        new TabLayoutMediator(tabHome, vp2Home, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Bạn bè");
                    break;
                case 1:
                    tab.setText("Đã theo dõi");
                    break;
                case 2:
                    tab.setText("Dành cho bạn");
                    break;
            }
        }).attach();
        return view;
    }

    private void anhXa(View view) {
        tabHome = view.findViewById(R.id.tabHome);
        vp2Home = view.findViewById(R.id.vp2Home);
    }
}