package com.vanhuan.appnews.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.vanhuan.appnews.models.RssItem;

public class RssHandler extends DefaultHandler {
	
	private RssItem item;
	private List<RssItem> itemList = new ArrayList<RssItem>();
	private StringBuffer sBuffer = new StringBuffer();
	private boolean started = false;
	public static String ITEM = "item";
	public static String TITLE = "title";
	public static String DESCRIPTION = "description";
	public static String LINK = "link";
	public static String PUBDATE = "pubDate";
	public static String SUMARYIMG = "summaryImg";

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		if (started && (sBuffer != null)) {
			sBuffer.append(ch, start, length);
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if (localName.equalsIgnoreCase(ITEM)) {
			started = true;
			item = new RssItem();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		if (localName.equalsIgnoreCase(ITEM)) {
			itemList.add(item);
			started = false;
		} else if (started) {
			if (localName.equalsIgnoreCase(TITLE)) {
				item.setTitle(sBuffer.toString().trim());
			} else if (localName.equalsIgnoreCase(DESCRIPTION)) {
				item.setDescription(sBuffer.toString().trim());
			} else if (localName.equalsIgnoreCase(PUBDATE)) {
				item.setDate(sBuffer.toString().trim());
			} else if (localName.equalsIgnoreCase(LINK)) {
				item.setLink(sBuffer.toString().trim());
			} else if (localName.equalsIgnoreCase(SUMARYIMG)) {
				item.setImg("http://img-hn.24hstatic.com"+sBuffer.toString().trim());
			} else if(!localName.equalsIgnoreCase(SUMARYIMG)){				
				item.setImg(extractUrls(item.getDescription()));
			}
			sBuffer = new StringBuffer();
		}
	}

	public List<RssItem> getItemList() {
		return itemList;
	}

	 public static String extractUrls(String input) {

	        String result = null;
	        Pattern pattern = Pattern.compile(
	            "\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)" + 
	            "(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|gov" + 
	            "|mil|biz|info|mobi|name|aero|jobs|museum" + 
	            "|travel|[a-z]{2}))(:[\\d]{1,5})?" + 
	            "(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?" + 
	            "((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" + 
	            "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)" + 
	            "(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" + 
	            "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*" + 
	            "(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b");

	        Matcher matcher = pattern.matcher(input);
	        if (matcher.find()) {
	            result=matcher.group();
	        }
	        return result;
	    }
	
	

	
}
