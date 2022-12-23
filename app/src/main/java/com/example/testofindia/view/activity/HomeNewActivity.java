package com.example.testofindia.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.example.testofindia.R;
import com.example.testofindia.bubblenavigationmodule.BubbleNavigationLinearView;
import com.example.testofindia.bubblenavigationmodule.listener.BubbleNavigationChangeListener;
import com.example.testofindia.view.fragment.HomeFragment;
import com.example.testofindia.view.fragment.ProfileFragment;
import com.example.testofindia.view.fragment.SearchFragment;
import com.example.testofindia.view.fragment.SettingFragment;

public class HomeNewActivity extends AppCompatActivity {

    public BubbleNavigationLinearView bubble_navigation;
    private Fragment selectedFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_new);
        initUI();

    }

    private void initUI()
    {
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        bubble_navigation = findViewById(R.id.bubble_navigation);

        bubble_navigation.setNavigationChangeListener(new BubbleNavigationChangeListener()
        {
            @Override
            public void onNavigationChanged(View view, int position)
            {
                switch (position)
                {
                    case 0:
                        selectedFragment = new HomeFragment();
                        break;
                    case 1:
                        selectedFragment = new SearchFragment();
                        break;
                    case 2:
                        selectedFragment = new SettingFragment();
                        break;
                    case 3:
                        selectedFragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
            }
        });
        bubble_navigation.setCurrentActiveItem(0);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }

}