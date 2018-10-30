package com.lay.laykypro.adapter.ClidFragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lay.laykypro.R;

/**
 * 解决掉bug的GridView形式的分割线
 * 思路：写出两个方法分别判断是否是最后一排和最后一列即可
 */
public class MainClidItemGridDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDrawable;

    public MainClidItemGridDecoration(Context mContext,int drawableResId) {
        this.mDrawable = ContextCompat.getDrawable(mContext, drawableResId);
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(canvas, parent, state);
        //两个方向的绘制
        drawVertical(canvas,parent);
        drawHorizontal(canvas,parent);
    }

    /**
     * 得到列数
     * @param parent
     * @return
     */
    private int getSpanCount(RecyclerView parent){
        int spanCount =-1;
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager){
          spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
        }
        return spanCount;
    }

    /**
     * 判断当前item是不是最后一列
     * @param itemPosition
     * @param parent
     * @return
     */
    private boolean isLastColum(int itemPosition,RecyclerView parent){
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager){
            int spanCount = getSpanCount(parent);
            if(itemPosition+1%spanCount==0){
                return true;
            }
        }

        return false;
    }

    /**
     * 判断当前item是不是最后一行
     * @param itemPosition
     * @param parent
     * @return
     */
    private boolean isLastRow(int itemPosition,RecyclerView parent){
        int spanCount = getSpanCount(parent);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager){
            int childCount = parent.getAdapter().getItemCount();//parent.getChildCount();这个不能用在这里，因为parent中的子个数在 getItemOffsets中是不断在变化的。依次加一。
            //思路一：
//            double currentRow = Math.ceil((double) (itemPosition + 1 )/ (double) spanCount);//当前行数
//            double rowCount = Math.ceil((double) childCount / (double) spanCount);//总行数
//            if(currentRow<rowCount){
//                return false;
//            }
            //思路二：
            childCount=childCount-childCount%spanCount;
            if((itemPosition+1)>=childCount){
                return true;
            }

        }

        return false;
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();

        Rect rect = new Rect();

        for (int i = 0; i <childCount ; i++) {
            View view = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();//使用这个是考虑到设置item中的背景间距的情况，在没有使用的时候这个部分可以删除。
            rect.left=view.getLeft()-layoutParams.leftMargin;
            rect.right=view.getRight()+layoutParams.rightMargin;
            rect.top=view.getBottom();
            rect.bottom=rect.top+mDrawable.getIntrinsicHeight();

            mDrawable.setBounds(rect);
            mDrawable.draw(c);


        }

    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();

        Rect rect = new Rect();

        for (int i = 0; i <childCount ; i++) {
            View view = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();//使用这个是考虑到设置item中的背景间距的情况，在没有使用的时候这个部分可以删除。
            rect.left=view.getRight()+layoutParams.rightMargin;
            rect.right=rect.left+mDrawable.getIntrinsicWidth();
            rect.top=view.getTop()-layoutParams.topMargin-layoutParams.bottomMargin;
            rect.bottom=view.getBottom()+mDrawable.getIntrinsicHeight();//高是线的厚度；

            mDrawable.setBounds(rect);
            mDrawable.draw(c);


        }

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if(isLastColum(parent.getChildLayoutPosition(view),parent)){
            outRect.set(0,0,mDrawable.getIntrinsicWidth(),0);
        }
        if(isLastRow(parent.getChildLayoutPosition(view),parent)){
            outRect.set(0,0,0,mDrawable.getIntrinsicHeight());
        }

    }
}
