package com.example.zakro.footballscores.EventListeners;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zakro on 12/17/17.
 */

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private RecyclerItemClickListener itemClickListener;
    private GestureDetector gestureDetector;

    public RecyclerTouchListener(Context context,final RecyclerView recyclerView,final RecyclerItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
        gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child=rv.findChildViewUnder(e.getX(),e.getY());
        if(child!=null && itemClickListener!=null && gestureDetector.onTouchEvent(e)){
            itemClickListener.onClick(child,rv.getChildAdapterPosition(child));
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
