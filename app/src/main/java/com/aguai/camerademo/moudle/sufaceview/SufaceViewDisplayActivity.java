package com.aguai.camerademo.moudle.sufaceview;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceView;
import android.view.View;

import com.aguai.camerademo.R;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.ulsee.easylib.ui.BaseActivity;

import java.io.IOException;

import butterknife.Bind;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created By Aguai
 * 2018/5/10
 * https://github.com/aguai1
 */
public class SufaceViewDisplayActivity extends BaseActivity {
    @Bind(R.id.surfaceView)
    SurfaceView surfaceView;

    @Override
    public int bindLayout() {
        return R.layout.activity_sufaceview;
    }

    @Override
    public boolean translucentStatus() {
        return true;
    }

    @Override
    public void initView(View view) {
    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
