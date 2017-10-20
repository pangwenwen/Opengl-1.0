package com.example.learnopengl1.fragrement;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learnopengl1.R;
import com.example.learnopengl1.render.Polyhedron20_7;
import com.example.learnopengl1.render.SolorSystemRender_8;

/**
 * Created by hua.pang on 2017/10/10.
 */

public class Fragrement_8 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.basic_render,container,false);
        GLSurfaceView glSurfaceView = (GLSurfaceView) view.findViewById(R.id.sur);

        glSurfaceView.setRenderer(new SolorSystemRender_8());
        return view;
    }
}
