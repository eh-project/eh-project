package com.ehais.school_weixin.model;

import java.math.BigDecimal;

public class HaiGroupGoods extends HaiGroupGoodsKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_group_goods.goods_price
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private BigDecimal goods_price;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_group_goods.goods_price
	 * @return  the value of hai_group_goods.goods_price
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public BigDecimal getGoods_price() {
		return goods_price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_group_goods.goods_price
	 * @param goods_price  the value for hai_group_goods.goods_price
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setGoods_price(BigDecimal goods_price) {
		this.goods_price = goods_price;
	}
}