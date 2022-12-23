
package com.example.testofindia.model.ChannelListModel;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChannelListDataResponse implements Serializable {

    @SerializedName("data")
    @Expose
    public List<ChannelListData> data = null;

    public List<ChannelListData> getData() {
        return data;
    }

    public void setData(List<ChannelListData> data) {
        this.data = data;
    }
}
