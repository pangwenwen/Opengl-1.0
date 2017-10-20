package com.example.learnopengl1.render;

import com.example.learnopengl1.graphical.Polyhedron20;
import com.example.learnopengl1.graphical.Render;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by hua.pang on 2017/10/17.
 */

public class Polyhedron20_7 extends BasicRender_1 {
    Polyhedron20 polyhedron20 = new Polyhedron20() ;
    private float angle = 0;

    @Override
    public void onDrawFrame(GL10 gl) {
        super.onDrawFrame(gl);
        gl.glLoadIdentity();
        gl.glTranslatef(0,0,-10);

        //gl.glRotatef(angle,0,1,0);
        polyhedron20.setmRotateY(angle);
        polyhedron20.draw(gl);
        angle++;
    }
}
