package com.aguai.camerademo.moudle.sufaceview;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.ulsee.easylib.utils.L;
import com.ulsee.easylib.utils.ToastUtils;

import java.io.IOException;

/**
 * Created By Aguai
 * 2018/5/10
 * https://github.com/aguai1
 */
public class CameraSufaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder;
    private Camera mCamera;

    public CameraSufaceView(Context context) {
        super(context);
        init();
    }


    public CameraSufaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }
    public CameraSufaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }
    private void init() {
        holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        L.i("surfaceCreated...");
        if (mCamera == null) {
            mCamera = Camera.open();//开启相机
            try {
                mCamera.setDisplayOrientation(90);
                mCamera.setPreviewDisplay(holder);//相机预览的内容放在 holder
            } catch (IOException e) {
                ToastUtils.showShort(" 设置预览失败");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        L.i( "surfaceChanged...");
        try {
            mCamera.stopPreview();
        }catch (Exception e){
            e.printStackTrace();
        }
        mCamera.startPreview();//该方法只有相机开启后才能调用
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        L.i( "surfaceDestroyed...");
        if (mCamera != null) {
            mCamera.lock();
            mCamera.stopPreview();
            mCamera.release();//释放相机资源
            mCamera = null;
        }
    }
}
