
package com.example.testofindia.model.RecipeModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeDataResponse {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("Master_category_id")
    @Expose
    public Integer masterCategoryId;
    @SerializedName("Category_Name")
    @Expose
    public String categoryName;
    @SerializedName("Recipe_Name")
    @Expose
    public String recipeName;
    @SerializedName("Recipe_Ingredients")
    @Expose
    public String recipeIngredients;
    @SerializedName("Recipe_Detail")
    @Expose
    public String recipeDetail;
    @SerializedName("Channel_id")
    @Expose
    public Integer channelId;
    @SerializedName("Channel_Name")
    @Expose
    public String channelName;
    @SerializedName("Channel_Image")
    @Expose
    public String channelImage;
    @SerializedName("Tag")
    @Expose
    public String tag;
    @SerializedName("Veg_NonVeg")
    @Expose
    public String vegNonVeg;
    @SerializedName("Is_Deleted")
    @Expose
    public Integer isDeleted;
    @SerializedName("Is_Active")
    @Expose
    public Integer isActive;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeDetail() {
        return recipeDetail;
    }

    public void setRecipeDetail(String recipeDetail) {
        this.recipeDetail = recipeDetail;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelImage() {
        return channelImage;
    }

    public void setChannelImage(String channelImage) {
        this.channelImage = channelImage;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getVegNonVeg() {
        return vegNonVeg;
    }

    public void setVegNonVeg(String vegNonVeg) {
        this.vegNonVeg = vegNonVeg;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
