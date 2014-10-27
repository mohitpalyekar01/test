package com.example.fragmenttabhost;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


//test project
public class MainActivity extends ActionBarActivity {
	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

		View view = LayoutInflater.from(this).inflate(R.layout.test, null);
		View view1 = LayoutInflater.from(this).inflate(R.layout.test, null);
		View view2 = LayoutInflater.from(this).inflate(R.layout.test, null);
		View view3 = LayoutInflater.from(this).inflate(R.layout.test, null);

		view.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

				mTabHost.getTabWidget().getChildAt(0)
						.setBackgroundResource(R.drawable.ic_launcher);

				return false;
			}
		});

		mTabHost.setup(this, getSupportFragmentManager(),
				android.R.id.tabcontent);

		mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator(view),
				FragmentTab.class, null);

		
		mTabHost.addTab(setIndicator(MainActivity.this,mTabHost.newTabSpec("TAB_2_TAG"),
                R.drawable.tab_indicator_gen,"Video",R.drawable.ic_launcher),FragmentTab.class,null);
		
		
		mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator(view1),
				FragmentTab.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator(view2),
				FragmentTab.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator(view3),
				FragmentTab.class, null);
	}

	
	     private TabSpec setIndicator(Context ctx, TabSpec spec,
			   int resid, String string, int genresIcon) {
			      View v = LayoutInflater.from(ctx).inflate(R.layout.test, null);
			      v.setBackgroundResource(resid);
			      TextView tv = (TextView)v.findViewById(R.id.textView1);
			      ImageView img = (ImageView)v.findViewById(R.id.imageView1);
			     
			      tv.setText(string);
			      img.setBackgroundResource(genresIcon);
			      return spec.setIndicator(v);
			 }
}
