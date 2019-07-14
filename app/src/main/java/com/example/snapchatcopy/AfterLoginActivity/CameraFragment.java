package com.example.snapchatcopy.AfterLoginActivity;



import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.snapchatcopy.R;
import java.io.IOException;


public class CameraFragment extends Fragment implements SurfaceHolder.Callback{
     SurfaceView sv;
     SurfaceHolder mHolder;
     Camera mCamera;

    final int  CAMERA_REQUEST_CODE = 1;




    public static CameraFragment newInstance(){
        CameraFragment cameraFragment = new CameraFragment();
        return cameraFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.camera_fragment, container, false);
        sv = view.findViewById(R.id.surfaceView);
        mHolder = sv.getHolder();



        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
        }else{
            mHolder.addCallback(this);
            mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }

        return view;
    }



    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
            mCamera = Camera.open();

            Camera.Parameters parameters;
            parameters = mCamera.getParameters();

            mCamera.setDisplayOrientation(90);
            parameters.setPreviewFrameRate(30);
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);

        try {
            mCamera.setPreviewDisplay(mHolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mCamera.startPreview();

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case CAMERA_REQUEST_CODE: {
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    mHolder.addCallback(this);
                    mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
                }else{
                    Toast.makeText(getContext(), "XD ZAPIERDOLE SIE", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}