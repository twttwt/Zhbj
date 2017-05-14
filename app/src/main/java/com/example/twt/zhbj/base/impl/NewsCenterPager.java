package com.example.twt.zhbj.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by twt on 2017/5/13.
 */

public class NewsCenterPager extends BasePager {
    public NewsCenterPager(Activity mActivity) {
        super(mActivity);
    }
    public void initData(){
        System.out.println("新闻初始化");
        TextView view=new TextView(mActivity);
        view.setText("新闻");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);

        fl_content.addView(view);

        // 修改页面标题
        tv_title.setText("新闻");

        // 隐藏菜单按钮
        // btnMenu.setVisibility(View.GONE);
    }
}
