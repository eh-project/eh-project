package com.ehais.bean;

import java.util.List;
import java.util.Map;

public class Goods {

	private Integer goodsId;
	private String goodsName;
	private String actDesc;
	private String goodsSN;
	private String categoryName;
	private String brandName;
	private String colorJson;
	private String sizeJson;
	private String image;
	private String price;
	private String market_price;
	private String shop_price;
	private String promote_price;
	private String cost_price;
	private String content;
	private String goods_desc;
	
	private String currency;
	private String exchangeRate;
	private String profit;
	private String profitType;
	private String shipping;
	
	private String goodsUrl;//商品连接页面

	private String storeId;
	
	
	
	
	private List<String> thumbImage;//缩略图,首页或列表页显示的图片
	private List<String> goodsImage;//详情页显示的图片
	private List<String> originalImage;//源图
	
	
	
	private String goods_thumb;
	private String goods_img;
	private String original_img;
	
	
	/**
	 * 相册
	 * Map.put("thumb","");
	 * Map.put("img","");
	 * Map.put("original","");
	 */
	public List<Map<String,String>> goods_gallery;

	public Goods() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getColorJson() {
		return colorJson;
	}

	public void setColorJson(String colorJson) {
		this.colorJson = colorJson;
	}

	public String getSizeJson() {
		return sizeJson;
	}

	public void setSizeJson(String sizeJson) {
		this.sizeJson = sizeJson;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public String getProfitType() {
		return profitType;
	}

	public void setProfitType(String profitType) {
		this.profitType = profitType;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getGoodsUrl() {
		return goodsUrl;
	}

	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
	}

	public List<String> getThumbImage() {
		return thumbImage;
	}

	public void setThumbImage(List<String> thumbImage) {
		this.thumbImage = thumbImage;
	}

	public List<String> getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(List<String> goodsImage) {
		this.goodsImage = goodsImage;
	}

	public List<String> getOriginalImage() {
		return originalImage;
	}

	public void setOriginalImage(List<String> originalImage) {
		this.originalImage = originalImage;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getGoodsSN() {
		return goodsSN;
	}

	public void setGoodsSN(String goodsSN) {
		this.goodsSN = goodsSN;
	}

	public String getActDesc() {
		return actDesc;
	}

	public void setActDesc(String actDesc) {
		this.actDesc = actDesc;
	}

	public String getGoods_thumb() {
		return goods_thumb;
	}

	public void setGoods_thumb(String goods_thumb) {
		this.goods_thumb = goods_thumb;
	}

	public String getGoods_img() {
		return goods_img;
	}

	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}

	public String getOriginal_img() {
		return original_img;
	}

	public void setOriginal_img(String original_img) {
		this.original_img = original_img;
	}

	public List<Map<String, String>> getGoods_gallery() {
		return goods_gallery;
	}

	public void setGoods_gallery(List<Map<String, String>> goods_gallery) {
		this.goods_gallery = goods_gallery;
	}

	public String getMarket_price() {
		return market_price;
	}

	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}

	public String getShop_price() {
		return shop_price;
	}

	public void setShop_price(String shop_price) {
		this.shop_price = shop_price;
	}

	public String getPromote_price() {
		return promote_price;
	}

	public void setPromote_price(String promote_price) {
		this.promote_price = promote_price;
	}

	public String getGoods_desc() {
		return goods_desc;
	}

	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}

	public String getCost_price() {
		return cost_price;
	}

	public void setCost_price(String cost_price) {
		this.cost_price = cost_price;
	}

	
	
	
}
