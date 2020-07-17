package com.system.indipick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.tabs.TabLayout;

public class  Second_Page extends AppCompatActivity {
    //Initialize variable
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    int i;
    private int[] tabicons = {
            R.drawable.ic_baseline_search_24,
            R.drawable.ic_baseline_youtube_searched_for_24,
            R.drawable.ic_baseline_apps_24,
            R.drawable.ic_baseline_notifications_24
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__page);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
      //  toolbar = findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
       // setSupportActionBar(toolbar);
      //  getSupportActionBar().setTitle("IndiPick");
      //  toolbar.setSubtitle("IndianPick");
      //  toolbar.inflateMenu(R.menu.main_menu);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //Addind fragments
        adapter.AddFragment(new ProductsFragment(), "Category");
        adapter.AddFragment(new BrandFragment(), "Brand");
        adapter.AddFragment(new ScanFragment(), "Scan Apps");
        adapter.AddFragment(new RegisterFragment(), "Register");
        //Adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setUpTabIcons();

    }
    private void setUpTabIcons(){
        tabLayout.getTabAt(0).setIcon(tabicons[0]);
        tabLayout.getTabAt(1).setIcon(tabicons[1]);
        tabLayout.getTabAt(2).setIcon(tabicons[2]);
        tabLayout.getTabAt(3).setIcon(tabicons[3]);
        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#00008B"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#696969"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#696969"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.parseColor("#696969"), PorterDuff.Mode.SRC_IN);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#00008B"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#696969"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
