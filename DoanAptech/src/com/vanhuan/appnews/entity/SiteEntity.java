package com.vanhuan.appnews.entity;

public class SiteEntity {
	
	private int siteID;
	private String siteName,siteIcon;
	
	public SiteEntity(int _siteID, String _siteName, String _siteIcon){
		super();
		this.siteID=_siteID;
		this.siteName=_siteName;
		this.siteIcon=_siteIcon;
	}

	/**
	 * @return the siteID
	 */
	public int getSiteID() {
		return siteID;
	}

	/**
	 * @param siteID the siteID to set
	 */
	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}

	/**
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * @param siteName the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/**
	 * @return the siteIcon
	 */
	public String getSiteIcon() {
		return siteIcon;
	}

	/**
	 * @param siteIcon the siteIcon to set
	 */
	public void setSiteIcon(String siteIcon) {
		this.siteIcon = siteIcon;
	}

	
}
