
package com.example.testofindia.model.CategoryModel;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryData implements Serializable {

    @SerializedName("data")
    @Expose
    private List<CategoryDataDetail> data = null;

    public List<CategoryDataDetail> getData() {
        return data;
    }

    public void setData(List<CategoryDataDetail> data) {
        this.data = data;
    }

}
