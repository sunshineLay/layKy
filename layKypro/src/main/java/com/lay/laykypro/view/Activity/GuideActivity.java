package com.lay.laykypro.view.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lay.laykypro.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//注意：引导页基本功能已经结束；但是还是需要写一些东西，
//引导页只在第一次使用的时候进入；
//启动页或者叫广告页才是每次都必须进入的场景；
public class GuideActivity extends Activity  implements ViewPager.OnPageChangeListener {

    private static int[] imgs=new int[]{R.mipmap.kyjq, R.mipmap.kype,R.mipmap.kyy,R.mipmap.kystr};

    private ViewPager vp;
    private ArrayList<ImageView> imageViews;
    private ImageView[] dots;
    private LinearLayout lineGuide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initData();
        initDots();
        initView();


    }

    private void initDots() {
        //设置小圆点的步骤
        //1.在d下面写一个小圆点的资源文件
        //2.小圆点数量、之间的间隔、默认启动显示
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.line_guide);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20, 20);
        layoutParams.setMargins(10,0,10,10);//l t r b
        dots = new ImageView[imgs.length];
        for (int i = 0; i < imgs.length; i++) {
            ImageView dotImg = new ImageView(this);
            dotImg.setLayoutParams(layoutParams);
            dotImg.setImageResource(R.drawable.dot_selector);
            if(i==0){
                dotImg.setEnabled(true);
            }else{
                dotImg.setEnabled(false);
            }
            dots[i]=dotImg;
            linearLayout.addView(dotImg);



        }


    }

    private void initData() {
        imageViews = new ArrayList<>();
        //得到Vp这类控件的Ly 为了填充窗口
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        for (int i = 0; i < imgs.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(imgs[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);//填满整个控件
            imageViews.add(imageView);
            if(i==imgs.length-1){
                //比点击事件更快
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(GuideActivity.this, StartActivity.class);
                        startActivity(intent);
                    }
                });
            }




        }

    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp_guide);
        lineGuide = (LinearLayout) findViewById(R.id.line_guide);
        MyVpPagerApadter myVpPagerApadter = new MyVpPagerApadter(imageViews);
        vp.setAdapter(myVpPagerApadter);
        vp.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //
        for (int i = 0; i < dots.length; i++) {
            if(position==i){
                dots[i].setEnabled(true);
            }else{
                dots[i].setEnabled(false);
            }

        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    class MyVpPagerApadter extends PagerAdapter {
        private List<ImageView> imageViewList;

        public MyVpPagerApadter(List<ImageView> imageViewList) {
            this.imageViewList = imageViewList;
        }

        @Override
        public int getCount() {
            return imageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView(imageViewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
           container.addView(imageViewList.get(position));
           return imageViewList.get(position);
        }
    }


}
