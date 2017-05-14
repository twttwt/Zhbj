package com.example.twt.zhbj.base.impl;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.twt.zhbj.R;


/**
 * Created by twt on 2017/5/13.
 */

public class BasePager {
    public Activity mActivity;
    public View mRootView;
    public FrameLayout fl_content;
    public TextView tv_title;
    public ImageButton btn_menu;
    public BasePager(Activity mActivity) {
        this.mActivity = mActivity;
        mRootView=initView();
    }

    public View initView(){
       View view=View.inflate(mActivity, R.layout.base_pager,null);
         fl_content= (FrameLayout) view.findViewById(R.id.fl_content);
        tv_title= (TextView) view.findViewById(R.id.tv_title);
         btn_menu= (ImageButton) view.findViewById(R.id.btn_menu);
        return view;
    }
    public void initData(){

    }
}
