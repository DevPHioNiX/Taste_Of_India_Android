package com.example.testofindia.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.testofindia.R;
import com.example.testofindia.adapter.CategoryAdapter;
import com.example.testofindia.adapter.ChannelListAdapter;
import com.example.testofindia.adapter.SliderAdapter;
import com.example.testofindia.databinding.FragmentHomeBinding;
import com.example.testofindia.model.CategoryModel.CategoryData;
import com.example.testofindia.model.CategoryModel.CategoryDataDetail;
import com.example.testofindia.model.ChannelListModel.ChannelListData;
import com.example.testofindia.model.ChannelListModel.ChannelListDataResponse;
import com.example.testofindia.model.SliderData;
import com.example.testofindia.retrofit.ApiRequest;
import com.example.testofindia.retrofit.RetrofitRequest;
import com.example.testofindia.utils.BannerLayout;
import com.example.testofindia.utils.CustomeConstants;
import com.example.testofindia.utils.DialogUtils;
import com.example.testofindia.utils.ProgressDialogCustom;
import com.example.testofindia.view.activity.AllCategoryActivity;
import com.example.testofindia.view.activity.AllChannelActivity;
import com.example.testofindia.view.activity.CreateChennelActivity;
import com.example.testofindia.view.activity.SubCategoryActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Base_Fragment {

    private FragmentHomeBinding mBinding;
    private ProgressDialogCustom progressDialog = null;
    String url1 = "https://ideagrow.in/public/Temp_img/healthy-eating-dieting-vegetarian-kitchen-260nw-483042196.webp";
    String url2 = "https://ideagrow.in/public/Temp_img/360_F_125473198_Ug0BJFGiyu5HtXjtQt5T9PSZfi9uECKZ.jpg";
    String url3 = "https://ideagrow.in/public/Temp_img/healthy-delicious-food-horizontal-banner-template_589629-139.webp";

    List<CategoryDataDetail> categoryDataList = new ArrayList<>();
    List<ChannelListData> channelListDataResponseList = new ArrayList<>();
    private CategoryData getHomePageResponse = new CategoryData();
    private ChannelListDataResponse getChannelData = new ChannelListDataResponse();
    private ApiRequest apiRequest;
    CategoryAdapter categoryAdapter;
    ChannelListAdapter channelListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        onCreatedMethod();

        return mBinding.getRoot();
    }

    private void onCreatedMethod() {
        getListData();
        getChannelListData();
        onClickListner();

        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        mBinding.adView.loadAd(adRequest);

        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        SliderAdapter adapter = new SliderAdapter(sliderDataArrayList, context);
        mBinding.bannerFirstSlider.setAdapter(adapter);
    }

    private void onClickListner() {
        mBinding.llCreatChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AllChannelActivity.class);
                startActivity(intent);
            }
        });
        mBinding.tvCategorySeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AllCategoryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getListData() {
        progressDialog = new ProgressDialogCustom(context, true);
        apiRequest = RetrofitRequest.getClient().create(ApiRequest.class);
        apiRequest.GetCategoryData().enqueue(new Callback<CategoryData>() {
            @Override
            public void onResponse(Call<CategoryData> call, Response<CategoryData> response) {
                progressDialog.dismissProgressDialog();
                try {
                    getHomePageResponse = response.body();
                    Log.e("TAG", "onResponseAddress: " + new Gson().toJson(getHomePageResponse), null);

                    categoryDataList = getHomePageResponse.getData();
                    Log.e("TAG", "onResponselist: " + categoryDataList);
                    categoryAdapter = new CategoryAdapter(context, categoryDataList, activity, new CategoryAdapter.OnViewClick() {
                        @Override
                        public void onItemViewClick(String position, CategoryDataDetail data, String check) {
                            if (isNetworkAvailable()) {
                                if (check.equalsIgnoreCase(CustomeConstants.VIEWDETAILS)) {
                                                Intent intent = new Intent(context, SubCategoryActivity.class);
                                                intent.putExtra("CATEGORY_ID", getHomePageResponse.getData().get(Integer.parseInt(position)).getId());
                                                intent.putExtra("CATEGORY_NAME", getHomePageResponse.getData().get(Integer.parseInt(position)).getCategoryName());
                                                startActivity(intent);
                                }
                            } else {
                                networkAlerter(activity);
                            }
                        }
                    });
                    mBinding.rvCategory.setHasFixedSize(true);
                    mBinding.rvCategory.setLayoutManager(new GridLayoutManager(context, 3));
                    mBinding.rvCategory.setAdapter(categoryAdapter);


                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<CategoryData> call, Throwable t) {
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

    private void getChannelListData() {
        apiRequest = RetrofitRequest.getClient().create(ApiRequest.class);
        apiRequest.GetChannelListData().enqueue(new Callback<ChannelListDataResponse>() {
            @Override
            public void onResponse(Call<ChannelListDataResponse> call, Response<ChannelListDataResponse> response) {
                try {
                    getChannelData = response.body();
                    Log.e("TAG", "onResponseAddress:11 " + new Gson().toJson(getHomePageResponse), null);
                    channelListDataResponseList = getChannelData.getData();


                    Log.e("TAG", "onResponselist: " + categoryDataList);
                    channelListAdapter = new ChannelListAdapter(context, channelListDataResponseList, activity, new ChannelListAdapter.OnViewClick() {
                        @Override
                        public void onItemViewClick(String position, ChannelListData data, String check) {

                        }
                    });
                    mBinding.rvChannel.setHasFixedSize(true);
                    mBinding.rvChannel.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                    mBinding.rvChannel.setAdapter(channelListAdapter);


                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ChannelListDataResponse> call, Throwable t) {
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