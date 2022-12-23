
package com.example.testofindia.model.RecipeModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeData {

    @SerializedName("data")
    @Expose
    public List<RecipeDataResponse> data = null;

    public List<RecipeDataResponse> getData() {
        return data;
    }

    public void setData(List<RecipeDataResponse> data) {
        this.data = data;
    }
}
