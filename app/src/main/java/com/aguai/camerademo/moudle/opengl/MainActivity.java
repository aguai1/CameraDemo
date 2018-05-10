package com.aguai.camerademo.moudle.opengl;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aguai.camerademo.R;
import com.ulsee.easylib.ui.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public boolean translucentStatus() {
        return false;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
