package com.example.testofindia.view.activity;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.testofindia.R;
import com.example.testofindia.adapter.SliderAdapter;
import com.example.testofindia.databinding.ActivityHomeBinding;
import com.example.testofindia.model.SliderData;
import com.example.testofindia.utils.BannerLayout;
import com.example.testofindia.utils.ProgressDialogCustom;
import com.example.testofindia.view.fragment.HomeFragment;
import com.example.testofindia.view.fragment.ProfileFragment;
import com.example.testofindia.view.fragment.SearchFragment;
import com.example.testofindia.view.fragment.SettingFragment;

import java.util.ArrayList;

public class HomeActivity extends Base_Activity {

    private ActivityHomeBinding mBinding;
    private ProgressDialogCustom progressDialog = null;

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(activity, R.layout.activity_home);
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        onCreateMethod();

        loadFragment(new HomeFragment());
        position = 0;
        onMenuClicked();


    }

    private void onCreateMethod() {
        onClickListner();
    }

    private void onClickListner() {
        mBinding.llHomeMenu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                position = 0;
                onMenuClicked();
                if (isNetworkAvailable()) {
                    loadFragment(new HomeFragment());
                } else {
                    networkAlerter(activity);
                }
            }
        });
        mBinding.llSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position =1;
                onMenuClicked();
                if (isNetworkAvailable()) {
                    loadFragment(new SearchFragment());
                } else {
                    networkAlerter(activity);
                }
            }
        });
        mBinding.llSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position =2;
                onMenuClicked();
                if (isNetworkAvailable()) {
                    loadFragment(new SettingFragment());
                } else {
                    networkAlerter(activity);
                }
            }
        });
        mBinding.llProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position =3;
                onMenuClicked();
                if (isNetworkAvailable()) {
                    loadFragment(new ProfileFragment());
                } else {
                    networkAlerter(activity);
                }
            }
        });
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void onMenuClicked() {
        if (position == 0) {
            mBinding.ivhome.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_home_icon));
            mBinding.ivhome.setColorFilter(ContextCompat.getColor(context,R.color.colorPrimary));
            mBinding.viewHome.setBackground(context.getResources().getDrawable(R.drawable.home_line_colorprimary));
            mBinding.tvhome.setTextColor(ContextCompat.getColor(this,R.color.black));
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
            mBinding.ivhome.startAnimation(animation);
        } else {
            mBinding.ivhome.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_home_icon));
            mBinding.tvhome.setTextColor(ContextCompat.getColor(context,R.color.text_color_light));
            mBinding.viewHome.setBackground(context.getResources().getDrawable(R.drawable.home_line_white));
            mBinding.ivhome.setColorFilter(ContextCompat.getColor(context,R.color.grey_5));
        }
        if (position == 1) {
            mBinding.ivSearch.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_search_icon));
            mBinding.ivSearch.setColorFilter(ContextCompat.getColor(context,R.color.colorPrimary));
            mBinding.viewSearch.setBackground(context.getResources().getDrawable(R.drawable.home_line_colorprimary));
            mBinding.tvSearch.setTextColor(ContextCompat.getColor(context,R.color.black));
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
            mBinding.ivSearch.startAnimation(animation);
        } else {
            mBinding.ivSearch.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_search_icon));
            mBinding.tvSearch.setTextColor(ContextCompat.getColor(context,R.color.text_color_light));
            mBinding.viewSearch.setBackground(context.getResources().getDrawable(R.drawable.home_line_white));
            mBinding.ivSearch.setColorFilter(ContextCompat.getColor(context,R.color.grey_5));
        }
        if (position == 2) {
            mBinding.ivSetting.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_setting_icon));
            mBinding.ivSetting.setColorFilter(ContextCompat.getColor(context,R.color.colorPrimary));
            mBinding.viewSetting.setBackground(context.getResources().getDrawable(R.drawable.home_line_colorprimary));
            mBinding.tvSetting.setTextColor(ContextCompat.getColor(context,R.color.black));
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
            mBinding.ivSetting.startAnimation(animation);
        } else {
            mBinding.ivSetting.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_setting_icon));
            mBinding.tvSetting.setTextColor(ContextCompat.getColor(context,R.color.text_color_light));
            mBinding.viewSetting.setBackground(context.getResources().getDrawable(R.drawable.home_line_white));
            mBinding.ivSetting.setColorFilter(ContextCompat.getColor(context,R.color.grey_5));
        }
        if (position == 3) {
            mBinding.ivProfile.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_person_icon));
            mBinding.ivProfile.setColorFilter(ContextCompat.getColor(context,R.color.colorPrimary));
            mBinding.viewProfile.setBackground(context.getResources().getDrawable(R.drawable.home_line_colorprimary));
            mBinding.tvProfile.setTextColor(ContextCompat.getColor(context,R.color.black));
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
            mBinding.ivProfile.startAnimation(animation);
        } else {
            mBinding.ivProfile.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_person_icon));
            mBinding.tvProfile.setTextColor(ContextCompat.getColor(context,R.color.text_color_light));
            mBinding.viewProfile.setBackground(context.getResources().getDrawable(R.drawable.home_line_white));
            mBinding.ivProfile.setColorFilter(ContextCompat.getColor(context,R.color.grey_5));
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        fragmentManager1.beginTransaction().replace(R.id.f1Fragment, fragment).commit();
    }

}