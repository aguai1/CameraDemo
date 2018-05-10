package com.aguai.camerademo;

import android.app.Application;

import com.ulsee.easylib.EasyLibUtils;

/**
 * Created By Aguai
 * 2018/5/10
 * https://github.com/aguai1
 */
public class APP extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        EasyLibUtils.init(this);
    }
}
