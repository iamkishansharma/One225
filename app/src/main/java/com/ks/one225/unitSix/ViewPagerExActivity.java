package com.ks.one225.unitSix;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ks.one225.MainActivity;
import com.ks.one225.R;
import com.ks.one225.unitThree.fragments.Fragment1;
import com.ks.one225.unitThree.fragments.Fragment2;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerExActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_ex);
        setupViewPager();
    }
    private void setupViewPager(){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new VpFragment1());
        adapter.addFragment(new VpFragment2());

        ViewPager vp = findViewById(R.id.view_pager);
        vp.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        //pass the viewpager to the tab layout
        tabLayout.setupWithViewPager(vp);
        tabLayout.setBackgroundColor(getColor(R.color.black));
        tabLayout.setTabTextColors(getColor(R.color.yellow),getColor(R.color.cyan));

        //set the tab index and set text, icon, etc..
        tabLayout.getTabAt(0).setText("Page One");
        tabLayout.getTabAt(1).setText("Page Two");
    }


    class SectionsPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public SectionsPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment){
            mFragmentList.add(fragment);
        }
    }
}
