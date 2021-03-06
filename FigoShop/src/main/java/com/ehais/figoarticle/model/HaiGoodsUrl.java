package com.ehais.figoarticle.model;

import java.io.Serializable;

public class HaiGoodsUrl implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_goods_url.goods_url_id
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    private Integer goodsUrlId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_goods_url.cat_id
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    private Integer catId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_goods_url.goods_url
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    private String goodsUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_goods_url.spider_source
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    private String spiderSource;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_goods_url.finish
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    private Boolean finish;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hai_goods_url
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_goods_url.goods_url_id
     *
     * @return the value of hai_goods_url.goods_url_id
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    public Integer getGoodsUrlId() {
        return goodsUrlId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_goods_url.goods_url_id
     *
     * @param goodsUrlId the value for hai_goods_url.goods_url_id
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    public void setGoodsUrlId(Integer goodsUrlId) {
        this.goodsUrlId = goodsUrlId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_goods_url.cat_id
     *
     * @return the value of hai_goods_url.cat_id
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    public Integer getCatId() {
        return catId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_goods_url.cat_id
     *
     * @param catId the value for hai_goods_url.cat_id
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_goods_url.goods_url
     *
     * @return the value of hai_goods_url.goods_url
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    public String getGoodsUrl() {
        return goodsUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_goods_url.goods_url
     *
     * @param goodsUrl the value for hai_goods_url.goods_url
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_goods_url.spider_source
     *
     * @return the value of hai_goods_url.spider_source
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    public String getSpiderSource() {
        return spiderSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_goods_url.spider_source
     *
     * @param spiderSource the value for hai_goods_url.spider_source
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    public void setSpiderSource(String spiderSource) {
        this.spiderSource = spiderSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_goods_url.finish
     *
     * @return the value of hai_goods_url.finish
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    public Boolean getFinish() {
        return finish;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_goods_url.finish
     *
     * @param finish the value for hai_goods_url.finish
     *
     * @mbg.generated Sun Nov 26 11:43:10 CST 2017
     */
    public void setFinish(Boolean finish) {
        this.finish = finish;
    }
}