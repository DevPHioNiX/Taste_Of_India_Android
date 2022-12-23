package com.example.testofindia.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.testofindia.R;
import com.example.testofindia.adapter.CategoryAdapter;
import com.example.testofindia.adapter.SubCategoryAdapter;
import com.example.testofindia.databinding.ActivitySubCategoryBinding;
import com.example.testofindia.model.RecipeModel.RecipeData;
import com.example.testofindia.model.RecipeModel.RecipeDataResponse;
import com.example.testofindia.model.SubcategoryModel.SubCategoryData;
import com.example.testofindia.model.SubcategoryModel.SubCategoryDataDetail;
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

public class SubCategoryActivity extends Base_Activity {

    private ActivitySubCategoryBinding mBinding;
    private ProgressDialogCustom progressDialog = null;

    List<RecipeDataResponse> categoryDataList = new ArrayList<>();
    private RecipeData getHomePageResponse = new RecipeData();
    private ApiRequest apiRequest;
    SubCategoryAdapter categoryAdapter;
    int categoryId;
    String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(activity, R.layout.activity_sub_category);
        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        categoryId = intent.getIntExtra("CATEGORY_ID", 0);
        categoryName = intent.getStringExtra("CATEGORY_NAME");
        Log.e(TAG, "onCreate: " + categoryId);

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        onCreateMethod();
    }

    private void onCreateMethod() {
        onClickListner();
        getListData();
        mBinding.tvCategoryName.setText(categoryName);
    }

    private void onClickListner() {
        mBinding.ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void getListData() {
        mBinding.shimmerRecyclerSubcategory.showShimmerAdapter();
        apiRequest = RetrofitRequest.getClient().create(ApiRequest.class);
        apiRequest.GetSubCategoryData(categoryId).enqueue(new Callback<RecipeData>() {
            @Override
            public void onResponse(Call<RecipeData> call, Response<RecipeData> response) {
                try {
                    getHomePageResponse = response.body();
                    Log.e("TAG", "onResponseAddress: " + new Gson().toJson(getHomePageResponse), null);

                    categoryDataList = getHomePageResponse.getData();
                    if(getHomePageResponse.getData()!=null || !getHomePageResponse.getData().equals("")) {

                        if (categoryDataList.size() > 0) {
                   /* if(categoryDataList.size() > 6){
                        mBinding.tvCategorySeeAll.setVisibility(View.VISIBLE);
                    }*/
                            mBinding.shimmerRecyclerSubcategory.hideShimmerAdapter();
                            Log.e("TAG", "onResponselist: " + categoryDataList);
                            categoryAdapter = new SubCategoryAdapter(context, categoryDataList, activity, new SubCategoryAdapter.OnViewClick() {
                                @Override
                                public void onItemViewClick(String position, RecipeDataResponse data, String check) {
                                    if (isNetworkAvailable()) {
                                        if (check.equalsIgnoreCase(CustomeConstants.VIEWDETAILS)) {
                                               /* Intent intent = new Intent(context, ProductCategory_Activity.class);
                                                intent.putExtra("CATEGORY_ID", getHomePageResponse.getResponse().get(0).getCategory().get(Integer.parseInt(position)).getCategoryId());
                                                intent.putExtra("CATEGORY_NAME", getHomePageResponse.getResponse().get(0).getCategory().get(Integer.parseInt(position)).getCategoryName());
                                                startActivity(intent);*/
                                        }
                                    } else {
                                        networkAlerter(activity);
                                    }
                                }
                            });
                            mBinding.shimmerRecyclerSubcategory.setHasFixedSize(true);
                            mBinding.shimmerRecyclerSubcategory.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
                            mBinding.shimmerRecyclerSubcategory.setAdapter(categoryAdapter);

                        } else {

                        }
                    }else{
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<RecipeData> call, Throwable t) {
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