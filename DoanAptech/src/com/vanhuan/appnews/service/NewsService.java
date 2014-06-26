package com.vanhuan.appnews.service;

import java.util.ArrayList;

import android.content.Context;

import com.vanhuan.appnews.dao.NewsDAO;
import com.vanhuan.appnews.entity.RssEntity;
import com.vanhuan.appnews.entity.SiteEntity;
import com.vanhuan.appnews.utils.Constant;

public class NewsService {
	private Context context;
	
	public NewsService(Context _context){
		this.context=_context;
		new NewsDAO(context, Constant.MODE_WRITE);
	}
	
	public boolean insertSite(SiteEntity siteEntity){
		NewsDAO newsDAO=new NewsDAO(context, Constant.MODE_WRITE);
		long rowId=newsDAO.insertSite(siteEntity);
		if(rowId>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean insertRss(RssEntity rssEntity){
		NewsDAO newsDAO=new NewsDAO(context, Constant.MODE_WRITE);
		long rowId=newsDAO.insertRss(rssEntity);
		if(rowId>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean updateSite(SiteEntity siteEntity){
		NewsDAO newsDAO=new NewsDAO(context, Constant.MODE_WRITE);
		long rowAffected=newsDAO.updateSite(siteEntity);
		if(rowAffected>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean updateRss(RssEntity rssEntity){
		NewsDAO newsDAO=new NewsDAO(context, Constant.MODE_WRITE);
		long rowAffected=newsDAO.updateRss(rssEntity);
		if(rowAffected>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean deleteSite(SiteEntity siteEntity){
		NewsDAO siteDAO=new NewsDAO(context, Constant.MODE_WRITE);
		long rowDelete=siteDAO.deleteSite(siteEntity);
		if(rowDelete>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean deleteRss(RssEntity rssEntity){
		NewsDAO rssDAO=new NewsDAO(context, Constant.MODE_WRITE);
		long rowDelete=rssDAO.deleteRss(rssEntity);
		if(rowDelete>0){
			return true;
		}else{
			return false;
		}
	}
	
	public ArrayList<SiteEntity> getAllSite(){
		NewsDAO siteDAO=new NewsDAO(context, Constant.MODE_READ);
		return siteDAO.getAllSite();
	}
	public ArrayList<RssEntity> getAllRss(){
		NewsDAO rssDAO=new NewsDAO(context, Constant.MODE_READ);
		return rssDAO.getAllRss();
	}
	
	public String[] getColumn(int pos){
		NewsDAO siteDAO=new NewsDAO(context, Constant.MODE_READ);
		return siteDAO.getColumn(pos);
	}
	
	public ArrayList<String> getSiteInfo(int pos){
		NewsDAO newsDAO=new NewsDAO(context,Constant.MODE_READ);
		return newsDAO.getSiteInfo(pos);
	}
	
	
}
