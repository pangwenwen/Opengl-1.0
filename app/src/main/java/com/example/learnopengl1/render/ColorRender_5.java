package com.example.learnopengl1.render;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import com.example.learnopengl1.BufferUtil;
import com.example.learnopengl1.graphical.Square;

import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by hua.pang on 2017/10/11.
 */

public class ColorRender_5 implements GLSurfaceView.Renderer {
    private Square mSquare;
    private static final float[] mColorArray = {
            1,0,0,0,
            0,1,0,0,
            0,0,1,0,
            1,1,1,0
    };

    private FloatBuffer mColorBuffer;


    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        mSquare = new Square();
        mColorBuffer = BufferUtil.floatToBuffer(mColorArray);
        // Set the background color to black ( rgba ).
        gl.glClearColor(0.4f, 0.0f, 0.0f, 0.1f);  // OpenGL docs.
        // Enable Smooth Shading, default not really needed.
        gl.glShadeModel(GL10.GL_SMOOTH);// OpenGL docs.
        // Depth buffer setup.
        gl.glClearDepthf(1.0f);// OpenGL docs.
        // Enables depth testing.
        gl.glEnable(GL10.GL_DEPTH_TEST);// OpenGL docs.
        // The type of depth testing to do.
        gl.glDepthFunc(GL10.GL_LEQUAL);// OpenGL docs.
        // Really nice perspective calculations.
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, // OpenGL docs.
                GL10.GL_NICEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // Sets the current view port to the new size.
        gl.glViewport(0, 0, width, height);// OpenGL docs.
        // Select the projection matrix
        gl.glMatrixMode(GL10.GL_PROJECTION);// OpenGL docs.
        // Reset the projection matrix
        gl.glLoadIdentity();// OpenGL docs.
        // Calculate the aspect ratio of the window
        GLU.gluPerspective(gl, 45.0f,
                (float) width / (float) height,
                0.1f, 100.0f);
        // Select the modelview matrix
        gl.glMatrixMode(GL10.GL_MODELVIEW);// OpenGL docs.
        // Reset the modelview matrix
        gl.glLoadIdentity();// OpenGL docs.

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0,0,-10);

        gl.glColor4f(1,1,1,0.5f);
        mSquare.draw(gl);

        gl.glPushMatrix();
        gl.glTranslatef(0,3,0);
        gl.glColor4f(0,1,0,0.5f);
        mSquare.draw(gl);
        gl.glPopMatrix();


        gl.glPushMatrix();
        gl.glTranslatef(0,-3,0);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glColorPointer(4,GL10.GL_FLOAT,0,mColorBuffer);
        mSquare.draw(gl);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        gl.glPopMatrix();
    }
}
