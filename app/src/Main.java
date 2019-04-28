package com.example.hack;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity {
    ViewPager viewPager;
    int images[] = {R.drawable.gul, R.drawable.gul1, R.drawable.gul2, R.drawable.gul3};
    MyCustomPagerAdapter myCustomPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        viewPager = findViewById(R.id.viewPager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(Main.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);
    }
}

