package com.thanksyoung.yyplayer.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.thanksyoung.yyplayer.R;
import com.thanksyoung.yyplayer.base.BasePager;
import com.thanksyoung.yyplayer.base.ReplaceFragment;
import com.thanksyoung.yyplayer.pages.AudioPager;
import com.thanksyoung.yyplayer.pages.MyPager;
import com.thanksyoung.yyplayer.pages.NetVideoPager;
import com.thanksyoung.yyplayer.pages.VideoPager;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private RadioGroup rg_bottom_tag;
    private ArrayList<BasePager> basePagers;
    private int position ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_bottom_tag = (RadioGroup) findViewById(R.id.rg_bottom_tag);
        rg_bottom_tag.check(R.id.rb_video);

        basePagers = new ArrayList<>();
        basePagers.add(new VideoPager(this));
        basePagers.add(new AudioPager(this));
        basePagers.add(new NetVideoPager(this));
        basePagers.add(new MyPager(this));

        rg_bottom_tag.setOnCheckedChangeListener(new OnCheckedChangeListener());
        rg_bottom_tag.check(0);
    }
    class OnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                default:
                    position = 0;
                    break;
                case R.id.rb_video:
                    position =1 ;
                    break;
                case R.id.rb_audio:
                    position = 2;
                    break;
                case R.id.rb_net_video:
                    position = 3;
                    break;
            }

            setFragment();

        }

    }

    /**
     * 此方法把页面添加到Fragment
     */
    private void setFragment() {
        //1.得到Fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //3.替换页面
        fragmentTransaction.replace(R.id.fl_main_content,new ReplaceFragment(getBasePager()));
        // 提交
        fragmentTransaction.commit();

    }

    private BasePager getBasePager() {
        BasePager basePager = basePagers.get(position);
        if(basePager != null&&!basePager.isInit){
            basePager.initData();
            basePager.isInit = true;

        }
        return basePager;
    }

}
