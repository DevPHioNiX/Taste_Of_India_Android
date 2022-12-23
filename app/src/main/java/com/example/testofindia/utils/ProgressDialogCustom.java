package com.example.testofindia.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

import com.example.testofindia.R;


public class ProgressDialogCustom {

    private Dialog mProgressDialog;
    Context context;

    public ProgressDialogCustom(Context context, boolean isShow) {
        this.context = context;
        if (isShow) {
            mProgressDialog = ProgressDialog.show(context, null, null, true, false);
            mProgressDialog.setContentView(R.layout.custom_progress_dialog);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }
    }
    public void ProgressDialogCustomShow(boolean isShow) {
        try {
            if (mProgressDialog != null) {
                if (isShow) {
                    mProgressDialog.show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Dismiss dialog
    public void dismissProgressDialog() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
            }
        } catch (Exception e) {

        }
    }
}
