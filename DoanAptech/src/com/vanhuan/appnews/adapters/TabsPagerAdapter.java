package com.vanhuan.appnews.adapters;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;

import com.vanhuan.appnews.ListNewFragment;
import com.vanhuan.appnews.models.RssItem;
import com.vanhuan.appnews.utils.RssParser;
import com.vanhuan.appnews.utils.Variables;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	
	int count;
	private int paper;
	private ProgressDialog dialog;

	public TabsPagerAdapter(FragmentManager fm, int pos) {
		super(fm);
		this.paper=pos;
	}

	@SuppressLint("NewApi")
	@Override
	public Fragment getItem(int index) {
		
			for(int i =0;i<Variables.CATEGORIES[paper].length;i++){
				if(index==i){
		
					Bundle bundle=new Bundle();
					bundle.putInt(Variables.CATEGORY, index);					
					bundle.putInt(Variables.PAPER, paper);
					ListNewFragment game=new ListNewFragment();
					game.setArguments(bundle);
					return game;
					

				}
				
			}
			return null;
			/*Bundle bundle=new Bundle();
			bundle.putInt(Variables.CATEGORY, index);
			bundle.putInt(Variables.PAPER, paper);
			ListNewFragment game=new ListNewFragment();
			game.setArguments(bundle);
			return game;*/

	}

	@Override
	public int getCount() {
		return Variables.CATEGORIES[paper].length;
	}
	
		

}
