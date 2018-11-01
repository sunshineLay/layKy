package com.lay.laykypro.view.Activity;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lay.laykypro.R;
import com.lay.laykypro.view.AppManager;
import com.lay.laykypro.view.Fragment.FocusFragment;
import com.lay.laykypro.view.Fragment.MainFragment;
import com.lay.laykypro.view.Fragment.MyFragment;
import com.lay.laykypro.view.Fragment.NoFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG=MainActivity.class.getSimpleName();

    private TextView focusic;
    private TextView noic;
    private TextView myic;
    private TextView mainic;

    private FocusFragment focusFragment;
    private MainFragment mainFragment;
    private MyFragment myFragment;
    private NoFragment noFragment;

    private static  boolean isExit=false;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    isExit=false;
                    break;
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.e(TAG, "onCreate: "+getClass().getSimpleName() );
        AppManager.getInstance().addActivity(this);

        initView();

    }


    /**
     * 控件初始化以及点击事件的设置
     */
    private void initView() {
        mainic = (TextView) findViewById(R.id.tv_iconMain_main);
        focusic = (TextView) findViewById(R.id.tv_iconFocus_main);
        noic = (TextView) findViewById(R.id.tv_iconNo_main);
        myic = (TextView) findViewById(R.id.tv_iconMy_main);
        mainic.setOnClickListener(this);
        focusic.setOnClickListener(this);
        noic.setOnClickListener(this);
        myic.setOnClickListener(this);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        mainic.setSelected(true);
        if(mainFragment==null){
            mainFragment = new MainFragment();
            fragmentTransaction.add(R.id.frame_mian_main,mainFragment);
        }else{
            fragmentTransaction.show(mainFragment);
        }
        fragmentTransaction.commit();

    }

    /**
     * 底部导航的初始选择状态
     */
    private void setSelected(){
        mainic.setSelected(false);
        focusic.setSelected(false);
        noic.setSelected(false);
        myic.setSelected(false);

    }


    /**
     * 碎片的隐藏切换
     * @param fragmentTransaction
     */
   private void hideAllFragment(FragmentTransaction fragmentTransaction){
    if(mainFragment!=null){
        fragmentTransaction.hide(mainFragment);
    }
    if(focusFragment!=null){
        fragmentTransaction.hide(focusFragment);
    }
    if(noFragment!=null){
        fragmentTransaction.hide(noFragment);
    }
    if(myFragment!=null){
        fragmentTransaction.hide(myFragment);
    }





   }


    /**
     * 底部点击事件的具体切换；
     * @param v
     */
    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (v.getId()){
            case R.id.tv_iconMain_main:
                setSelected();
                mainic.setSelected(true);
                if(mainFragment==null){
                    mainFragment = new MainFragment();
                    fragmentTransaction.add(R.id.frame_mian_main,mainFragment);
                }else{
                    fragmentTransaction.show(mainFragment);
                }


                break;
            case R.id.tv_iconFocus_main:
                setSelected();
                focusic.setSelected(true);
                if(focusFragment==null){
                    focusFragment = new FocusFragment();
                    fragmentTransaction.add(R.id.frame_mian_main,focusFragment);
                }else{
                    fragmentTransaction.show(focusFragment);
                }


                break;
            case R.id.tv_iconMy_main:
                setSelected();
                myic.setSelected(true);
                if(myFragment==null){
                    myFragment = new MyFragment();
                    fragmentTransaction.add(R.id.frame_mian_main,myFragment);

                }else{
                    fragmentTransaction.show(myFragment);
                }

                break;
            case R.id.tv_iconNo_main:
                setSelected();
                noic.setSelected(true);
                if(noFragment==null){
                    noFragment = new NoFragment();
                    fragmentTransaction.add(R.id.frame_mian_main,noFragment);
                }else{
                    fragmentTransaction.show(noFragment);
                }

                break;
        }
        fragmentTransaction.commit();

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
            if(keyCode==KeyEvent.KEYCODE_BACK){
                if(!isExit){
                    Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();

                    isExit=true;
                    handler.sendEmptyMessageDelayed(0,2000);
                }else{
                    finish();
                }
                return false;
            }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void finish() {
        super.finish();
        AppManager.getInstance().AppExit(this);
    }
}
