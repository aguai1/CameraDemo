package com.aguai.camerademo.moudle.setting;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import com.aguai.camerademo.R;
import com.ulsee.easylib.ui.BaseActivity;
import com.ulsee.easylib.utils.ScreenUtils;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by whb on 17-11-8.
 */

public class SettingActivity extends BaseActivity {

    @Bind(R.id.edit_camerarotate)
    EditText etCameraRotate;
    @Bind(R.id.sw_flipx)
    Switch swFlipX;
    @Bind(R.id.sw_not_hand_device)
    Switch swNotHandDevice;
    @Bind(R.id.tv_resolution)
    TextView tvResolution;

    @Override
    public int bindLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public boolean translucentStatus() {
        return false;
    }

    @Override
    public void initView(View view) {
        updateView();

        int screenWidth = ScreenUtils.getScreenWidth(this);
        int screenHeight = ScreenUtils.getScreenHeight2(this);
        tvResolution.setText(String.format("%dx%d", screenWidth, screenHeight));
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    protected void onDestroy() {
        save();
        super.onDestroy();
    }

    @OnClick(R.id.tv_reset)
    public void reset() {
        SettingConfig.setCameraRotateAdjust(SettingConfig.DEFAULT_CAMERAROTATE_ADJUST);
        SettingConfig.setCameraPreviewFlipX(SettingConfig.DEFAULT_CAMERAPREVIEW_FLIPX);
        SettingConfig.setNotHandDevice(SettingConfig.DEFAULT_NOT_HAND_DEVICE);
        updateView();
    }

    private void updateView() {
        int cameraRotateAdjust = SettingConfig.getCameraRotateAdjust();
        boolean cameraPreviewFlipX = SettingConfig.getCameraPreviewFlipX();
        boolean notHandDevice = SettingConfig.getNotHandDevice();

        etCameraRotate.setText((cameraRotateAdjust != SettingConfig.DEFAULT_CAMERAROTATE_ADJUST)
                ? String.valueOf(cameraRotateAdjust) : "");
        swFlipX.setChecked(cameraPreviewFlipX);
        swNotHandDevice.setChecked(notHandDevice);
    }

    private void save() {
        int cameraRotateAdjust = SettingConfig.DEFAULT_CAMERAROTATE_ADJUST;
        String strCameraRotate = etCameraRotate.getText().toString();

        try {
            cameraRotateAdjust = Integer.valueOf(strCameraRotate);
        } catch (Exception e){}
        SettingConfig.setCameraRotateAdjust(cameraRotateAdjust);
        SettingConfig.setCameraPreviewFlipX(swFlipX.isChecked());
        SettingConfig.setNotHandDevice(swNotHandDevice.isChecked());
        updateView();
    }
}
