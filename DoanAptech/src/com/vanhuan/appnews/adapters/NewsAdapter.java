package com.vanhuan.appnews.adapters;

import java.io.InputStream;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vanhuan.appnews.R;
import com.vanhuan.appnews.image.ImageLoader;
import com.vanhuan.appnews.models.RssItem;

public class NewsAdapter extends ArrayAdapter<RssItem> {

	private Context context;
	private List<RssItem> items;
	private int ivIcon;
	private ImageView imageView, imgArrow, imgRead;
	private ImageLoader imageLoader;

	// TextView tvDesc;

	public NewsAdapter(Context context, int textViewResourceId,
			List<RssItem> items) {
		super(context, textViewResourceId, items);
		this.context = context;
		this.ivIcon = ivIcon;
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.activity_news, parent, false);
		imageLoader = new ImageLoader(getContext());
		imageView = (ImageView) v.findViewById(R.id.ivIcon);
		imgRead = (ImageView) v.findViewById(R.id.imgRead);

		TextView tv = (TextView) v.findViewById(R.id.tvNews);
		final TextView tvdate = (TextView) v.findViewById(R.id.tvDate);
		final TextView tvDesc = (TextView) v.findViewById(R.id.tvDesc);
		// Button btnClick=(Button) v.findViewById(R.id.viewFull);
		// String
		// a=items.get(position).getDescription().replaceAll("\\<[^>]*>","");
		// tv.setText(android.text.Html.fromHtml(a));
		tv.setText(items.get(position).getTitle());
		// tvDesc.setText(android.text.Html.fromHtml(removeHTML(items.get(position).getDescription())));
		tvdate.setText(items.get(position).getDate());
		// tv.setHeight(150);
		tvDesc.setText(android.text.Html.fromHtml(removeHTML(items
				.get(position).getDescription())));
		tvDesc.setVisibility(View.GONE);
		imageLoader.DisplayImage(items.get(position).getImg(), imageView);
		// new
		// DownloadImageTask(imageView).execute("http://img-hn.24hstatic.com"+items.get(position).getImg());
		imgRead.setOnClickListener(new OnClickListener() {
			int i = 0;

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Animation ani = AnimationUtils.loadAnimation(getContext(),
						R.anim.slide_in_up);
				Animation ani1 = AnimationUtils.loadAnimation(getContext(),
						android.R.anim.fade_out);

				// TODO Auto-generated method stub
				if (i == 0) {
					tvDesc.setAnimation(ani);
					tvDesc.setVisibility(View.VISIBLE);
					i++;
				} else {
					tvDesc.setAnimation(ani1);
					tvDesc.setVisibility(View.GONE);
					i = 0;
				}
			}
		});
		/*
		 * btnClick.setOnClickListener(new OnClickListener() { int i=0;
		 * 
		 * @Override public void onClick(View v) {
		 * 
		 * Animation ani=AnimationUtils.loadAnimation(getContext(),
		 * R.anim.slide_in_up); Animation
		 * ani1=AnimationUtils.loadAnimation(getContext(),
		 * android.R.anim.fade_out);
		 * 
		 * 
		 * // TODO Auto-generated method stub if (i==0){
		 * tvDesc.setAnimation(ani); tvDesc.setVisibility(View.VISIBLE); i++;
		 * }else{ tvDesc.setAnimation(ani1); tvDesc.setVisibility(View.GONE);
		 * i=0; }
		 * 
		 * 
		 * } });
		 */

		return v;
	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView bmImage;

		public DownloadImageTask(ImageView bmImage) {
			this.bmImage = bmImage;

		}

		protected Bitmap doInBackground(String... urls) {
			String urldisplay = urls[0];
			Bitmap mIcon11 = null;
			try {
				InputStream in = new java.net.URL(urldisplay).openStream();
				mIcon11 = BitmapFactory.decodeStream(in);
			} catch (Exception e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return mIcon11;
		}

		protected void onPostExecute(Bitmap result) {
			bmImage.setImageBitmap(result);
		}
	}

	public static String removeHTML(String htmlString) {
		// Remove HTML tag from java String
		String noHTMLString = htmlString.replaceAll("\\<.*?\\>", "");

		// Remove Carriage return from java String
		noHTMLString = noHTMLString.replaceAll("\r", "<br/>");
		noHTMLString = noHTMLString.replaceAll("<([bip])>.*?</\1>", "");
		// Remove New line from java string and replace html break
		noHTMLString = noHTMLString.replaceAll("\n", " ");
		noHTMLString = noHTMLString.replaceAll("\"", "&quot;");
		noHTMLString = noHTMLString.replaceAll("<(.*?)\\>", " ");// Removes all
																	// items in
																	// brackets
		noHTMLString = noHTMLString.replaceAll("<(.*?)\\\n", " ");// Must be
																	// undeneath
		noHTMLString = noHTMLString.replaceFirst("(.*?)\\>", " ");
		noHTMLString = noHTMLString.replaceAll("&nbsp;", " ");
		noHTMLString = noHTMLString.replaceAll("&amp;", " ");
		return noHTMLString;

	}

}
