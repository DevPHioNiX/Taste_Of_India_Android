package com.example.testofindia.retrofit;

import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {

    private static Retrofit retrofit;
    private static final String DATA_BASE_URL = "https://ideagrow.in";
    private static OkHttpClient.Builder client;

    public static Retrofit getRetrofitInstance(String pathUrl) {
        //Log.e("TAG", "postRegisterApi: >>>>>" + pathUrl, null);
        String base_url = "";
        if (TextUtils.isEmpty(pathUrl)) {
            base_url = "";
        } else {
            base_url = pathUrl;
        }
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        /*if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }*/
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …
        // add logging as last interceptor

        // Adding another interceptor to add fixed query parameters for every request.
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();
            HttpUrl url = originalHttpUrl.newBuilder()
                    .build();

            // Request customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .url(url);
//            requestBuilder.addHeader("Authorization", CustomeConstants.BEARER_KEY + PreferenceHelper.getString(CustomeConstants.BEARER_TOKEN, ""));
//            Log.e("TAG", "getRetrofitInstance: >>>>>>>>>" + CustomeConstants.BEARER_KEY + PreferenceHelper.getString(CustomeConstants.BEARER_TOKEN, ""), null);
            Request request = requestBuilder.build();
            return chain.proceed(request);
        });
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        httpClient.readTimeout(180, TimeUnit.SECONDS);
        httpClient.connectTimeout(180, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://ideagrow.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        return retrofit;
    }

    public static Retrofit postClient() {
        retrofit = null;
        if (retrofit == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // set your desired log level
//            if (BuildConfig.DEBUG) {
//                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//            }
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            // add your other interceptors …
            // add logging as last interceptor

            // Adding another interceptor to add fixed query parameters for every request.
            httpClient.addInterceptor(chain -> {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();
                HttpUrl url = originalHttpUrl.newBuilder()
                        .build();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);
//                requestBuilder.addHeader("ApiKey" ,"0f8fad5b-d9cb-469f-a165-70867728950e");
                //Log.e("TAG", "getRetrofitInstance: >>>>>>>>>" + CustomeConstants.BEARER_KEY + PreferenceHelper.getString(CustomeConstants.BEARER_TOKEN, ""), null);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            });
            httpClient.addInterceptor(logging);  // <-- this is the important line!
            httpClient.readTimeout(180, TimeUnit.SECONDS);
            httpClient.connectTimeout(180, TimeUnit.SECONDS);
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://corpusdata.in/apiservice.asmx/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BuildConfig.BASE_URL)//LOGIN_BASE_URL
//                    .addConverterFactory(GsonConverterFactory.create())
////                    .client(httpClient.build())
//                    .build();

        }

        return retrofit;
    }




    public static Retrofit getClient() {

        if (client == null) {
            client = new OkHttpClient.Builder();

            client.connectTimeout(3, TimeUnit.MINUTES);
            client.readTimeout(3, TimeUnit.MINUTES);

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.addInterceptor(loggingInterceptor);

        }

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(DATA_BASE_URL)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
