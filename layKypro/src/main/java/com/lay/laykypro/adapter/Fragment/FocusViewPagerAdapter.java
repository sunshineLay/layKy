package com.lay.laykypro.adapter.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.lay.laykypro.base.BaseFragment;

import java.util.List;

public class FocusViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> focusList;
    private FragmentManager mfragmentManager;

    public FocusViewPagerAdapter(FragmentManager fm, List<Fragment> focusList) {
        super(fm);
        this.focusList = focusList;
    }

    @Override
    public Fragment getItem(int position) {
        return focusList.get(position);
    }

    @Override
    public int getCount() {
        return focusList.size();
    }
}
