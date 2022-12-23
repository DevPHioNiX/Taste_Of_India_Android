package com.example.testofindia.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.testofindia.R;
import com.example.testofindia.databinding.ActivitySearchBinding;
import com.example.testofindia.databinding.ActivitySplashBinding;
import com.example.testofindia.utils.ProgressDialogCustom;

public class SearchActivity extends Base_Activity {

    private ActivitySearchBinding mBinding;
    private ProgressDialogCustom progressDialog = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(activity, R.layout.activity_search);
        onCreateMethod();
    }

    private void onCreateMethod() {
        onClickListner();
    }

    private void onClickListner() {
    }
}