package com.example.zarnea.earthquakeapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class EarthQuakeActivity extends Activity {


    ViewPager viewPager;
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        viewPager = findViewById(R.id.pager);

        // Creating ViewPager Adapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs
        adapter = new ViewPagerAdapter(activity.getSupportFragmentManager(), Titles, Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) v.findViewById(R.id.pager);
        pager.setAdapter(adapter);


    }
}
