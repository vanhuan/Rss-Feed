package com.vanhuan.appnews.entity;

public class RssEntity {

	private int rssID;
	private String rssCateName, rssCateLink;
	
	public RssEntity(int _rssID, String _rssCateName, String _rssCateLink){
		super();
		this.rssID=_rssID;
		this.rssCateName=_rssCateName;
		this.rssCateLink=_rssCateLink;
	}

	/**
	 * @return the rssID
	 */
	public int getRssID() {
		return rssID;
	}

	/**
	 * @param rssID the rssID to set
	 */
	public void setRssID(int rssID) {
		this.rssID = rssID;
	}

	/**
	 * @return the rssCateName
	 */
	public String getRssCateName() {
		return rssCateName;
	}

	/**
	 * @param rssCateName the rssCateName to set
	 */
	public void setRssCateName(String rssCateName) {
		this.rssCateName = rssCateName;
	}

	/**
	 * @return the rssCateLink
	 */
	public String getRssCateLink() {
		return rssCateLink;
	}

	/**
	 * @param rssCateLink the rssCateLink to set
	 */
	public void setRssCateLink(String rssCateLink) {
		this.rssCateLink = rssCateLink;
	}

	
}
