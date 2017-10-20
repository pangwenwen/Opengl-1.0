package com.example.learnopengl1.fragrement;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learnopengl1.R;
import com.example.learnopengl1.graphical.Mesh;
import com.example.learnopengl1.graphical.Render;
import com.example.learnopengl1.render.ColorRender_5;
import com.example.learnopengl1.render.RenderRender_6;

/**
 * Created by hua.pang on 2017/10/10.
 */

public class Fragrement_6 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.basic_render,container,false);
        GLSurfaceView glSurfaceView = (GLSurfaceView) view.findViewById(R.id.sur);

        RenderRender_6 render = new RenderRender_6();
        Render renderL = new Render();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
        renderL.setmBitmap(bitmap);
        render.setRender(renderL);
        glSurfaceView.setRenderer(render);
        return view;
    }
}
