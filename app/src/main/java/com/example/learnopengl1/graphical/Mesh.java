package com.example.learnopengl1.graphical;

import android.graphics.Bitmap;
import android.opengl.GLUtils;
import android.util.Log;

import com.example.learnopengl1.BufferUtil;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by hua.pang on 2017/10/13.
 */

public class Mesh {
    private static final String TAG = "Mesh";

    //顶点
    private FloatBuffer mVerticesBuffer;
    //规则
    private ShortBuffer mIndicesBuffer;
    private int mIndicesLength;
    //颜色
    private FloatBuffer mColorBuffer;

    //UV坐标
    private FloatBuffer mUVBuffer;

    //颜色rgb
    private float[] mColor = {1.0f,1.0f,1.0f,1.0f};

    //translate 值的设置
    private float mTranX;
    private float mTranY;
    private float mTranZ;

    //rotate 值的设置
    private float mRotateX;
    private float mRotateY;
    private float mRotateZ;

    //绘制图形的mode
    private int mDrawEleMode = GL10.GL_TEXTURE;

    //要渲染的图像
    private Bitmap mBitmap;
    private boolean mRenderBmp = false;//是否要图像渲染

    //文理ID
    private int mTextureId;

    //画图
    public void draw(GL10 gl){
        gl.glFrontFace(GL10.GL_CCW);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glFrontFace(GL10.GL_BACK);
        gl.glColor4f(mColor[0],mColor[1],mColor[2],mColor[3]);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3,GL10.GL_FLOAT,0,mVerticesBuffer);
        if (mColorBuffer!= null){
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
            gl.glColorPointer(4,GL10.GL_FLOAT,0,mColorBuffer);
        }

        //材质渲染 --start
        Log.d(TAG, "draw: mRenderBmp = "+mRenderBmp);
        if (mRenderBmp){
            loadTexture(gl);
            mRenderBmp = false;
        }

        Log.d(TAG, "draw: mTextureId = "+mTextureId+"; mUVBuffer = "+mUVBuffer);
        if (mTextureId != -1 && mUVBuffer != null){
            gl.glEnable(GL10.GL_TEXTURE_2D);
            gl.glTexCoordPointer(2,GL10.GL_FLOAT,0,mUVBuffer);
            gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        }
        //材质渲染 --end

        gl.glTranslatef(mTranX,mTranY,mTranZ);
        gl.glRotatef(mRotateX,1,0,0);
        gl.glRotatef(mRotateY,0,1,0);
        gl.glRotatef(mRotateZ,0,0,1);

        gl.glDrawElements(mDrawEleMode,mIndicesLength,GL10.GL_UNSIGNED_SHORT,mIndicesBuffer);

        if (mColorBuffer!= null){
            gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        }
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
    }

    //加载文理
    private void loadTexture(GL10 gl){
        int[] texture = new int[1];
        gl.glGenTextures(1,texture,0);
        mTextureId = texture[0];

        //加载texture
        gl.glBindTexture(GL10.GL_TEXTURE_2D,mTextureId);

        gl.glTexParameterf(GL10.GL_TEXTURE_2D,GL10.GL_TEXTURE_MIN_FILTER,GL10.GL_LINEAR);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D,GL10.GL_TEXTURE_MAG_FILTER,GL10.GL_LINEAR);

        gl.glTexParameterf(GL10.GL_TEXTURE_2D,GL10.GL_TEXTURE_WRAP_S,GL10.GL_REPEAT);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D,GL10.GL_TEXTURE_WRAP_T,GL10.GL_REPEAT);

        GLUtils.texImage2D(GL10.GL_TEXTURE_2D,0,mBitmap,0);
    }

    public FloatBuffer getmVerticesBuffer() {
        return mVerticesBuffer;
    }

    public void setmVerticesBuffer(float[] verticesArray) {
        mVerticesBuffer = BufferUtil.floatToBuffer(verticesArray);
    }

    public ShortBuffer getmIndicesBuffer() {
        return mIndicesBuffer;
    }

    public void setmIndicesBuffer(short[] indicesArray) {
        mIndicesBuffer = BufferUtil.shortToBuffer(indicesArray);
        mIndicesLength = indicesArray.length;
    }

    public FloatBuffer getmColorBuffer() {
        return mColorBuffer;
    }

    public void setmColorBuffer(float[] colorArray) {
        mColorBuffer = BufferUtil.floatToBuffer(colorArray);
    }


    public float[] getmColor() {
        return mColor;
    }

    public void setmColor(float[] mColor) {
        this.mColor = mColor;
    }

    public float getmTranX() {
        return mTranX;
    }

    public void setmTranX(float mTranX) {
        this.mTranX = mTranX;
    }

    public float getmTranY() {
        return mTranY;
    }

    public void setmTranY(float mTranY) {
        this.mTranY = mTranY;
    }

    public float getmTranZ() {
        return mTranZ;
    }

    public void setmTranZ(float mTranZ) {
        this.mTranZ = mTranZ;
    }

    public float getmRotateX() {
        return mRotateX;
    }

    public void setmRotateX(float mRotateX) {
        this.mRotateX = mRotateX;
    }

    public float getmRotateY() {
        return mRotateY;
    }

    public void setmRotateY(float mRotateY) {
        this.mRotateY = mRotateY;
    }

    public float getmRotateZ() {
        return mRotateZ;
    }

    public void setmRotateZ(float mRotateZ) {
        this.mRotateZ = mRotateZ;
    }

    public int getmDrawEleMode() {
        return mDrawEleMode;
    }

    public void setmDrawEleMode(int mDrawEleMode) {
        this.mDrawEleMode = mDrawEleMode;
    }

    public FloatBuffer getmUVBuffer() {
        return mUVBuffer;
    }

    public void setmUVBuffer(float[] UVArray) {
        mUVBuffer = BufferUtil.floatToBuffer(UVArray);
    }

    public void setmBitmap(Bitmap bitmap){
        mBitmap = bitmap;
        mRenderBmp = true;
    }
}
