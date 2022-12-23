package com.example.testofindia.utils;

import android.content.Context;
import android.view.Gravity;

import com.example.testofindia.R;


public class CustomToast
{


    public static void successToast(Context context, String message)
    {
        CustomToastInflater customToastInflater = new CustomToastInflater(context, 5000,Gravity.BOTTOM,context.getDrawable(R.drawable.gradient_background_green));
        customToastInflater.show(message);
    }
    public static void errorToast(Context context, String message)
    {
        CustomToastInflater customToastInflater = new CustomToastInflater(context, 5000,Gravity.BOTTOM,context.getDrawable(R.drawable.gradient_background_red));
        customToastInflater.show(message);
    }
    public static void infoToast(Context context, String message)
    {
        CustomToastInflater customToastInflater = new CustomToastInflater(context, 5000,Gravity.BOTTOM,context.getDrawable(R.drawable.gradient_background_blue));
        customToastInflater.show(message);
    }
    public static void warningToast(Context context, String message)
    {
        CustomToastInflater customToastInflater = new CustomToastInflater(context, 5000,Gravity.BOTTOM,context.getDrawable(R.drawable.gradient_background_red));
        customToastInflater.show(message);
    }

}
