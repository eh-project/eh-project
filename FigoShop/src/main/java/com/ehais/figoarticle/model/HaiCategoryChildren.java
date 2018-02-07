package com.ehais.figoarticle.model;

import java.util.List;

public class HaiCategoryChildren extends HaiCategory {

	
	private static final long serialVersionUID = 142326890709229740L;
	private List<HaiCategory> children;

	public List<HaiCategory> getChildren() {
		return children;
	}

	public void setChildren(List<HaiCategory> children) {
		this.children = children;
	}
	
	
	
}
