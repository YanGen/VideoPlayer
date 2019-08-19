package com.thanksyoung.yyplayer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.thanksyoung.yyplayer.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 两秒钟后执行此方法
                // 执行在主线程中
                startMainActivity();
            }
        },1000);
    }

    private void startMainActivity() {
        // 开启主页面
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        // 关闭当前页面
        finish();
    }


}
