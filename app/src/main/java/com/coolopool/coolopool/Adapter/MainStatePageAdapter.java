package com.coolopool.coolopool.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.coolopool.coolopool.Fragments.HomeFragment;

public class MainStatePageAdapter extends FragmentStatePagerAdapter {

    Fragment[] fragments = {new HomeFragment(), };


    public MainStatePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        HomeFragment homeFragment = new HomeFragment();

        return homeFragment;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
