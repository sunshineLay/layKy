package com.lay.laykypro.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lay.laykypro.R;
import com.lay.laykypro.adapter.Fragment.FocusViewPagerAdapter;
import com.lay.laykypro.view.MainFragmentClid.FocusClidWorksFragment;


import java.util.ArrayList;
import java.util.List;

//关注部分：接口：
//作品部分：http://baobab.kaiyanapp.com/api/v6/community/tab/follow?udid=bd4602def0ed4576b145297b0bc8dc6c6b414e3b&vc=376&vn=4.2.2&deviceModel=BLN-AL40&first_channel=eyepetizer_zhihuiyun_market&last_channel=eyepetizer_zhihuiyun_market&system_version_code=24

//动态部分：http://baobab.kaiyanapp.com/api/v6/community/tab/dynamicFeeds?udid=bd4602def0ed4576b145297b0bc8dc6c6b414e3b&vc=376&vn=4.2.2&deviceModel=BLN-AL40&first_channel=eyepetizer_zhihuiyun_market&last_channel=eyepetizer_zhihuiyun_market&system_version_code=24

public class FocusFragment extends Fragment {

    private ViewPager vpFocus;
    private TabLayout tabFocus;
    private ArrayList<String> stringArrayList;
    private ArrayList<Fragment> fragmentArrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_focus, container, false);

        initData();
        initView(view);
        return view;
    }

    /**
     * FocusClidFragment 的List
     */
    private void initData() {
        stringArrayList = new ArrayList<>();
        stringArrayList.add("作品");
        stringArrayList.add("动态");

        fragmentArrayList = new ArrayList<>();
        FocusClidWorksFragment focusClidWorksFragment = new FocusClidWorksFragment();
        FocusClidWorksFragment focusClidWorksFragment1 = new FocusClidWorksFragment();
        fragmentArrayList.add(focusClidWorksFragment);
        fragmentArrayList.add(focusClidWorksFragment1);
//        WorksTestFragment worksTestFragment = new WorksTestFragment();
//        WorksTestFragment worksTestFragment1 = new WorksTestFragment();
//        fragmentArrayList.add(worksTestFragment);
//        fragmentArrayList.add(worksTestFragment1);


    }

    private void initView(View view) {
        vpFocus = (ViewPager) view.findViewById(R.id.vp_fragfocus);
        tabFocus = (TabLayout) view.findViewById(R.id.focus_tab_head);
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return stringArrayList.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                return fragmentArrayList.get(position);
            }

            @Override
            public int getCount() {
                return stringArrayList.size();
            }
        };
        vpFocus.setAdapter(mAdapter);
        tabFocus.setupWithViewPager(vpFocus);

        tabFocus.setTabsFromPagerAdapter(mAdapter);




    }


}
