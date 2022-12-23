package com.example.testofindia.retrofit;

import com.example.testofindia.model.CategoryModel.CategoryData;
import com.example.testofindia.model.ChannelListModel.ChannelListData;
import com.example.testofindia.model.ChannelListModel.ChannelListDataResponse;
import com.example.testofindia.model.CreateChannelModel.CreateChannelData;
import com.example.testofindia.model.RecipeModel.RecipeData;
import com.example.testofindia.model.SubcategoryModel.SubCategoryData;
import com.google.gson.JsonObject;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiRequest {

    @GET(ApiConstant.CATEGORY_API)
    Call<CategoryData> GetCategoryData();

    @GET(ApiConstant.SUBCATEGORY_API)
    Call<RecipeData> GetSubCategoryData(@Path("id") int CategpryID);

    @GET(ApiConstant.CHANNEL_LIST_API)
    Call<ChannelListDataResponse> GetChannelListData();

    @POST(ApiConstant.CHANNEL_API)
    Call<CreateChannelData> CreateChannel(@Body JsonObject jsonObject);


}