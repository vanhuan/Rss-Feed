package com.vanhuan.appnews.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CreateDatabase {
	
	private final String TAG="DBAdapter";
	
	private static DBAdapterHelper dbHelper;
	
	public static SQLiteDatabase openWrite(Context context){
		if(null==dbHelper)
			dbHelper=DBAdapterHelper.getInstance(context);
		final SQLiteDatabase sqliteDb=dbHelper.getWritableDatabase();
		return sqliteDb;
	}
	public static SQLiteDatabase openRead(Context context){
		if(null==dbHelper)
			dbHelper=DBAdapterHelper.getInstance(context);
		final SQLiteDatabase sqliteDb=dbHelper.getReadableDatabase();
		return sqliteDb;
	}

}
