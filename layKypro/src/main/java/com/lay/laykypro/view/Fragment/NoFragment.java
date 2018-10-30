package com.lay.laykypro.view.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.lay.laykypro.R;
import com.lay.laykypro.adapter.Fragment.NoRecyclerViewAdapter;
import com.lay.laykypro.adapter.Fragment.OnItemClickListener;
import com.lay.laykypro.base.BaseFragment;
import com.lay.laykypro.base.BaseView;
import com.lay.laykypro.bean.MainNoBean;
import com.lay.laykypro.presenter.MainNoPresenter;

import java.util.List;


//数据接口  通知：http://baobab.kaiyanapp.com/api/v3/messages

public class NoFragment extends BaseFragment<BaseView,MainNoPresenter> implements NoView {

    private ImageView imgSearch;
    private RecyclerView recyclerNo;

    private String TAG="NoFrag";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_no, container, false);
        initView(view);
        basePresenter.getData();
        return view;
    }
    /**
     * 初始化控件
     */
    private void initView(View view) {
        imgSearch = (ImageView) view.findViewById(R.id.img_no_Search);
        recyclerNo = (RecyclerView) view.findViewById(R.id.recy_no);
        recyclerNo.setLayoutManager(new LinearLayoutManager(getActivity()));
        //添加recyclerView的foot



    }

    @Override
    public MainNoPresenter getBasePresenter() {
        return new MainNoPresenter();
    }


    /**
     * 将数据设置到RecyclerView部分
     * @param tData
     */
    @Override
    public void showData(MainNoBean tData) {
        final List<MainNoBean.MessageListBean> messageList = tData.messageList;
        Log.d(TAG, "showData: "+messageList.size());
        NoRecyclerViewAdapter noRecyclerViewAdapter = new NoRecyclerViewAdapter(messageList, getActivity());
        ////设置点击事件；
        noRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //eyepetizer://webview/?title=%E7%95%99%E4%B8%8B%E4%B8%80%E5%BC%A0%E7%85%A7%E7%89%87%EF%BC%8C%E6%80%BB%E7%BB%93%E4%BD%A0%E7%9A%84%202017&url=http%3A%2F%2Fwww.kaiyanapp.com%2Ftopic_article.html%3Fnid%3D30%26cookie%3D%26shareable%3Dtrue
               //本来此处应该跳到WebView页面，但是这个地方没有拿到对应的页面地址，故放弃
                Toast.makeText(getContext(),"点击了"+messageList.get(position).title,Toast.LENGTH_SHORT).show();


            }
        });
        recyclerNo.setAdapter(noRecyclerViewAdapter);


    }




}
