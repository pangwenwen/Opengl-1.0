package com.example.learnopengl1.graphical;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by hua.pang on 2017/10/13.
 */

public class Render extends Mesh{
    //屏幕坐标，UV 要与物理坐标一一对应
    private static final float[] mUVArray = {
            /*倒置*/
            0,0,
            2,0,
            0,2,
            2,2
    };

    //物理世界的坐标
    private static final float[] mVerticalArray = {
            -1,-1,0,
            1,-1,0,
            -1,1,0,
            1,1,0,

           /* -0.5f,  0.5f, 0.0f,  // 0, Top Left
            -0.5f, -0.5f, 0.0f,  // 1, Bottom Left
            0.5f, -0.5f, 0.0f,  // 2, Bottom Right
            0.5f,  0.5f, 0.0f,  // 3, Top Right*/
            /*-0.5f, -0.5f, 0.0f, 0.5f, -0.5f, 0.0f,
            -0.5f, 0.5f, 0.0f, 0.5f, 0.5f, 0.0f*/
    };

    private static final short[] mIndex = {
        0,1,2,3,1
            //0, 1, 2,  1,3,2
    };

    public Render() {
        setmVerticesBuffer(mVerticalArray);
        setmIndicesBuffer(mIndex);
        setmUVBuffer(mUVArray);
        setmDrawEleMode(GL10.GL_TRIANGLE_STRIP);
    }
}
