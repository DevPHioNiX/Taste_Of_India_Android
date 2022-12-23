package com.example.testofindia.view.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.testofindia.R;
import com.tapadoo.alerter.Alerter;

import java.io.ByteArrayOutputStream;
import java.util.Locale;

@SuppressWarnings("ALL")
@SuppressLint("NewApi")
public class Base_Fragment extends Fragment {

    //private ProgressDialog progressDialog;
    public Dialog dialog, dialog1, dialog_otps, dialog_otps_v, dialog_otps_d, dialog_otps_i, dialog_otps_vi, dialog_otps_t;
    Context context;
    Activity activity;
    Typeface tf;
    //public ProgressDialog pDialog, pDialog2, pDialog3, pDialog4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        try {
            Locale localeID = null;
            context = requireContext();
            activity = requireActivity();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void toast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }

    public void toast_long(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

  /*  public void toast_center_short(String x) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) activity.findViewById(R.id.custom_toast_layout));
        TextView tv = (TextView) layout.findViewById(R.id.txtvw);
        tv.setText(x);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.TOP, 0, 180);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
*/
    public boolean isNetworkAvailable() {
        NetworkInfo netInfo = null;
        try {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            netInfo = cm.getActiveNetworkInfo();
        } catch (SecurityException e) {
            // e.printStackTrace();
        }
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


    public boolean isempty_edittext(EditText edt) {
        if (edt.getText().length() == 0 && edt.getText().toString().equalsIgnoreCase("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isempty_auto(AutoCompleteTextView edt) {
        if (edt.getText().length() == 0 && edt.getText().toString().equalsIgnoreCase("")) {
            return true;
        } else {
            return false;
        }
    }

    public final static boolean isValidPhoneNumber(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            if (target.length() < 10 || target.length() > 14) {
                return false;
            } else {
                return android.util.Patterns.PHONE.matcher(target).matches();
            }
        }
    }


    /*---------------- check edit text e-mail adress is valid --------------------*/
    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality) {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }

    public void networkAlerter(Activity activity) {
        Alerter.create(activity)
                .setTitle(getString(R.string.nointernet))
                .setText(getString(R.string.check_internet))
                .setTextAppearance(R.style.Alerter_TextAppearance)
                .setDuration(3000)
                .setBackgroundColorRes(R.color.colorPrimary)
                .setIconColorFilter(context.getResources().getColor(R.color.white))
                .setIcon(R.drawable.no_internet)
                .show();
    }


}