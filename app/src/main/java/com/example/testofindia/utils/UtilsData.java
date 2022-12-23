package com.example.testofindia.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.testofindia.R;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;



public class UtilsData {
    public static void callIntent(Context mContext, String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null));
        mContext.startActivity(intent);
    }

    public static void glideImageLoader(Context mContext, String path, Drawable mDrawable, ImageView mImageView) {
        Glide.with(mContext).load(path)
                .placeholder(mDrawable)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .skipMemoryCache(true)
                .into(mImageView);
    }

    public static void showSettingsDialog(final Context context) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.dialog_permission_title));
        builder.setMessage(context.getString(R.string.dialog_permission_message));
        builder.setPositiveButton(context.getString(R.string.go_to_settings), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                openSettings(context);
            }
        });
        builder.setNegativeButton(context.getString(android.R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public static void openSettings(Context context) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
        intent.setData(uri);
        ActivityCompat.startActivityForResult((Activity) context, intent, 101, null);
    }

    public static void showDialog(Context context, String msg) {
        Toast.makeText(context, "" + msg, Toast.LENGTH_SHORT).show();
    }

    public static void showDialogLong(Context context, String msg) {
        Toast.makeText(context, "" + msg, Toast.LENGTH_LONG).show();
    }

    public static void showAlertDialogWithTwoClickListener(Context mActivity, String message, String mPositiveMsg, String mNagetiveMsg, DialogInterface.OnClickListener mPositiveListener, DialogInterface.OnClickListener mNagetiveListner) {
        new AlertDialog.Builder(mActivity)
                .setIcon(ContextCompat.getDrawable(mActivity, R.mipmap.ic_launcher))
                .setMessage(message)
                .setPositiveButton(mPositiveMsg, mPositiveListener)
                .setNegativeButton(mNagetiveMsg, mNagetiveListner)
                .setCancelable(false)
                .create()
                .show();
    }

    public static void onBackPressed(final Context mContext, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
        alertDialog.setCancelable(false);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton(mContext.getString(android.R.string.yes), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
                ActivityCompat.finishAffinity((Activity) mContext);
                System.exit(0);
            }
        });
        alertDialog.setNegativeButton(mContext.getString(android.R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();

    }

    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // test for connection
        if (cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public static void networkAlerter(Activity activity) {

//        Alerter.create(activity)
//                .setTitle(activity.getString(R.string.nointernet))
//                .setText(activity.getString(R.string.check_internet))
//                .setTextAppearance(R.style.Alerter_TextAppearance)
//                .setDuration(3500)
//                .setBackgroundColorRes(R.color.colorAccent)
//                .setIconColorFilter(activity.getResources().getColor(R.color.status_color_dark))
//                .setIcon(R.drawable.no_internet)
//                .show();

    }

    public static long indianTimeStamp() {
        //capturing today's date
        Date today = new Date();

        //displaying this date on IST timezone
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.Ms z");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        String IST = df.format(today);
        System.out.println("Date in Indian Timezone (IST) : " + IST);
        //  Log.e(TAG, "indianTimeStamp: >>>>>>" + IST, null);
        Date date = null;
        try {
            date = (Date) df.parse(IST);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static String makeUserId(String datetime) {
        String userId = "";
        Random rand = new Random();
        userId = String.format("%0" + (24 - datetime.length()) + "d", rand.nextInt(1000000000)) + datetime;
        return userId;
    }

    public static String getAmount(String datetime) {
        datetime = datetime.replace(",", "");
        datetime = datetime.replace(" ", "");
        return datetime;
    }

    public static String getPrice(double datetime) {
        String amount = String.format("%.2f", datetime);
        return amount;
    }

    public static String getIPAddress(boolean useIPv4) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress();
                        //boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr);
                        boolean isIPv4 = sAddr.indexOf(':') < 0;

                        if (useIPv4) {
                            if (isIPv4)
                                return sAddr;
                        } else {
                            if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // drop ip6 zone suffix
                                return delim < 0 ? sAddr.toUpperCase() : sAddr.substring(0, delim).toUpperCase();
                            }
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        } // for now eat exceptions
        return "";
    }

    @SuppressLint("HardwareIds")
    public static String getDeviceId(Context context) {
        String device_id = "";
        try {
            device_id = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return device_id;
    }

    public static String getDeviceName() {
        String device_name = "";
        try {
            device_name = Build.MODEL;
            device_name = device_name + " " + Build.MANUFACTURER;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return device_name;
    }

    public static String getAndroidVersion() {
        String android_version = "";
        try {
            android_version = "" + Build.VERSION.SDK_INT;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return android_version;
    }

    public static String getApplicationVersion(Context context) {
        String application_version = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            application_version = "" + packageInfo.versionCode;
            //  versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return application_version;
    }

    /*public static String getFirebaseToken() {
        String firebase_id = "";
        try {
            firebase_id = FirebaseInstanceId.getInstance().getToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "" + firebase_id;
    }*/

    public static String maskCardNumber(String cardNumber, String mask) {

        // format the number
        int index = 0;
        StringBuilder maskedNumber = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == '#') {
                maskedNumber.append(cardNumber.charAt(index));
                index++;
            } else if (c == 'x') {
                maskedNumber.append(c);
                index++;
            } else {
                maskedNumber.append(c);
            }
        }

        // return the masked number
        return maskedNumber.toString();
    }

    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        /*SuperActivityToast.create(context, new Style(), Style.TYPE_STANDARD)
                .setText(text)
                .setDuration(Style.DURATION_LONG)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(context.getResources().getColor(R.color.colorPrimary))
                .setAnimations(Style.ANIMATIONS_FADE).show();*/

//        Alerter.create((CaseDetailActivity) context)
//                .setTitle(text)
//                .setBackgroundColorRes(R.color.black)
//                .enableIconPulse(false)
//                .hideIcon()
//                .setDuration(3000)
//                .show();
    }

}
