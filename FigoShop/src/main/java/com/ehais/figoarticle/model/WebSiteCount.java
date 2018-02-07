package com.ehais.figoarticle.model;

import java.io.Serializable;

public class WebSiteCount implements Serializable{
	
	public Integer count;
	public Integer websiteId;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(Integer websiteId) {
		this.websiteId = websiteId;
	}
	
	

}
