package com.aguai.camerademo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aguai.camerademo.moudle.opengl.MainActivity;
import com.aguai.camerademo.moudle.setting.SettingActivity;
import com.aguai.camerademo.moudle.sufaceview.SufaceViewDisplayActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.ulsee.easylib.utils.ToastUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

/**
 * Created by whb on 17-8-30.
 */

public class HelloActivity extends Activity {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    List<String> titles = new ArrayList<>();
    List<Class> activities = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        ButterKnife.bind(this);

        activities.add(SufaceViewDisplayActivity.class);
        activities.add(MainActivity.class);
        titles.add("sufaceView绘制相机数据");
        titles.add("opengl绘制");
        Adpter adpter = new Adpter(activities, titles);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(adpter);

    }

    @OnClick(R.id.setting)
    public void onCLickSetting() {
        startActivity(new Intent(HelloActivity.this, SettingActivity.class));
    }

    class Adpter extends RecyclerView.Adapter<Adpter.ViewHodler> {

        private final List<Class> activitys;
        private final List<String> titles;

        public Adpter(List<Class> activities, List<String> titles) {
            this.activitys = activities;
            this.titles = titles;
        }

        @Override
        public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_function,
                    parent, false);
            return new ViewHodler(view);
        }

        @Override
        public void onBindViewHolder(ViewHodler holder, int position) {

            holder.itemName.setText(titles.get(position));
        }

        @Override
        public int getItemCount() {
            return activitys.size();
        }

        class ViewHodler extends RecyclerView.ViewHolder {
            TextView itemName;

            public ViewHodler(View itemView) {
                super(itemView);
                itemName = itemView.findViewById(R.id.item_name);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("CheckResult")
                    @Override
                    public void onClick(View view) {
                        new RxPermissions(HelloActivity.this).request(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                                .subscribe(new Consumer<Boolean>() {
                                    @Override
                                    public void accept(Boolean aBoolean) {
                                        if (aBoolean) {
                                            startActivity(new Intent(HelloActivity.this, activities.get(getAdapterPosition())));
                                        }else {
                                            ToastUtils.showShort("请打开相机权限");
                                        }
                                    }
                                });

                    }
                });
            }
        }
    }

}
