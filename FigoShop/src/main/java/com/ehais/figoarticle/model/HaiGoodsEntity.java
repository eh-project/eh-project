package com.ehais.figoarticle.model;

import java.util.List;

public class HaiGoodsEntity {
	
	private HaiGoodsWithBLOBs goods;
	private List<HaiGoodsAttr> goodsAttrList;
	private List<HaiGoodsGallery> goodsGalleryList;
	public HaiGoodsWithBLOBs getGoods() {
		return goods;
	}
	public void setGoods(HaiGoodsWithBLOBs goods) {
		this.goods = goods;
	}
	public List<HaiGoodsGallery> getGoodsGalleryList() {
		return goodsGalleryList;
	}
	public void setGoodsGalleryList(List<HaiGoodsGallery> goodsGalleryList) {
		this.goodsGalleryList = goodsGalleryList;
	}
	public List<HaiGoodsAttr> getGoodsAttrList() {
		return goodsAttrList;
	}
	public void setGoodsAttrList(List<HaiGoodsAttr> goodsAttrList) {
		this.goodsAttrList = goodsAttrList;
	}

	
}
