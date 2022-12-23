package com.example.testofindia.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.testofindia.R;
import com.example.testofindia.adapter.AllCategoryAdapter;
import com.example.testofindia.adapter.CategoryAdapter;
import com.example.testofindia.databinding.ActivityAllCategoryBinding;
import com.example.testofindia.databinding.ActivityHomeBinding;
import com.example.testofindia.model.CategoryModel.CategoryData;
import com.example.testofindia.model.CategoryModel.CategoryDataDetail;
import com.example.testofindia.retrofit.ApiRequest;
import com.example.testofindia.retrofit.RetrofitRequest;
import com.example.testofindia.utils.CustomeConstants;
import com.example.testofindia.utils.DialogUtils;
import com.example.testofindia.utils.ProgressDialogCustom;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllCategoryActivity extends Base_Activity {

    private ActivityAllCategoryBinding mBinding;
    private ProgressDialogCustom progressDialog = null;

    List<CategoryDataDetail> categoryDataList = new ArrayList<>();
    private CategoryData getHomePageResponse = new CategoryData();
    private ApiRequest apiRequest;
    AllCategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(activity, R.layout.activity_all_category);
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.white));
        onCreateMethod();
    }

    private void onCreateMethod() {
        onClickListner();
        getListData();
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void onClickListner() {
    }

    private void getListData() {
        mBinding.shimmerRecyclerAllCategory.showShimmerAdapter();
        apiRequest = RetrofitRequest.getClient().create(ApiRequest.class);
        apiRequest.GetCategoryData().enqueue(new Callback<CategoryData>() {
            @Override
            public void onResponse(Call<CategoryData> call, Response<CategoryData> response) {
                try {
                    getHomePageResponse = response.body();
                    Log.e("TAG", "onResponseAddress: " + new Gson().toJson(getHomePageResponse), null);

                    categoryDataList = getHomePageResponse.getData();
                   /* if(categoryDataList.size() > 6){
                        mBinding.tvCategorySeeAll.setVisibility(View.VISIBLE);
                    }*/
                    Log.e("TAG", "onResponselist: " + categoryDataList);
                    mBinding.shimmerRecyclerAllCategory.hideShimmerAdapter();
                    categoryAdapter = new AllCategoryAdapter(context, categoryDataList, activity, new AllCategoryAdapter.OnViewClick() {
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
                    mBinding.shimmerRecyclerAllCategory.setHasFixedSize(true);
                    mBinding.shimmerRecyclerAllCategory.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL,false));
                    mBinding.shimmerRecyclerAllCategory.setAdapter(categoryAdapter);


                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<CategoryData> call, Throwable t) {
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