package com.fly.myapplicationtest;

import android.opengl.GLSurfaceView;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES20.*;

/**
 * Created by anlin on 22/01/2017.
 */
public class FistOpenGLProjectRenderer implements GLSurfaceView.Renderer{
    public static final String TAG = "fo";
    @Override
    public void onSurfaceCreated(GL10 glUnused, EGLConfig config){
        glClearColor(1.0f,0.0f,0.0f,0.0f);
    }
    @Override
    public void onSurfaceChanged(GL10 glUnused, int width, int height){
        glViewport(0,0,width,height);
        Log.i(TAG, "onSurfaceChanged: on sc");
    }
    @Override
    public void onDrawFrame(GL10 glUnused){
        glClear(GL_COLOR_BUFFER_BIT);
    }

}
