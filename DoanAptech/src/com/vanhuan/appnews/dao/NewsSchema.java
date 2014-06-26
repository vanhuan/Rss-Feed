package com.vanhuan.appnews.dao;

import android.database.sqlite.SQLiteDatabase;

public class NewsSchema {
	
	public static final String TABLE_SITE_NAME="Site";
	public static final String SITE_ID="siteID";
	public static final String SITE_NAME="siteName";
	public static final String SITE_ICON="siteIcon";
	
	public static final String TABLE_RSS_NAME="Rss";
	public static final String RSS_ID="rssID";
	public static final String RSS_ID_F="rssIDF";
	public static final String RSS_CATE_NAME="rssCateName";
	public static final String RSS_CATE_LINK="rssCateLink";
	
	private static final String DATABASE_CREATE_SITE="CREATE TABLE "
			+ TABLE_SITE_NAME + " (" + SITE_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT , " + SITE_NAME
			+ " TEXT, " + SITE_ICON + " TEXT )";
	
	private static final String DATABASE_CREATE_RSS="CREATE TABLE "
			+ TABLE_RSS_NAME + " (" + RSS_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT , " + RSS_ID_F
			+ " INTEGER CONSTRAINT "+ RSS_ID_F 
			+ " REFERENCES " + TABLE_SITE_NAME 
			+ "( " + SITE_ID + " ) ON DELETE CASCADE, " + RSS_CATE_NAME
			+ " TEXT, " + RSS_CATE_LINK + " TEXT )";
	private static final String CREATE_DATA_SITE="INSERT INTO "
			+ TABLE_SITE_NAME + " ( "+ SITE_NAME +", "+ SITE_ICON +" ) "+" VALUES "
			+ "('Tin tức 24h', '0'), "
			+ "('VietNamNet', '1'), "
			+ "('Kênh 14', '2'), "
			+ "('Báo mới', '3'), "
			+ "('VNExpress', '4'), "
			+ "('Hài VL', '5')";	
	private static final String CREATE_DATA_RSS="INSERT INTO "
			+ TABLE_RSS_NAME + " ( "+ RSS_ID_F + ", "+ RSS_CATE_NAME +", "+ RSS_CATE_LINK +" ) "+" VALUES "
			+ "(1,'Tin trong ngày', 'http://www.24h.com.vn/upload/rss/tintuctrongngay.rss'), "
			+ "(1,'Bóng đá', 'http://www.24h.com.vn/upload/rss/bongda.rss'),  "
			+ "(1,'Thời trang', 'http://www.24h.com.vn/upload/rss/thoitrang.rss'),  "
			+ "(1,'TT Hi-tech', 'http://www.24h.com.vn/upload/rss/thoitranghitech.rss'), "			
			+ "(2,'Chính trị', 'http://vietnamnet.vn/rss/chinh-tri.rss'), "
			+ "(2,'Xã hội', 'http://vietnamnet.vn/rss/xa-hoi.rss'), "
			+ "(2,'CNTT-Viễn thông', 'http://vietnamnet.vn/rss/cong-nghe-thong-tin-vien-thong.rsss'), "
			+ "(2,'Quốc tế', 'http://vietnamnet.vn/rss/quoc-te.rss'), "
			+ "(2,'Giáo dục', 'http://vietnamnet.vn/rss/giao-duc.rss')";
			
			
			
	
	public static void onCreate(SQLiteDatabase db){
		db.execSQL(DATABASE_CREATE_SITE);
		db.execSQL(DATABASE_CREATE_RSS);
		db.execSQL(CREATE_DATA_SITE);
		db.execSQL(CREATE_DATA_RSS);
	}
}

