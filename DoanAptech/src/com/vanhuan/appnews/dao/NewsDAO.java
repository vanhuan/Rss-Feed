package com.vanhuan.appnews.dao;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vanhuan.appnews.entity.RssEntity;
import com.vanhuan.appnews.entity.SiteEntity;
import com.vanhuan.appnews.utils.Constant;

public class NewsDAO {
	private final SQLiteDatabase db;
	
	public NewsDAO(Context context, int mode){
		super();
		if(mode==Constant.MODE_WRITE){
			this.db=CreateDatabase.openWrite(context);
		}else{
			this.db=CreateDatabase.openRead(context);
		}
	}
	
	public long insertSite(SiteEntity siteEntity){
		ContentValues contentValues=new ContentValues();
		contentValues.put(NewsSchema.SITE_NAME, siteEntity.getSiteName());
		contentValues.put(NewsSchema.SITE_ICON, siteEntity.getSiteIcon());
		long rowId=db.insertWithOnConflict(NewsSchema.TABLE_SITE_NAME, null, contentValues, SQLiteDatabase.CONFLICT_IGNORE);
		return rowId;
	}
	
	public long insertRss(RssEntity rssEntity){
		ContentValues contentValues=new ContentValues();
		contentValues.put(NewsSchema.RSS_ID, rssEntity.getRssID());
		contentValues.put(NewsSchema.RSS_CATE_NAME, rssEntity.getRssCateName());
		contentValues.put(NewsSchema.RSS_CATE_LINK, rssEntity.getRssCateLink());
		long rowId=db.insertWithOnConflict(NewsSchema.TABLE_RSS_NAME, null, contentValues, SQLiteDatabase.CONFLICT_IGNORE);
		return rowId;
	}
	
	public long updateSite(SiteEntity siteEntity){
		ContentValues contentValues=new ContentValues();
		contentValues.put(NewsSchema.SITE_ID, siteEntity.getSiteID());
		contentValues.put(NewsSchema.SITE_NAME, siteEntity.getSiteName());
		contentValues.put(NewsSchema.SITE_ICON, siteEntity.getSiteIcon());
		long rowAffected=db.update(NewsSchema.TABLE_SITE_NAME, contentValues, NewsSchema.SITE_ID+ " = ?", new String[]{String.valueOf(siteEntity.getSiteID())});
		return rowAffected;
	}
	
	public long updateRss(RssEntity rssEntity){
		ContentValues contentValues=new ContentValues();
		contentValues.put(NewsSchema.RSS_ID, rssEntity.getRssID());
		contentValues.put(NewsSchema.RSS_CATE_NAME, rssEntity.getRssCateName());
		contentValues.put(NewsSchema.RSS_CATE_LINK, rssEntity.getRssCateLink());
		long rowAffected=db.update(NewsSchema.TABLE_RSS_NAME, contentValues, NewsSchema.RSS_ID+" =?", new String[]{String.valueOf(rssEntity.getRssID())});
		return rowAffected;
	}
	
	public long deleteSite(SiteEntity siteEntity){
		ContentValues contentValues=new ContentValues();
		contentValues.put(NewsSchema.SITE_ID, siteEntity.getSiteID());
		long rowDelete=db.delete(NewsSchema.TABLE_SITE_NAME, NewsSchema.SITE_ID+" =?", new String[]{String.valueOf(siteEntity.getSiteID())});
		return rowDelete;
	}
	
	public long deleteRss(RssEntity rssEntity){
		ContentValues contentValues=new ContentValues();
		contentValues.put(NewsSchema.RSS_ID, rssEntity.getRssID());
		long rowDelete=db.delete(NewsSchema.TABLE_RSS_NAME, NewsSchema.RSS_ID+" =?", new String[]{String.valueOf(rssEntity.getRssID())});
		return rowDelete;
	}
	
	public ArrayList<SiteEntity> getAllSite(){
		ArrayList<SiteEntity> siteList=new ArrayList<SiteEntity>();
		String query="SELECT * FROM "+NewsSchema.TABLE_SITE_NAME;
		Cursor cursor=db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			do{
				SiteEntity siteEntity=new SiteEntity(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
				siteList.add(siteEntity);
			}while(cursor.moveToNext());
		}
		cursor.close();
		return siteList;
	}
	
	public String[] getColumn(int pos){
		String[] varS=new String[1000];
		String query;
		if(pos==0){
			query="SELECT siteName FROM "+NewsSchema.TABLE_SITE_NAME;
		}else{
			query="SELECT siteIcon FROM "+NewsSchema.TABLE_SITE_NAME;
		}
		Cursor cursor=db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			int i=0;
			do{
				String varTam=cursor.getString(1);
				varS[i]=varTam;
				i++;
			}while(cursor.moveToNext());
		}
		cursor.close();
		return varS;
	}
	
	public ArrayList<String> getSiteInfo(int pos){
		ArrayList<String> siteList=new ArrayList<String>();
		String query="SELECT * FROM "+NewsSchema.TABLE_SITE_NAME;
		Cursor cursor=db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			do{
				String arrTam;
				if(pos==0){
					arrTam=cursor.getString(1);
					siteList.add(arrTam);
				}else{
					arrTam=cursor.getString(2);
					siteList.add(arrTam);
				}				
			}while(cursor.moveToNext());
		}
		cursor.close();
		return siteList;
	}
	
	public String[] getSiteIcon(){
		String[] varS=new String[10000];
		String query="SELECT siteName FROM "+NewsSchema.TABLE_SITE_NAME;
		Cursor cursor=db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			int i=0;
			do{
				varS[i]=cursor.getString(1);
				i++;
			}while(cursor.moveToNext());
		}
		cursor.close();
		return varS;
	}
	
	
	public ArrayList<RssEntity> getAllRss(){
		ArrayList<RssEntity> rssList=new ArrayList<RssEntity>();
		String query="SELECT * FROM "+NewsSchema.TABLE_RSS_NAME;
		Cursor cursor=db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			do{
				RssEntity rssEntity=new RssEntity(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
				rssList.add(rssEntity);
			}while(cursor.moveToNext());
		}
		cursor.close();
		return rssList;
	}
	
	
}
