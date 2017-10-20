package com.example.learnopengl1;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.example.learnopengl1.fragrement.Fragrement_1;
import com.example.learnopengl1.fragrement.Fragrement_2;
import com.example.learnopengl1.fragrement.Fragrement_3;
import com.example.learnopengl1.fragrement.Fragrement_4;
import com.example.learnopengl1.fragrement.Fragrement_5;
import com.example.learnopengl1.fragrement.Fragrement_6;
import com.example.learnopengl1.fragrement.Fragrement_7;
import com.example.learnopengl1.fragrement.Fragrement_8;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

	List<String> mTitle = new ArrayList<String>();
	List<Fragment> mLayout = new ArrayList();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTitle.add("Basic");
		mTitle.add("Graphical");
		mTitle.add("Polgy");
		mTitle.add("Matrix");
		mTitle.add("Color");
		mTitle.add("Render");
		mTitle.add("Polyhedron20");
		mTitle.add("SolarSystem");
		mLayout.add(new Fragrement_1());
		mLayout.add(new Fragrement_2());
		mLayout.add(new Fragrement_3());
		mLayout.add(new Fragrement_4());
		mLayout.add(new Fragrement_5());
		mLayout.add(new Fragrement_6());
		mLayout.add(new Fragrement_7());
		mLayout.add(new Fragrement_8());


		ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
		viewPager.setAdapter(fragmentPagerAdapter);
		viewPager.setCurrentItem(7);
	}

	FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager() ) {
		@Override
		public Fragment getItem(int position) {
			return mLayout.get(position);
		}

		@Override
		public int getCount() {
			return mLayout.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mTitle.get(position);
		}
	};

}
