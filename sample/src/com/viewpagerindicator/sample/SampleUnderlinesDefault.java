package com.viewpagerindicator.sample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.Timer;
import java.util.TimerTask;

public class SampleUnderlinesDefault extends BaseSampleActivity {

    private UnderlinePageIndicator underlinePageIndicator;

    private TextView title_tt;

    private int width;

    private int height;

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
           if(msg.what== 12){
               width = title_tt.getLayoutParams().width;

           }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_underlines);

        mAdapter = new TestFragmentAdapter(getSupportFragmentManager());


        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        underlinePageIndicator = (UnderlinePageIndicator)findViewById(R.id.indicator);
        title_tt = (TextView)findViewById(R.id.title_tt);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(200);
            }
        };
        timer.schedule(task, 200);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(title_tt.getWidth(), underlinePageIndicator.getHeight());
        underlinePageIndicator.setLayoutParams(lp);

        underlinePageIndicator.setViewPager(mPager);
    }
}