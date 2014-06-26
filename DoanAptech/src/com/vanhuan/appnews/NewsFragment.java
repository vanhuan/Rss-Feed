package com.vanhuan.appnews;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.vanhuan.appnews.models.RssItem;
import com.vanhuan.appnews.utils.Variables;

@SuppressLint({ "NewApi", "ValidFragment" })
public class NewsFragment extends Fragment{
	private WebView webview;
	private String link;
	private int posLink;
	private int key;
	private ProgressDialog dialog;
	private List<RssItem> items;
		
	public  NewsFragment(){
		super();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_news,
				container, false);
		posLink=getArguments().getInt(Variables.POSITION);
		key=getArguments().getInt(Variables.KEY);
		int test=getArguments().getInt("TEST");
		
		
		getActivity().setTitle(test+"/"+20);
		
		
		items=Variables.newsMap.get(key);
		//Toast.makeText(getActivity(), items.get(posLink).getLink(), Toast.LENGTH_LONG).show();
		link=items.get(posLink).getLink();
		webview=(WebView) rootView.findViewById(R.id.wvNews);
		webview.getSettings().setSupportZoom(true);
		webview.setInitialScale(1);
		webview.getSettings().setLoadWithOverviewMode(true);
		webview.getSettings().setUseWideViewPort(true);
		webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webview.setScrollbarFadingEnabled(false);	
		webview.setWebViewClient(new DuckyWebViewClient());
		
		dialog=ProgressDialog.show(getActivity(), "", "Loading...");
		webview.loadUrl(link);
		return rootView;
	}
	
	class DuckyWebViewClient extends WebViewClient{

		@Override
		public void onPageFinished(WebView view, String url) {
			if(dialog!=null){
				dialog.dismiss();
			}
			super.onPageFinished(view, url);
		}
		
	}
	
}