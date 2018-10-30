package com.lay.laykypro.view.MainFragmentClid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.lay.laykypro.R;
import com.lay.laykypro.adapter.ClidFragment.MainClidItemDecoration;
import com.lay.laykypro.adapter.ClidFragment.WorksRecyclerAdapter;
import com.lay.laykypro.base.BaseFragment;
import com.lay.laykypro.base.BaseView;
import com.lay.laykypro.bean.FocusClidWorksBean;
import com.lay.laykypro.bean.play.FocusworksItemPlayDataBean;
import com.lay.laykypro.presenter.FocusClidWorksPresenter;

public class FocusClidWorksFragment extends BaseFragment<BaseView,FocusClidWorksPresenter> implements FocusWorks {

    private static final String TAG="FocusClidWorksFragment";
    private RecyclerView recyclerFocus;

    private WorksRecyclerAdapter worksRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view= inflater.inflate(R.layout.fragment_clid_focusworks, container, false);
            initView(view);
            return view;
    }

    private void initView(View rootView) {
        recyclerFocus = (RecyclerView) rootView.findViewById(R.id.recy_clid_focusworks);
        //设置他是ListView还是GridView。。。
        recyclerFocus.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置点击事件
        //设置上滑下拉
    }

    @Override
    public FocusClidWorksPresenter getBasePresenter() {
        return new FocusClidWorksPresenter();
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if(isVisible){

        }else{

        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        //首次进入，数据加载
        basePresenter.getPlayData();
    }

    @Override
    public void showPlayData(FocusClidWorksBean<FocusworksItemPlayDataBean> tData) {
        if(tData!=null){
            Log.d(TAG, "showPlayData: "+tData.itemList.get(0).data.content.data.category);
            Toast.makeText(getActivity(),""+tData.itemList.get(0).data.content.data.category,Toast.LENGTH_LONG).show();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            recyclerFocus.setLayoutManager(linearLayoutManager);
            worksRecyclerAdapter = new WorksRecyclerAdapter(tData.itemList, getActivity());
            recyclerFocus.setAdapter(worksRecyclerAdapter);
            recyclerFocus.addItemDecoration(new MainClidItemDecoration(getActivity(),R.drawable.itemdecoration));

        }

    }

}
