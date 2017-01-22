package com.fly.myapplicationtest;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import com.fly.myapplicationtest.util.TextResourceReader;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import static android.opengl.GLES20.*;

/**
 * Created by anlin on 22/01/2017.
 */
public class AirHockeyRenderer implements GLSurfaceView.Renderer {
    public static final String TAG = "AirHockeyRenderer";

    private static final int BYTES_PER_FLOAT = 4;
    private final FloatBuffer vertexData;

    private final Context context;

    public AirHockeyRenderer(Context context){
        this.context = context;

        float[] tableVertices = {
                0f,0f,
                0f,14f,
                9f,14f,
                9f,0f
        };

        float tableVerticesWithTriangles[]= {
                //tr1
                0f,0f,
                9f,14f,
                0f,14f,

                //triangle2
                0f,0f,
                9f,0f,
                9f,14f,

                //line 1
                0f,7f,
                9f,7f,

                //line2
                4.5f,2f,
                4.5f,12f,

        };

        vertexData = ByteBuffer
                .allocate(tableVerticesWithTriangles.length * BYTES_PER_FLOAT)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vertexData.put(tableVerticesWithTriangles);

    }



    @Override
    public void onSurfaceCreated(GL10 glUnused, EGLConfig config) {
        glClearColor(1.0f, 0.0f, 0.0f, 0.0f);

        String vertexShadowSource = TextResourceReader
                .readTextFileFromResource(context, R.raw.simple_fragment_shader);

        String fragmentShaderSource = TextResourceReader
                .readTextFileFromResource(context, R.raw.simple_fragment_shader);

    }


    @Override
    public void onSurfaceChanged(GL10 glUnused, int width, int height) {
        glViewport(0, 0, width, height);
        Log.i(TAG, "onSurfaceChanged: on sc");
    }

    @Override
    public void onDrawFrame(GL10 glUnused) {
        glClear(GL_COLOR_BUFFER_BIT);
    }

}
