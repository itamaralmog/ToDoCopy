package com.example.todocopy;

//package com.journaldev.tablayoutviewpager;

//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by Priyabrat on 21-08-2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    Fragment fragmentAll = new FragmentAll();
    Fragment fragmentActive = new FragmentActive();
    Fragment fragmentCompleted = new FragmentCompleted();

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = fragmentAll;
        if (position == 2)
        {
            fragment = fragmentAll;
        }
        else if (position == 1)
        {
            fragment = fragmentActive;
        }
        else if (position == 0)
        {
            fragment = fragmentCompleted;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "ALL";
        if (position == 2)
        {
            title = "ALL";
        }
        else if (position == 1)
        {
            title = "ACTIVE";
        }
        else if (position == 0)
        {
            title = "COMPLETED";
        }
        return title;
    }
}

