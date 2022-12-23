
package com.example.testofindia.model.SubcategoryModel;

import com.example.testofindia.model.CategoryModel.CategoryDataDetail;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SubCategoryData implements Serializable {

    @SerializedName("data")
    @Expose
    private List<SubCategoryDataDetail> data = null;

    public List<SubCategoryDataDetail> getData() {
        return data;
    }

    public void setData(List<SubCategoryDataDetail> data) {
        this.data = data;
    }

}
