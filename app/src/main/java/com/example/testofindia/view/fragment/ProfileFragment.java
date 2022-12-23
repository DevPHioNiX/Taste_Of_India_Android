package com.example.testofindia.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testofindia.R;
import com.example.testofindia.databinding.FragmentProfileBinding;
import com.example.testofindia.view.activity.Base_Activity;
import com.example.testofindia.view.activity.CreateChennelActivity;

public class ProfileFragment extends Base_Fragment {

    private FragmentProfileBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);

        onCreatedMethod();

        return mBinding.getRoot();
    }

    private void onCreatedMethod() {
        onClickListner();
    }

    private void onClickListner() {
            mBinding.tvAddChannel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, CreateChennelActivity.class);
                    startActivity(intent);
                }
            });

    }
}