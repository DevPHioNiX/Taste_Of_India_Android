package com.example.testofindia.view.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.bumptech.glide.Glide;
import com.example.testofindia.R;
import com.example.testofindia.databinding.ActivityAddChennelDataBinding;
import com.example.testofindia.databinding.ActivityCreateChennelBinding;
import com.example.testofindia.model.CreateChannelModel.CreateChannelData;
import com.example.testofindia.retrofit.ApiRequest;
import com.example.testofindia.retrofit.RetrofitRequest;
import com.example.testofindia.utils.CustomeConstants;
import com.example.testofindia.utils.DialogUtils;
import com.example.testofindia.utils.PreferenceHelper;
import com.example.testofindia.utils.ProgressDialogCustom;
import com.example.testofindia.utils.TakePicture;
import com.example.testofindia.utils.UtilsData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddChennelDataActivity extends Base_Activity {

    private ActivityAddChennelDataBinding mBinding;
    private ProgressDialogCustom progressDialog = null;
    private CreateChannelData createChannelData = new CreateChannelData();
    private ApiRequest apiRequest;
    String firstName, lastName, city, state, email, address, DateOfBirth, banner_image, channel_image;
    TakePicture takePicture;
    String SELECTED_PATH1,SELECTED_PATH;
    private static int REQUEST_ID_MULTIPLE_PERMISSIONS = 101;
    boolean picture1 = false;
    boolean picture2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(activity, R.layout.activity_add_chennel_data);
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        onCreateMethod();
        takePicture = new TakePicture(activity);
    }

    private void onCreateMethod() {
        onClickListner();

        Intent intent = getIntent();
        firstName = intent.getStringExtra("FirstName");
        lastName = intent.getStringExtra("LastName");
        email = intent.getStringExtra("Email");
        city = intent.getStringExtra("City");
        state = intent.getStringExtra("State");
        address = intent.getStringExtra("Address");
        DateOfBirth = intent.getStringExtra("DateOfBirth");
    }

    private void onClickListner() {
        mBinding.imageBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picture1 = true;
                if (checkAndRequestPermissions(activity)) {
                    try {
                        takePicture.selectImage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        mBinding.channelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picture2 = true;
                if (checkAndRequestPermissions(activity)) {
                    try {
                        takePicture.selectImage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        mBinding.tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData();
            }
        });
    }

    public static boolean checkAndRequestPermissions(final Activity context) {
        int WExtstorePermission = ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int cameraPermission = ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }
        if (WExtstorePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded
                    .add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(context, listPermissionsNeeded
                            .toArray(new String[listPermissionsNeeded.size()]),
                    REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (picture1) {
                try {
                    SELECTED_PATH = takePicture.onActivityResult(requestCode, resultCode, data);
                    Log.e(TAG, "onActivityResult:data "+data );
                    Log.e(TAG, "onActivityResult:requestCode "+requestCode );
                    Log.e(TAG, "onActivityResult:resultCode "+resultCode );
                    Log.e(TAG, "Path:>>>>>>>>>>> " + SELECTED_PATH);
                    Bitmap bm = BitmapFactory.decodeFile(SELECTED_PATH.toString());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
                    byte[] bytes = baos.toByteArray();
                    Log.e(TAG, "onActivityResult: "+bytes );
                    banner_image = Base64.encodeToString(bytes, Base64.DEFAULT);
                    Log.e(TAG, "onActivityResult:1 >>>>>>>>" + banner_image, null);
                    Glide.with(context).load(SELECTED_PATH).into(mBinding.imageBanner);
                    picture1 = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (picture2) {
                try {
                     SELECTED_PATH1 = takePicture.onActivityResult(requestCode, resultCode, data);
                    Log.e(TAG, "Path:>>>>>>>>>>> " + SELECTED_PATH1);
                    Bitmap bm = BitmapFactory.decodeFile(SELECTED_PATH1.toString());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
                    byte[] bytes = baos.toByteArray();
                    channel_image = Base64.encodeToString(bytes, Base64.DEFAULT);
                    Log.e(TAG, "onActivityResult: >>>>>>>>" + channel_image, null);
                    Glide.with(context).load(SELECTED_PATH1).into(mBinding.channelImage);
                    picture2 = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void postData() {
        progressDialog = new ProgressDialogCustom(context, true);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Firebase_id", "" + PreferenceHelper.getString(CustomeConstants.FIREBASE_ID, ""));
            jsonObject.put("First_Name", "" + firstName);
            jsonObject.put("Last_Name", "" + lastName);
            jsonObject.put("Gender", "" + "");
            jsonObject.put("Date_of_birth", "" + DateOfBirth);
            jsonObject.put("Email_Id", "" + email);
            jsonObject.put("Address", "" + address);
            jsonObject.put("City", "" + city);
            jsonObject.put("State", "" + state);
            jsonObject.put("Channel_Banner_Image", "" + SELECTED_PATH);
            jsonObject.put("Channel_Name", "" + mBinding.editChannelName.getText().toString());
            jsonObject.put("Channel_tag_line", "" + mBinding.editChannelPickUpLine.getText().toString());
            jsonObject.put("Channel_Image", "" +SELECTED_PATH1);
            jsonObject.put("Mobile_Device_Id", "" +UtilsData.getDeviceId(context));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonObject gsonObject = (JsonObject) new JsonParser().parse(jsonObject.toString());
        Log.e("TAG", "postData: " + gsonObject, null);

        apiRequest = RetrofitRequest.getClient().create(ApiRequest.class);
        apiRequest.CreateChannel(gsonObject).enqueue(new Callback<CreateChannelData>() {
            @Override
            public void onResponse(Call<CreateChannelData> call, Response<CreateChannelData> response) {
                progressDialog.dismissProgressDialog();
                try {
                    createChannelData = response.body();
                    Log.e("TAG", "onResponse: login" + new Gson().toJson(createChannelData), null);

                    createChannelData.getData();
                    toast(createChannelData.getData().getChannelName());
                    mBinding.celebration.build()
                            .addColors(Color.RED, Color.GREEN, Color.MAGENTA, Color.BLUE, Color.YELLOW)
                            .setDirection(0.0, 359.0)
                            .setSpeed(1f, 5f)
                            .setFadeOutEnabled(true)
                            .setTimeToLive(2000L)
                            .addShapes(Shape.RECT, Shape.CIRCLE)
                            .addSizes(new Size(10, 5))
                            .setPosition(-50f, mBinding.celebration.getWidth() + 50f, -50f, -50f)
                            .streamFor(300, 5000L);

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("TAG", "onResponse: " + e.getMessage(), null);
                }
            }

            @Override
            public void onFailure(Call<CreateChannelData> call, Throwable t) {
                progressDialog.dismissProgressDialog();
                if (isNetworkAvailable()) {
                    new DialogUtils(context).showAlertDialog(context.getResources().getString(R.string.app_name), context.getResources().getString(R.string.something_went_wrong), context.getResources().getString(R.string.ok), "", "", 1, false);
                } else {
                    new DialogUtils(context).showAlertDialog(context.getResources().getString(R.string.app_name), context.getResources().getString(R.string.check_internet), context.getResources().getString(R.string.ok), "", "", 1, false);
                }
                Logger.e("onResponse throwable:: " + t.getMessage());
            }
        });
    }

}