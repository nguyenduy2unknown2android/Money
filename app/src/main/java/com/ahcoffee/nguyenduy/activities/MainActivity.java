package com.ahcoffee.nguyenduy.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.ahcoffee.nguyenduy.fragments.CoffeeFragment;
import com.ahcoffee.nguyenduy.ahcoffee.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

public class MainActivity extends AppCompatActivity {
    private static int[] tab10 = new int[]
            {
                R.string.demo_tab_1,
                R.string.demo_tab_2,
                R.string.demo_tab_3,
                R.string.demo_tab_4,
                R.string.demo_tab_5,
                R.string.demo_tab_6,
                R.string.demo_tab_7,
                R.string.demo_tab_8,
                R.string.demo_tab_9,
                R.string.demo_tab_10
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase myFirebaseRef = new Firebase("https://sweltering-heat-7929.firebaseio.com/");
                myFirebaseRef.child("article").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        System.out.println(snapshot.getValue());
                    }

                    @Override
                    public void onCancelled(FirebaseError error) {
                    }
                });
                Snackbar.make(view, "Hello World!?!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        ViewGroup tab = (ViewGroup) findViewById(R.id.tab);
        tab.addView(LayoutInflater.from(this).inflate(R.layout.smart_indicator, tab, false));

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        FragmentPagerItems pages = new FragmentPagerItems(this);
        for (int titleResId : tab10) {
            pages.add(FragmentPagerItem.of(getString(titleResId), CoffeeFragment.class));
        }

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), pages);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
