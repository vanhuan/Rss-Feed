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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.vanhuan.appnews.adapters.TabsNewsAdapter;
import com.vanhuan.appnews.adapters.TabsPagerAdapter;
import com.vanhuan.appnews.utils.Variables;

@SuppressLint("NewApi")
public class ArticleActivity extends Activity implements TabListener {

	private ViewPager viewPager;
	private TabsNewsAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitytab_article);
		
		Intent i=getIntent();
		int pos=i.getIntExtra(Variables.POSITION, 0);
		int key=i.getIntExtra(Variables.KEY, 0);
		//Toast.makeText(getApplicationContext(), String.valueOf(pos), Toast.LENGTH_SHORT).show();

		viewPager = (ViewPager) findViewById(R.id.tabarticle);

		mAdapter = new TabsNewsAdapter(getFragmentManager(),pos,key);

		viewPager.setAdapter(mAdapter);

		


		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {

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

	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {
		case R.menu.article:
			Toast.makeText(getApplicationContext(), "Share Facebook", Toast.LENGTH_LONG).show();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	

}
