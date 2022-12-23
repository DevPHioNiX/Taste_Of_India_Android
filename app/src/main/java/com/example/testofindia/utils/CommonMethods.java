package com.example.testofindia.utils; /**
 * Created by %USERNAME% on 26,July,2021 Your company Your email
 **/


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AlertDialog;

import com.example.testofindia.R;


/**
 * Created by Urmil Shah on 7/26/21 - 26,July,2021//
 */
public class CommonMethods {


    public static void showDialog(Context context, String title, String message,
                                  DialogInterface.OnClickListener onYesClickListener,
                                  DialogInterface.OnClickListener onNoClickListener) {

        DialogInterface.OnClickListener cancelListener;
        if(onYesClickListener == null){
             cancelListener = (dialog, which) -> dialog.cancel();
        }else{
            cancelListener = onYesClickListener;
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.AlertDialogCustom));
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setPositiveButton(R.string.ok,cancelListener);
        if (onNoClickListener != null) {
            dialog.setNegativeButton(R.string.cancel, onNoClickListener);
        }
        dialog.setCancelable(false);
        dialog.show();
    }
    public static void showDialogNormal(Context context, String title, String message,
                                  DialogInterface.OnClickListener onYesClickListener) {

        DialogInterface.OnClickListener cancelListener;
        if(onYesClickListener == null){
             cancelListener = (dialog, which) -> dialog.cancel();
        }else{
            cancelListener = onYesClickListener;
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(new ContextThemeWrapper(context,R.style.AlertDialogCustom));
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setPositiveButton(R.string.ok,cancelListener);
        dialog.setCancelable(false);
        dialog.show();
    }

    public static String onlyDigits(String phoneNumber){
        return phoneNumber.replaceAll("\\D", "");
    }

    public static void hideSoftKeyboard(Context  context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context
                .getSystemService(Activity.INPUT_METHOD_SERVICE);
        Activity act = (Activity) context;
        if (act.getCurrentFocus() != null)
            inputMethodManager.hideSoftInputFromWindow(act.getCurrentFocus().getWindowToken(), 0);
    }

}
