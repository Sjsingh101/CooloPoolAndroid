package com.coolopool.coolopool.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.coolopool.coolopool.Fragments.HomeFragment;
import com.coolopool.coolopool.Fragments.HotelFragment;
import com.coolopool.coolopool.Fragments.RestaurantsFragment;

public class MainStatePageAdapter extends FragmentStatePagerAdapter {

    Fragment[] fragments = {new HomeFragment(), new HotelFragment(), new RestaurantsFragment()};


    public MainStatePageAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        return fragments[i];
    }

    @Override
    public int getCount() {
        return 3;
    }
}
