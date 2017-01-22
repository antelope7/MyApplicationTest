package com.fly.myapplicationtest;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView glSurfaceView;
    private boolean rendererSet = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        glSurfaceView = new GLSurfaceView(this);

        final ActivityManager activityManager =
                (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();

        final boolean supportEs2 = configurationInfo.reqGlEsVersion >= 0x20000;

        //if(supportEs2){
            //glSurfaceView.setEGLContextClientVersion(2);

            //glSurfaceView.setRenderer(new FistOpenGLProjectRenderer());
        glSurfaceView.setRenderer(new AirHockeyRenderer(this));
            rendererSet = true;
//        } else{
//            Toast.makeText(this,"This device not support",Toast.LENGTH_LONG).show();
//        }

        setContentView(glSurfaceView);

    }
    @Override
    protected void onResume(){
        super.onResume();
        if(rendererSet){
            glSurfaceView.onResume();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        if(rendererSet){
            glSurfaceView.onPause();
        }
    }
}
