package com.example.testofindia.bubblenavigationmodule;
import android.graphics.Typeface;

import com.example.testofindia.bubblenavigationmodule.listener.BubbleNavigationChangeListener;

public interface IBubbleNavigation {
    void setNavigationChangeListener(BubbleNavigationChangeListener navigationChangeListener);

    void setTypeface(Typeface typeface);

    int getCurrentActiveItemPosition();

    void setCurrentActiveItem(int position);

    void setBadgeValue(int position, String value);
}