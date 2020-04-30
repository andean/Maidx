package com.andean.maidx.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.andean.maidx.databinding.ActivityAboutBinding;

public class AboutActivity extends AppCompatActivity {

    private ActivityAboutBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

    }
}
