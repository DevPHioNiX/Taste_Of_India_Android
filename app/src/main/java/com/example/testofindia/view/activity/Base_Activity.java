package com.example.testofindia.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testofindia.R;
import com.tapadoo.alerter.Alerter;

public class Base_Activity extends AppCompatActivity {

    Context context;
    Activity activity;
    String TAG = "Base_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = this.getWindow();
        //Drawable background = this.getResources().getDrawable(R.drawable.right_left_to_heder);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.white));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        window.setNavigationBarColor(this.getResources().getColor(R.color.white));
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //window.setBackgroundDrawable(background);
        context = Base_Activity.this;
        activity = Base_Activity.this;
    }

    public boolean isNetworkAvailable() {
        NetworkInfo netInfo = null;
        try {
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            netInfo = cm.getActiveNetworkInfo();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


    public void toast(String x) {
        Toast.makeText(Base_Activity.this, x, Toast.LENGTH_SHORT).show();
    }

    public void toast_short(String x) {
        Toast.makeText(Base_Activity.this, x, Toast.LENGTH_SHORT).show();
    }

    public void toast_center_long(String x) {
        Toast toast = Toast.makeText(Base_Activity.this, x, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

  /*  public void toast_center_short(String x) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout));
        TextView tv = (TextView) layout.findViewById(R.id.txtvw);
        tv.setText(x);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 180);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }*/

    public void toast_center_short_red(String x) {
        LayoutInflater inflater = getLayoutInflater();
      /*  View layout = inflater.inflate(R.layout.custom_toast_red, (ViewGroup) findViewById(R.id.custom_toast_layout));
        TextView tv = (TextView) layout.findViewById(R.id.txtvw);
        tv.setText(x);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 180);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();*/
    }
    public void toast_top_short(String x) {
        Toast toast = Toast.makeText(Base_Activity.this, x, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) Base_Activity.this
                .getSystemService(Activity.INPUT_METHOD_SERVICE);
        Activity act = Base_Activity.this;
        if (act.getCurrentFocus() != null)
            inputMethodManager.hideSoftInputFromWindow(act.getCurrentFocus().getWindowToken(), 0);
    }

    public void openSoftKeyboard(EditText myEditText) {
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                .showSoftInput(myEditText, InputMethodManager.SHOW_FORCED);
    }

    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public boolean appInstalledOrNot(String uri) {
        PackageManager pm = Base_Activity.this.getPackageManager();
        boolean app_installed;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    public void networkAlerter(Activity activity) {

        Alerter.create(activity)
                .setTitle(getString(R.string.nointernet))
                .setText(getString(R.string.check_internet))
                .setTextAppearance(R.style.Alerter_TextAppearance)
                .setDuration(3500)
                .setBackgroundColorRes(R.color.colorAccent)
                .setIconColorFilter(context.getResources().getColor(R.color.status_color_dark))
                .setIcon(R.drawable.no_internet)
                .show();
    }

    public int dpSize(Context context, int val) {
        final int marginInDp_3 = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, val, context.getResources()
                        .getDisplayMetrics());
        return marginInDp_3;
    }

}