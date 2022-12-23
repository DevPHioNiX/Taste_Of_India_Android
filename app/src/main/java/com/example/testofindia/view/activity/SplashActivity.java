package com.example.testofindia.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;

import com.example.testofindia.R;
import com.example.testofindia.databinding.ActivitySplashBinding;
import com.example.testofindia.utils.CustomeConstants;
import com.example.testofindia.utils.PreferenceHelper;
import com.example.testofindia.utils.ProgressDialogCustom;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.orhanobut.logger.Logger;

public class SplashActivity extends Base_Activity {

    private ActivitySplashBinding mBinding;
    private ProgressDialogCustom progressDialog = null;
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(activity, R.layout.activity_splash);
        onCreateMethod();
    }

    private void onCreateMethod() {
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        window.setNavigationBarColor(this.getResources().getColor(R.color.colorPrimary));

        onClickListner();
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w("TAG", "Fetching FCM registration token failed", task.getException());
                    Log.e("TAG", "onComplete: firbase " + task.getException());
                    return;
                }
                String token = task.getResult();
                PreferenceHelper.putString(CustomeConstants.FIREBASE_ID, "" + token);

                Logger.e(">>>>" + token);
            }
        });


        redirectScreen();
    }

    private void redirectScreen() {
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                        Intent intent = new Intent(context, HomeActivity.class);
                                startActivity(intent);
                        finishAffinity();
                }
            }
        };thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private void onClickListner() {
    }
}