package com.example.learnopengl1.graphical;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by hua.pang on 2017/10/11.
 */

public class Polygon extends Mesh{
    private static final String TAG = "Polygon";
    public static final float[] mPolygonArray = {
            -1,1,0,
            1,1,0,
            1.5f,0,0,
            0,-1,0,
            -1.5f,0,0
    };

    private static final short[] mOrder = {0, 1, 2, 3,4};

    public Polygon() {
        setmIndicesBuffer(mOrder);
        setmVerticesBuffer(mPolygonArray);
        setmDrawEleMode(GL10.GL_LINE_LOOP);
    }
}
