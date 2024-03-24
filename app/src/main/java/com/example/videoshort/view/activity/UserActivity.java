package com.example.videoshort.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.videoshort.R;
import com.example.videoshort.view.fragment.app.HomeFragment;
import com.example.videoshort.view.fragment.app.MailBoxFragment;
import com.example.videoshort.view.fragment.app.ProfileFragment;
import com.example.videoshort.view.fragment.app.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class UserActivity extends AppCompatActivity {

    private final int HOME_SCREEN = 0;
    private final int SHOP_SCREEN = 1;
    private final int MAILBOX_SCREEN = 2;
    private final int PROFILE_SCREEN = 3;
    private Fragment fragment;
    private FragmentTransaction transaction;

    private BottomNavigationView bnvUser;
    private int screenID = HOME_SCREEN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_layout);
        anhXa();
        replaceFragment();
        onClickItemInNavigation();


    }



    private void onClickItemInNavigation() {
        bnvUser.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navHome){
                    screenID = HOME_SCREEN;
                    replaceFragment();
                }else if (item.getItemId() == R.id.navShop){
                    screenID = SHOP_SCREEN;
                    replaceFragment();
                }else if (item.getItemId() == R.id.navAddVideo){
                    Log.d("TAG", "Chuyển qua màn hình quay video ");
                }else if (item.getItemId() == R.id.navMessage){
                    screenID = MAILBOX_SCREEN;
                    replaceFragment();
                }else if (item.getItemId() == R.id.navProfile){
                    screenID = PROFILE_SCREEN;
                    replaceFragment();
                } else {
                    throw new IllegalStateException("Id của item chưa được tạo case: " + item.getItemId());
                }
                return true;
            }
        });
    }

    private void anhXa() {
        bnvUser = findViewById(R.id.bnvUser);
    }

    private void replaceFragment(){
        if (getSupportFragmentManager().findFragmentByTag(screenID + "") != null) {
            fragment = getSupportFragmentManager().findFragmentByTag(screenID + "");
        } else {
            if (screenID == HOME_SCREEN) {
                fragment = new HomeFragment();
            }
            if (screenID == SHOP_SCREEN) {
                fragment = new ShopFragment();
            }
            if (screenID == MAILBOX_SCREEN) {
                fragment = new MailBoxFragment();
            }
            if (screenID == PROFILE_SCREEN) {
                fragment = new ProfileFragment();
            }
        }

        if (fragment != null) {
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.idUserFragment, fragment, screenID + "");
            if (getSupportFragmentManager().findFragmentByTag(screenID + "") == null) {
                transaction.addToBackStack(screenID + "");
            }
            transaction.commit();
        }
    }
}