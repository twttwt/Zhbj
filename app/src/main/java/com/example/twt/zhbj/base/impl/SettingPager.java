package com.example.twt.zhbj.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by twt on 2017/5/13.
 */

public class SettingPager extends BasePager {
    public SettingPager(Activity mActivity) {
        super(mActivity);
    }
    public void initData(){
        System.out.println("设置初始化");
        TextView view=new TextView(mActivity);
        view.setText("设置");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);

        fl_content.addView(view);

        // 修改页面标题
        tv_title.setText("设置");

        // 隐藏菜单按钮
        // btnMenu.setVisibility(View.GONE);
    }
}
