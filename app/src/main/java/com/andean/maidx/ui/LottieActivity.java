package com.andean.maidx.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.andean.maidx.databinding.ActivityLottieBinding;

public class LottieActivity extends AppCompatActivity {

    private ActivityLottieBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lottie);

        mBinding = ActivityLottieBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // 设置动画监听
        mBinding.ivSplashLottie.addAnimatorListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(LottieActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
