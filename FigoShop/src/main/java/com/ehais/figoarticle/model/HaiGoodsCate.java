package com.ehais.figoarticle.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HaiGoodsCate implements Serializable {

    private Long goodsId;
    private Integer catId;
    private String calculate;
    private Integer shopPrice;
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public String getCalculate() {
		return calculate;
	}
	public void setCalculate(String calculate) {
		this.calculate = calculate;
	}
	public Integer getShopPrice() {
		return shopPrice;
	}
	public void setShopPrice(Integer shopPrice) {
		this.shopPrice = shopPrice;
	}

    
}