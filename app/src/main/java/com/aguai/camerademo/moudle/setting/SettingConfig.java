package com.aguai.camerademo.moudle.setting;


import com.ulsee.easylib.utils.SharedPreferencesUtils;

/**
 * ================================================
 * 作    者：aguai（吴红斌）Github地址：https://github.com/aguai1
 * 版    本：1.0
 * 创建日期：17-11-17
 * 描    述：通用设置管理类
 * ================================================
 */
public class SettingConfig {

    private static final String SETTING_CAMERAROTATE_ADJUST = "setting_camerarotate_adjust";
    private static final String SETTING_CAMERAPREVIEW_FLIPX = "setting_camerapreview_flipx";
    private static final String SETTING_NOT_HAND_DEVICE = "setting_not_hand_device";

    public static final int DEFAULT_CAMERAROTATE_ADJUST = 0;
    public static final boolean DEFAULT_CAMERAPREVIEW_FLIPX = false;
    public static final boolean DEFAULT_NOT_HAND_DEVICE = false;

    public static int getCameraRotateAdjust() {
        return (int) SharedPreferencesUtils.get(SETTING_CAMERAROTATE_ADJUST, DEFAULT_CAMERAROTATE_ADJUST);
    }

    public static void setCameraRotateAdjust(int cameraRotateAdjust) {
        SharedPreferencesUtils.put(SETTING_CAMERAROTATE_ADJUST, normalizationRotate(cameraRotateAdjust));
    }

    public static boolean getCameraPreviewFlipX() {
        return (boolean) SharedPreferencesUtils.get(SETTING_CAMERAPREVIEW_FLIPX, DEFAULT_CAMERAPREVIEW_FLIPX);
    }

    public static void setCameraPreviewFlipX(boolean cameraPreviewFlipX) {
        SharedPreferencesUtils.put(SETTING_CAMERAPREVIEW_FLIPX, cameraPreviewFlipX);
    }

    public static void setNotHandDevice(boolean notHandDevice) {
        SharedPreferencesUtils.put(SETTING_NOT_HAND_DEVICE, notHandDevice);
    }

    public static boolean getNotHandDevice() {
        return (boolean) SharedPreferencesUtils.get(SETTING_NOT_HAND_DEVICE, DEFAULT_NOT_HAND_DEVICE);
    }

    public static int normalizationRotate(int rotate) {
        while (rotate < 0) {
            rotate += 360;
        }
        return (rotate % 360);
    }
}
