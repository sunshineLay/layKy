package com.lay.laykypro.view.Fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.lay.laykypro.R;
import com.lay.laykypro.adapter.Fragment.MainClidFragmentViewPagerAdapter;
import com.lay.laykypro.view.MainFragmentClid.MainClidFragment;


import java.util.ArrayList;


public class MainFragment extends Fragment implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private HorizontalScrollView horScrTitle;
    private LinearLayout linTitles;
    private ArrayList<TextView> textViewArrayList;
    private ImageView imgType;
    private ImageView imgSearch;

    private ArrayList<MainClidFragment> mcfList;
    private ViewPager vpFragMain;
//    public MainFragment(){}
    //Title 初始化
    private String[] titles=new String[]{"发现","推荐","日报","创意","音乐","旅行","科普","搞笑","时尚"};

    private static final String TAG="TAG";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        horScrTitle = (HorizontalScrollView) view.findViewById(R.id.scroll_fragmain_main);
        linTitles = (LinearLayout) view.findViewById(R.id.line_fragmain_main);
        imgType = (ImageView) view.findViewById(R.id.imgic_fragmain_main);
        imgSearch = (ImageView) view.findViewById(R.id.imgsearch_fragmain_main);

        initFragment();

        vpFragMain = (ViewPager) view.findViewById(R.id.vp_fragmain_main);
        MainClidFragmentViewPagerAdapter mcfvpAdapter = new MainClidFragmentViewPagerAdapter(getChildFragmentManager(), mcfList);
        vpFragMain.setAdapter(mcfvpAdapter);
        vpFragMain.setCurrentItem(0);
        vpFragMain.setOnPageChangeListener(this);

        imgType.setOnClickListener(this);
        imgSearch.setOnClickListener(this);
        initTitle();
        return view;
    }

    private void initFragment() {
        mcfList = new ArrayList<>();

        for (int i = 0; i < titles.length; i++) {
            MainClidFragment mainClidFragment = new MainClidFragment();
//            TestFragment testFragment = new TestFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("Num",i);
//            testFragment.setArguments(bundle);
            mainClidFragment.setArguments(bundle);
            mcfList.add(mainClidFragment);
//            mcfList.add(testFragment);

        }
    }
    /**
     * 标题栏初始化
     */
    private void initTitle() {
        //布局参数
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(160, 100);
        layoutParams.setMargins(20,20,10,0);
        textViewArrayList = new ArrayList<>();
        //初始化标题
        for (int i = 0; i < titles.length; i++) {
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(layoutParams);
            textView.setText(titles[i]);
            textView.setTextSize(14);
            textView.setId(i);
            textView.setOnClickListener(this);
            if(i==0){
                textView .setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            }
            linTitles.addView(textView);

            textViewArrayList.add(textView);

        }


    }
    /**
     * 点击标题栏改变标题栏文字的样式：普通还是加粗
     *
     * 两侧图片的点击事件
     * @param v
     */

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case 0:
                for(TextView textView:textViewArrayList){
                    textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
                 textViewArrayList.get(0).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                //vp展示的是第一个Fragment
                vpFragMain.setCurrentItem(0);
                break;
            case 1:
                for(TextView textView:textViewArrayList){
                    textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
                textViewArrayList.get(1).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                vpFragMain.setCurrentItem(1);
                break;
            case 2:
                for(TextView textView:textViewArrayList){
                    textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
                textViewArrayList.get(2).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                vpFragMain.setCurrentItem(2);
                break;
            case 3:
                for(TextView textView:textViewArrayList){
                    textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
                textViewArrayList.get(3).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                vpFragMain.setCurrentItem(3);
                break;
            case 4:
                for(TextView textView:textViewArrayList){
                    textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
                textViewArrayList.get(4).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                vpFragMain.setCurrentItem(4);
                break;
            case 5:
                for(TextView textView:textViewArrayList){
                    textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
                textViewArrayList.get(5).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                vpFragMain.setCurrentItem(5);
                break;
            case 6:
                for(TextView textView:textViewArrayList){
                    textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
                textViewArrayList.get(6).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                vpFragMain.setCurrentItem(6);
                break;
            case 7:
                for(TextView textView:textViewArrayList){
                    textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
                textViewArrayList.get(7).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                vpFragMain.setCurrentItem(7);
                break;
            case 8:
                for(TextView textView:textViewArrayList){
                    textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
                textViewArrayList.get(8).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                vpFragMain.setCurrentItem(8);
                break;
            case R.id.imgic_fragmain_main:
                Log.d(TAG, "onClick: "+"我是分类！！！");
                Toast.makeText(getActivity(),"我是分类！！！",Toast.LENGTH_LONG).show();
                break;
            case R.id.imgsearch_fragmain_main:
                Log.d(TAG, "onClick: "+"我是搜索！！！");
                Toast.makeText(getActivity(),"我是搜索！！！",Toast.LENGTH_LONG).show();
                break;
        }

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    /**
     * ViewPager 的滑动事件导致页面的切换
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
        //这个地方写和textView的关联事件；即VP变换TextView变换；
        for(TextView textView:textViewArrayList){
            textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        }
        textViewArrayList.get(position).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        //待实现功能一：如何让小标题始终居中？
//        if(position>2){
//          textViewArrayList.get(position).setGravity(Gravity.CENTER_HORIZONTAL);
//        }
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
