package com.vanhuan.appnews.adapters;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v13.app.FragmentPagerAdapter;

import com.vanhuan.appnews.ListNewFragment;
import com.vanhuan.appnews.NewsFragment;
import com.vanhuan.appnews.utils.Variables;

public class TabsNewsAdapter extends FragmentPagerAdapter {
	
	int count;
	private int posArticle;
	private int key;
	private ProgressDialog dialog;

	public TabsNewsAdapter(FragmentManager fm, int pos, int key) {
		super(fm);
		this.posArticle=pos;
		this.key=key;
	}

	@SuppressLint("NewApi")
	@Override
	public Fragment getItem(int index) {

			Bundle bundle=new Bundle();
			bundle.putInt(Variables.POSITION, posArticle);
			bundle.putInt("TEST", index);
			bundle.putInt(Variables.KEY, key);
			NewsFragment article=new NewsFragment();
			article.setArguments(bundle);
			posArticle++;
			
			return article;

	}

	@Override
	public int getCount() {
		return 25;
	}
	
		

}
