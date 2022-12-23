package com.example.testofindia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testofindia.R;
import com.example.testofindia.model.SliderData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.CustomerHomeFirstSliderHolder> {

    List<SliderData> list = Collections.emptyList();
    Context context;

    public SliderAdapter(List<SliderData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomerHomeFirstSliderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, parent, false);
        CustomerHomeFirstSliderHolder holder = new CustomerHomeFirstSliderHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerHomeFirstSliderHolder holder, int position) {
        final SliderData sliderItem = list.get(position);

        // Glide is use to load image
        // from url in your imageview.
        Glide.with(holder.itemView)
                .load(sliderItem.getImgUrl())
                .fitCenter()
                .into(holder.img_home_first_slider);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CustomerHomeFirstSliderHolder extends RecyclerView.ViewHolder {

        ImageView img_home_first_slider;


        public CustomerHomeFirstSliderHolder(@NonNull View itemView) {
            super(itemView);
            img_home_first_slider = itemView.findViewById(R.id.myimage);


        }

    }

}
