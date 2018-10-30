package com.lay.laykypro.adapter.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.lay.laykypro.view.MainFragmentClid.MainClidFragment;

import java.util.ArrayList;

public class MainClidFragmentViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<MainClidFragment> mcfList;
    private FragmentManager fragmentManager;

    public MainClidFragmentViewPagerAdapter(FragmentManager fm, ArrayList<MainClidFragment> mcfList) {
        super(fm);
        this.mcfList=mcfList;
        this.fragmentManager=fm;
    }

    @Override
    public Fragment getItem(int position) {
        return mcfList.get(position);
    }

    @Override
    public int getCount() {
        return mcfList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        super.destroyItem(container, position, object);
    }
}
