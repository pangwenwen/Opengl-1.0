package com.example.learnopengl1.fragrement;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learnopengl1.R;
import com.example.learnopengl1.render.ColorRender_5;
import com.example.learnopengl1.render.MatrixRender_4;

/**
 * Created by hua.pang on 2017/10/10.
 */

public class Fragrement_5 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.basic_render,container,false);
        GLSurfaceView glSurfaceView = (GLSurfaceView) view.findViewById(R.id.sur);


        glSurfaceView.setRenderer(new ColorRender_5());
        return view;
    }
}
