package com.vanhuan.appnews;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.vanhuan.appnews.adapters.NewsAdapter;
import com.vanhuan.appnews.models.RssItem;
import com.vanhuan.appnews.utils.RssParser;
import com.vanhuan.appnews.utils.Variables;

@SuppressLint({ "NewApi", "ValidFragment" })
public class ListNewFragment extends Fragment implements OnItemClickListener {
	
	int posCate;
	int posPaper;
	private ProgressDialog dialog;
	private List<RssItem> items;
	ListView lvListNews;
	int key;
	
	public  ListNewFragment(){
		super();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_list_news,
				container, false);
		
		posCate=getArguments().getInt(Variables.CATEGORY);
		posPaper=getArguments().getInt(Variables.PAPER);
		lvListNews=(ListView) rootView.findViewById(R.id.list_news);
		lvListNews.setOnItemClickListener(this);
		//Toast.makeText(getActivity(), String.valueOf(posPaper+" - "+posCate), Toast.LENGTH_SHORT).show();
		
		key=posPaper * 1000 + posCate;
		if(Variables.newsMap.get(key)==null){
			//dialog=ProgressDialog.show(getActivity(),"","Loading "+Variables.CATEGORIES[posPaper][posCate]);
			dialog=ProgressDialog.show(getActivity(),"","Loading... ");
			new CategoryTask().execute(posCate);
		}else{
			NewsAdapter adapter=new NewsAdapter(getActivity(), R.layout.activity_news, items);
			lvListNews.setAdapter(adapter);
		}

		return rootView;
	}
	
	
	
	class CategoryTask extends AsyncTask<Integer, Void, Void>{
		
		private int position;
		private int key;
		@Override
		protected Void doInBackground(Integer... params) {
			position=params[0];
			key=posPaper * 1000 + position;
			RssParser parser=new RssParser();
			List<RssItem> items=parser.getNewsList(Variables.LINKS[posPaper][position]);
			Variables.newsMap.put(key, items);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			if(dialog!=null){
				dialog.dismiss();
			}
			items=Variables.newsMap.get(key);
			NewsAdapter adapter=new NewsAdapter(getActivity(), R.layout.activity_news, items);
			lvListNews.setAdapter(adapter);
			super.onPostExecute(result);
		}		
	}



	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		//Toast.makeText(getActivity(), String.valueOf(arg2), Toast.LENGTH_SHORT).show();
		//Toast.makeText(getActivity(),items.get(arg2).getLink(), Toast.LENGTH_SHORT).show();
		Intent intent=new Intent(getActivity(), ArticleActivity.class);
		intent.putExtra(Variables.POSITION, arg2);
		intent.putExtra(Variables.KEY, key);
		startActivity(intent);
		
		
	}
	
}