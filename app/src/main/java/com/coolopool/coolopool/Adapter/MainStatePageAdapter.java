package com.coolopool.coolopool.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.coolopool.coolopool.Fragments.HomeFragment;
import com.coolopool.coolopool.Fragments.HotelFragment;
import com.coolopool.coolopool.Fragments.ProfileFragment;
import com.coolopool.coolopool.Fragments.RestaurantsFragment;

public class MainStatePageAdapter extends FragmentStatePagerAdapter {

    Fragment[] fragments = {new HomeFragment(), new HotelFragment(), new RestaurantsFragment(), new ProfileFragment()};


    public MainStatePageAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        return fragments[i];
    }

    @Override
    public int getCount() {
        return 4;
    }
}
