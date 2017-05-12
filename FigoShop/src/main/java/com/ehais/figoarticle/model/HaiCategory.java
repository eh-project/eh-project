package com.ehais.figoarticle.model;

import java.util.List;

public class HaiCategory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_category.cat_id
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    private Integer catId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_category.cat_name
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    private String catName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_category.keywords
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    private String keywords;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_category.cat_desc
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    private String catDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_category.parent_id
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_category.sort_order
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    private Short sortOrder;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_category.is_show
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    private Boolean isShow;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_category.category_url
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    private String categoryUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_category.brand_id
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    private String brandId;
    
    
    private List<HaiCategory> children;
    

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_category.cat_id
     *
     * @return the value of hai_category.cat_id
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public Integer getCatId() {
        return catId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_category.cat_id
     *
     * @param catId the value for hai_category.cat_id
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_category.cat_name
     *
     * @return the value of hai_category.cat_name
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public String getCatName() {
        return catName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_category.cat_name
     *
     * @param catName the value for hai_category.cat_name
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public void setCatName(String catName) {
        this.catName = catName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_category.keywords
     *
     * @return the value of hai_category.keywords
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_category.keywords
     *
     * @param keywords the value for hai_category.keywords
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_category.cat_desc
     *
     * @return the value of hai_category.cat_desc
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public String getCatDesc() {
        return catDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_category.cat_desc
     *
     * @param catDesc the value for hai_category.cat_desc
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_category.parent_id
     *
     * @return the value of hai_category.parent_id
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_category.parent_id
     *
     * @param parentId the value for hai_category.parent_id
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_category.sort_order
     *
     * @return the value of hai_category.sort_order
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public Short getSortOrder() {
        return sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_category.sort_order
     *
     * @param sortOrder the value for hai_category.sort_order
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public void setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_category.is_show
     *
     * @return the value of hai_category.is_show
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public Boolean getIsShow() {
        return isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_category.is_show
     *
     * @param isShow the value for hai_category.is_show
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_category.category_url
     *
     * @return the value of hai_category.category_url
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public String getCategoryUrl() {
        return categoryUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_category.category_url
     *
     * @param categoryUrl the value for hai_category.category_url
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_category.brand_id
     *
     * @return the value of hai_category.brand_id
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_category.brand_id
     *
     * @param brandId the value for hai_category.brand_id
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

	public List<HaiCategory> getChildren() {
		return children;
	}

	public void setChildren(List<HaiCategory> children) {
		this.children = children;
	}
    
    
}