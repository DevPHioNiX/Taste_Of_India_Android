package com.example.testofindia.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;

import com.example.testofindia.R;
import com.example.testofindia.adapter.AllChannelListAdapter;
import com.example.testofindia.adapter.ChannelListAdapter;
import com.example.testofindia.databinding.ActivityAllChannelBinding;
import com.example.testofindia.databinding.ActivitySearchBinding;
import com.example.testofindia.model.CategoryModel.CategoryData;
import com.example.testofindia.model.CategoryModel.CategoryDataDetail;
import com.example.testofindia.model.ChannelListModel.ChannelListData;
import com.example.testofindia.model.ChannelListModel.ChannelListDataResponse;
import com.example.testofindia.retrofit.ApiRequest;
import com.example.testofindia.retrofit.RetrofitRequest;
import com.example.testofindia.utils.DialogUtils;
import com.example.testofindia.utils.ProgressDialogCustom;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllChannelActivity extends Base_Activity {

    private ActivityAllChannelBinding mBinding;
    private ProgressDialogCustom progressDialog = null;
    private ApiRequest apiRequest;
    List<CategoryDataDetail> categoryDataList = new ArrayList<>();
    List<ChannelListData> channelListDataResponseList = new ArrayList<>();
    private CategoryData getHomePageResponse = new CategoryData();
    private ChannelListDataResponse getChannelData = new ChannelListDataResponse();
    AllChannelListAdapter allchannelListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(activity, R.layout.activity_all_channel);
        onCreateMethod();
    }

    private void onCreateMethod() {
        onClickListner();
        getChannelListData();
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void onClickListner() {

    }

    private void getChannelListData() {
        mBinding.shimmerRecyclerAllChannel.showShimmerAdapter();
        apiRequest = RetrofitRequest.getClient().create(ApiRequest.class);
        apiRequest.GetChannelListData().enqueue(new Callback<ChannelListDataResponse>() {
            @Override
            public void onResponse(Call<ChannelListDataResponse> call, Response<ChannelListDataResponse> response) {
                try {
                    getChannelData = response.body();
                    Log.e("TAG", "onResponseAddress:11 " + new Gson().toJson(getHomePageResponse), null);
                    channelListDataResponseList = getChannelData.getData();


                    Log.e("TAG", "onResponselist: " + categoryDataList);
                    mBinding.shimmerRecyclerAllChannel.hideShimmerAdapter();

                    allchannelListAdapter = new AllChannelListAdapter(context, channelListDataResponseList, activity, new AllChannelListAdapter.OnViewClick() {
                        @Override
                        public void onItemViewClick(String position, ChannelListData data, String check) {

                        }
                    });
                    mBinding.shimmerRecyclerAllChannel.setHasFixedSize(true);
                    mBinding.shimmerRecyclerAllChannel.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
                    mBinding.shimmerRecyclerAllChannel.setAdapter(allchannelListAdapter);


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

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            onBackPressed();
        }
        return true;
    }
}