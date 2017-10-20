package com.example.learnopengl1.render;

import android.opengl.GLU;

import com.example.learnopengl1.graphical.Render;
import com.example.learnopengl1.graphical.Star;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by hua.pang on 2017/10/17.
 */

public class SolorSystemRender_8 extends BasicRender_1 {

    Star sun = new Star();
    Star earth = new Star();
    Star moon = new Star();

    float angle = 0;

    @Override
    public void onDrawFrame(GL10 gl) {
        super.onDrawFrame(gl);
        gl.glLoadIdentity();
        GLU.gluLookAt(gl,0.0f, 0.0f, 15.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        gl.glPushMatrix();
        gl.glRotatef(angle,0,0,1);
        gl.glColor4f(1f,0,0,1);
        sun.draw(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glRotatef(angle,0,0,1);
        gl.glScalef(.5f,.5f,.5f);
        gl.glTranslatef(4,0,0);
        gl.glColor4f(0,1,0,1);
        earth.draw(gl);

        gl.glPushMatrix();
        gl.glRotatef(angle,0,0,1);
        gl.glTranslatef(2,0,0);
        gl.glScalef(.5f,.5f,.5f);
        gl.glRotatef(angle*5,0,0,1);
        gl.glColor4f(1,1,0,1);
        moon.draw(gl);
        gl.glPopMatrix();
        gl.glPopMatrix();

        angle++;

    }
}
