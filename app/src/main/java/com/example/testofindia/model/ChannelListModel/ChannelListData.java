
package com.example.testofindia.model.ChannelListModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChannelListData implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("Channel_Name")
    @Expose
    public String channelName;
    @SerializedName("Channel_Image")
    @Expose
    public String channelImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
