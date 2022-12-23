package com.example.testofindia.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testofindia.R;
import com.example.testofindia.databinding.AdapterCategoryListBinding;
import com.example.testofindia.model.CategoryModel.CategoryData;
import com.example.testofindia.model.CategoryModel.CategoryDataDetail;
import com.example.testofindia.utils.CustomeConstants;
import com.example.testofindia.utils.UtilsData;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<CategoryDataDetail> dataList;
    Activity activity;
    LayoutInflater inflater;
    AdapterCategoryListBinding mBinding;
    private OnViewClick onViewClick;

    public CategoryAdapter(Context context, List<CategoryDataDetail> dataList, Activity activity, OnViewClick onViewClick) {
        this.context = context;
        this.dataList = dataList;
        this.activity = activity;
        this.onViewClick = onViewClick;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        mBinding = DataBindingUtil.inflate(inflater, R.layout.adapter_category_list, parent, false);
        return new MyHolder(mBinding.getRoot(), mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.setIsRecyclable(false);
        final MyHolder myHolder = (MyHolder) holder;
        CategoryDataDetail categoryData = dataList.get(position);
        myHolder.mBinding.ivCategoryName.setText(Html.fromHtml(categoryData.getCategoryName()));
//        UtilsData.glideImageLoader(context, categoryData.getData().get(position).getCImage(), null, myHolder.mBinding.ivCategoryImage);

        myHolder.mBinding.llCategorymain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onViewClick.onItemViewClick(String.valueOf(position), categoryData, CustomeConstants.VIEWDETAILS);
            }
        });

    }

    public interface OnViewClick {
        void onItemViewClick(String position, CategoryDataDetail data, String check);
    }

    @Override
    public int getItemCount() {
        if(dataList.size()>6){
            return 6;
        }else{
            return dataList.size();
        }

    }

    class MyHolder extends RecyclerView.ViewHolder {

        AdapterCategoryListBinding mBinding;

        public MyHolder(@NonNull View itemView, AdapterCategoryListBinding mBinding) {
            super(itemView);
            this.mBinding = mBinding;

            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);

            int width1 = metrics.widthPixels;

            double hight = 300;
            double width = 300;

            width = (width1 - (int) context.getResources().getDimension(R.dimen.size_55dp)) / 3;
            hight = width * 0.8;

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) width, (int) hight);
            layoutParams.gravity = Gravity.CENTER;
            layoutParams.setMargins(
                    (int) context.getResources().getDimension(R.dimen.size_5dp),
                    (int) context.getResources().getDimension(R.dimen.size_5dp),
                    (int) context.getResources().getDimension(R.dimen.size_5dp),
                    (int) context.getResources().getDimension(R.dimen.size_5dp));
            mBinding.llCategorymain.setLayoutParams(layoutParams);
        }
    }


}
