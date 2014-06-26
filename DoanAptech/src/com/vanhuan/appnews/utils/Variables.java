package com.vanhuan.appnews.utils;

import java.util.HashMap;
import java.util.List;

import com.vanhuan.appnews.R;
import com.vanhuan.appnews.models.RssItem;
import com.vanhuan.appnews.service.NewsService;

public class Variables {

	public static final String[] PAPERS = {"Tin tức 24h", "VietNamNet", "Kênh 14", "Báo mới", "VN Express", "Hài VL"};
	public static final int[] ICONS = {R.drawable.ic_home, R.drawable.ic_communities, R.drawable.ic_pages, R.drawable.ic_people, R.drawable.ic_photos, R.drawable.ic_whats_hot};
	
	//hn.24h
	public static final String[] HN24H_CATEGORIES = {
		"Tin trong ngày",
		"Bóng đá",
		"Thời trang",
		"TT Hi-tech"};
	public static final String[] HN24H_LINKS = {
		"http://www.24h.com.vn/upload/rss/tintuctrongngay.rss",
		"http://www.24h.com.vn/upload/rss/bongda.rss",
		"http://www.24h.com.vn/upload/rss/thoitrang.rss",
		"http://www.24h.com.vn/upload/rss/thoitranghitech.rss"};
	
	//vietnamnet
	public static final String[] VNNET_CATEGORIES = {
		"Chính trị",
		"Xã hội",
		"CNTT-Viễn thông",
		"Quốc tế",
		"Giáo dục"};
	public static final String[] VNNET_LINKS = {
		"http://vietnamnet.vn/rss/chinh-tri.rss",
		"http://vietnamnet.vn/rss/xa-hoi.rss",
		"http://vietnamnet.vn/rss/cong-nghe-thong-tin-vien-thong.rss",
		"http://vietnamnet.vn/rss/quoc-te.rss",
		"http://vietnamnet.vn/rss/giao-duc.rss"};
	
	public static final String[][] CATEGORIES = {HN24H_CATEGORIES,VNNET_CATEGORIES};
	public static final String[][] LINKS = {HN24H_LINKS,VNNET_LINKS};

	
	public static final String PAPER = "paper";
	public static final String CATEGORY = "category";
	public static final String LINK = "link";
	public static final String KEY = "key";
	public static final String POSITION = "position";
	
	public static HashMap<Integer, List<RssItem>> newsMap = new HashMap<Integer, List<RssItem>>();
}
