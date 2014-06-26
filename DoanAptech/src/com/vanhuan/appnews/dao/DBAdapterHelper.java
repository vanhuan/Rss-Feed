package com.vanhuan.appnews.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapterHelper extends SQLiteOpenHelper{
	
	private static DBAdapterHelper helper;
	
	private static final String DATABASE_NAME="RSSFEED";
	private static final int DATABASE_VERSION=1;
	
	public static DBAdapterHelper getInstance(Context context){
		if(helper==null){
			helper=new DBAdapterHelper(context);
		}
		return helper;
	}
	
	public DBAdapterHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		NewsSchema.onCreate(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
}
