package com.example.android.miwok.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.miwok.R;
import com.example.android.miwok.ViewPagerUtilites.CustomFragmentsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.main_pager);
        CustomFragmentsPagerAdapter customFragmentsPagerAdapter =
                new CustomFragmentsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(customFragmentsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
