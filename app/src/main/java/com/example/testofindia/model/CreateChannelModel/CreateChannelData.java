
package com.example.testofindia.model.CreateChannelModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateChannelData {

    @SerializedName("data")
    @Expose
    private CreateChannelDataDetail data;

    public CreateChannelDataDetail getData() {
        return data;
    }

    public void setData(CreateChannelDataDetail data) {
        this.data = data;
    }

}
