package com.example.testofindia.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testofindia.R;

public class CustomToastInflater
{

    private int HIDE_DELAY = 2000;

    private View mContainer;

    private int gravity = Gravity.CENTER;

    private TextView mTextView;

    private Handler mHandler;

    Context context;

    public CustomToastInflater(Context context, int HIDE_DELAY, int gravity, Drawable gradientBackgroundColor)
    {
        ViewGroup container = (ViewGroup) ((Activity) context)
                .findViewById(android.R.id.content);
        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View v = layoutInflater.inflate(
                R.layout.layout_custom_toast, container);
        this.HIDE_DELAY = HIDE_DELAY;
        this.gravity = gravity;
        this.context = context;
        init(v, gradientBackgroundColor);

    }

    private void init(View v, Drawable gradientBackgroundColor)
    {
        mContainer = v.findViewById(R.id.mbContainer);
        mContainer.setVisibility(View.GONE);
        mContainer.setBackground(gradientBackgroundColor);
        mTextView = (TextView) v.findViewById(R.id.mbMessage);
        mHandler = new Handler();

    }

    public void show(String message)
    {
        mContainer.setVisibility(View.VISIBLE);

        ((LinearLayout) mContainer).setGravity(gravity
                | Gravity.CENTER_VERTICAL);

        mTextView.setText(message);

        mContainer.startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left));
        mHandler.postDelayed(mHideRunnable, HIDE_DELAY);
    }

    private final Runnable mHideRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            mContainer.startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right));
            mContainer.setVisibility(View.GONE);
        }
    };
}
