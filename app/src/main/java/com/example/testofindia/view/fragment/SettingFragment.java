package com.example.testofindia.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testofindia.R;
import com.example.testofindia.databinding.FragmentSearchBinding;
import com.example.testofindia.databinding.FragmentSettingBinding;
import com.example.testofindia.utils.CustomToast;
import com.example.testofindia.view.activity.AboutUsActivity;
import com.example.testofindia.view.activity.ContactActivity;

public class SettingFragment extends Fragment {

    private FragmentSettingBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false);

        onCreatedMethod();

        return mBinding.getRoot();
    }

    private void onCreatedMethod() {
        onClickListner();
    }

    private void onClickListner() {
        mBinding.relativeHoldingContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ContactActivity.class);
                startActivity(intent);
            }
        });

        mBinding.relativeHoldingAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AboutUsActivity.class);
                startActivity(intent);
            }
        });
        mBinding.relativeHoldingTermsAndConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomToast.infoToast(getContext(),"Coming Soon");
            }
        });

        mBinding.relativeHoldingRateApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomToast.infoToast(getContext(),"Coming Soon");
            }
        });

        mBinding.relativeHoldingPrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomToast.infoToast(getContext(),"Coming Soon");
            }
        });

        mBinding.relativeHoldingShareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomToast.infoToast(getContext(),"Coming Soon");
            }
        });
    }
}