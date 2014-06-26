package com.vanhuan.appnews;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.vanhuan.appnews.adapters.TabsPagerAdapter;
import com.vanhuan.appnews.utils.Variables;

@SuppressLint("NewApi")
public class CateActivity extends Activity implements TabListener {

	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	private String[] tabs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cate);

		Intent i = getIntent();
		int pos = i.getIntExtra(Variables.PAPER, 0);
		// Toast.makeText(getApplicationContext(), String.valueOf(pos),
		// Toast.LENGTH_SHORT).show();

		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();

		Log.d("actionBar", "getActionBar();");
		mAdapter = new TabsPagerAdapter(getFragmentManager(), pos);

		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		if (pos < Variables.CATEGORIES.length) {
			tabs = Variables.CATEGORIES[pos];
		} else {
			tabs = Variables.CATEGORIES[0];
		}

		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}

		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	}

}
