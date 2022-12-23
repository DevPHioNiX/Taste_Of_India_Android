package com.example.testofindia.model.SubcategoryModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SubCategoryDataDetail implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("Master_Category_Id")
    @Expose
    private Integer masterCategoryId;
    @SerializedName("Sub_Category_Name")
    @Expose
    private String subCategoryName;
    @SerializedName("S_Image")
    @Expose
    private String sImage;
    @SerializedName("Is_Deleted")
    @Expose
    private Integer isDeleted;
    @SerializedName("Is_Active")
    @Expose
    private Integer isActive;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMasterCategoryId() {
        return masterCategoryId;
    }

    public void setMasterCategoryId(Integer masterCategoryId) {
        this.masterCategoryId = masterCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getsImage() {
        return sImage;
    }

    public void setsImage(String sImage) {
        this.sImage = sImage;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }
}
