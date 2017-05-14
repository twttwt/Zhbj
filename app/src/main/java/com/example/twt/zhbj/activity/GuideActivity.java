package com.example.twt.zhbj.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.twt.zhbj.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {
    private static final String TAG = "GuideActivity";
    private ViewPager vp_guide;
    private List<ImageView> imageViewList;
    private ImageView iv_point;
    private LinearLayout ll_container;
    private int mPointDis;
    private Button btn_start;
    private int[] imgId={R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);

         vp_guide= (ViewPager) findViewById(R.id.vp_guide);
        iv_point= (ImageView) findViewById(R.id.iv_red_point);
        ll_container= (LinearLayout) findViewById(R.id.ll_container);
        btn_start= (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        initData();
        
        
        vp_guide.setAdapter(new MyAdapter());
        vp_guide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d(TAG, "当前位置"+position+"移动百分比"+positionOffset);

                if (position==imageViewList.size()-1){
                    btn_start.setVisibility(View.VISIBLE);
                }
                //移动距离
                int dis= (int) ((mPointDis*positionOffset)+position*mPointDis);
                RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) iv_point.getLayoutParams();
                params.leftMargin=dis;
                iv_point.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //两点间距
       //  pointDis=ll_container.getChildAt(1).getLeft()-ll_container.getChildAt(0).getLeft();
       // Log.d(TAG, "pointDis "+pointDis);
        iv_point.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
                        // 移除监听,避免重复回调
                        iv_point.getViewTreeObserver()
                                .removeGlobalOnLayoutListener(this);
                        // ivRedPoint.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        // layout方法执行结束的回调
                        mPointDis = ll_container.getChildAt(1).getLeft()
                                - ll_container.getChildAt(0).getLeft();
                        System.out.println("圆点距离:" + mPointDis);
                    }
                });

    }

    private void initData() {
        imageViewList=new ArrayList<ImageView>();
        for (int i=0;i<imgId.length;i++){
            ImageView iv=new ImageView(this);
            iv.setBackgroundResource(imgId[i]);
            imageViewList.add(iv);

            ImageView point=new ImageView(this);
            point.setImageResource(R.drawable.shape_point_gray);

            // 初始化布局参数, 宽高包裹内容,父控件是谁,就是谁声明的布局参数
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            if (i > 0) {
                // 从第二个点开始设置左边距
                params.leftMargin = 10;
            }

            point.setLayoutParams(params);// 设置布局参数

            ll_container.addView(point);// 给容器添加圆点
        }
    }

    class MyAdapter extends PagerAdapter{

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
