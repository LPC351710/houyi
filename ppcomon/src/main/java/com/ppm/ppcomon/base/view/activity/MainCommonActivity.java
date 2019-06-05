package com.ppm.ppcomon.base.view.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ppm.ppcomon.R;

public class MainCommonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_common);


    }

    public void onClick(View view) {
        ARouter.getInstance().build("/test/activity").navigation();
    }
}
