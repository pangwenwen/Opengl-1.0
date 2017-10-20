package com.example.learnopengl1.graphical;

import com.example.learnopengl1.BufferUtil;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by hua.pang on 2017/10/11.
 */

public class Square extends Mesh{
    private static final float[] mSquareArray = {
            -1.0f,  1.0f, 0.0f,  // 0, Top Left
            -1.0f, -1.0f, 0.0f,  // 1, Bottom Left
            1.0f, -1.0f, 0.0f,  // 2, Bottom Right
            1.0f,  1.0f, 0.0f,  // 3, Top Right
    };

    private static final short[] mOrder = {
            0,1,2,3,0
    };

    public Square() {
        setmIndicesBuffer(mOrder);
        setmVerticesBuffer(mSquareArray);
        setmDrawEleMode(GL10.GL_TRIANGLE_STRIP);
    }


}
