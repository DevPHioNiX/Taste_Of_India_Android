package com.example.testofindia.utils;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();

    private static MyApplication mInstance;
    public static Context appContext;
    private RequestQueue mRequestQueue;

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = getApplicationContext();

        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        mInstance = this;
        //Custom logger for android - initialization
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag(CustomeConstants.LOGGER_CUSTOM_TAG)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

        // Enabled only for debug. Disable for other release types
        /*Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.;
            }
        });*/

        FirebaseCrashlytics crashlytics = FirebaseCrashlytics.getInstance();
        crashlytics.setUserId(PreferenceHelper.getString(CustomeConstants.USER_ID, "0"));
        crashlytics.setCustomKey("BerarToken", PreferenceHelper.getString(CustomeConstants.BEARER_TOKEN, "0"));
        crashlytics.setCustomKey("DeviceId", UtilsData.getDeviceId(getApplicationContext()));
        crashlytics.setCustomKey("UserId", PreferenceHelper.getString(CustomeConstants.USER_ID, "0"));

        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.setUserId(PreferenceHelper.getString(CustomeConstants.USER_ID, "0"));
        mFirebaseAnalytics.setUserProperty("UserId", PreferenceHelper.getString(CustomeConstants.USER_ID, "0"));
        mFirebaseAnalytics.setUserProperty("DeviceId", UtilsData.getDeviceId(getApplicationContext()));

        Trace myTrace = FirebasePerformance.getInstance().newTrace("test_trace");
        myTrace.start();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static Context getAppContext() {
        return appContext;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static String trimMessage(String json) {
        String trimmedString = "";

        try {
            JSONObject jsonObject = new JSONObject(json);
            Iterator<String> iter = jsonObject.keys();
            while (iter.hasNext()) {
                String key = iter.next();
                try {
                    JSONArray value = jsonObject.getJSONArray(key);
                    for (int i = 0, size = value.length(); i < size; i++) {
                        Log.e("Errors in Form", "" + value.getString(i));
                        trimmedString += value.getString(i);
                        if (i < size - 1) {
                            trimmedString += '\n';
                        }
                    }
                } catch (JSONException e) {

                    trimmedString += jsonObject.optString(key);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        Log.e("Trimmed", "" + trimmedString);

        return trimmedString;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void cancelRequestInQueue(String tag) {
        getRequestQueue().cancelAll(tag);
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the no_user tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

}

