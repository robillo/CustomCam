package com.appbusters.robinkamboj.customcam;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Size;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AndroidCameraAPI";
    private TextureView preview;
    private ImageButton capture;

    private CameraCaptureSession cameraCaptureSession;
    private CameraDevice cameraDevice;
    private CaptureRequest.Builder captureRequestBuilder;
    private String cameraId;

    private Size imageDimension;
    private File file;
    private Boolean flashSupport;
    private Handler handler;
    private HandlerThread handlerThread;
    private ImageReader imageReader;
    private static final int REQUEST_CAMERA_PERMISSION = 200;
    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preview = (TextureView) findViewById(R.id.preview);
        assert preview != null;
        preview.setSurfaceTextureListener(textureListener);

        capture = (ImageButton) findViewById(R.id.capture);
        assert capture != null;
    }

    TextureView.SurfaceTextureListener textureListener = new TextureView.SurfaceTextureListener(){

        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {

        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

        }
    };
}
