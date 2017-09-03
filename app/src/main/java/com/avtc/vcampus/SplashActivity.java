package com.avtc.vcampus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * 启动页（闪屏页）
 * 通过在主题中将Preview Window背景设置为全透明的方式解决白、黑屏问题
 *
 * @author micheal-yan
 * @since v0.1.0
 */
public class SplashActivity extends AppCompatActivity {

    /**
     * 倒计时时长单位秒
     */
    private static final int COUNT_DOWN_TIMES = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        countDownToMainActivity();
    }

    /**
     * 倒数指定时长时进入MainActivity
     *
     * @since v0.1.0
     */
    private void countDownToMainActivity() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                // 跳转之前退出全屏，保证状态栏不抖动
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                startActivity(intent);
                finish();
            }
        }, 1000 * COUNT_DOWN_TIMES);
    }

    @Override
    public void onBackPressed() {
        // 不做任何处理，屏蔽返回键，防止用户在启动页退出应用
    }
}
